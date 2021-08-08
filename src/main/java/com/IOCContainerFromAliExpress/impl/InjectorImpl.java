package com.IOCContainerFromAliExpress.impl;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.Scanner.ReflectionsScanner.ClassesScanner;
import com.IOCContainerFromAliExpress.interfaces.Injector;
import com.IOCContainerFromAliExpress.interfaces.Provider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InjectorImpl implements Injector {
  private static HashMap<String, Object> existingBeans = new HashMap<>();
  ClassesScanner classesScanner = new ClassesScanner();

  @Override
  public <T> Provider<T> getProvider(Class<T> type) {
    ProviderImpl provider = new ProviderImpl(type);
    return provider;
  }

  @Override
  public <T> Object getBean(Class<T> type) {
    try {
      bind(type);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return existingBeans.get(type.getTypeName());
  }

  @Override
  public <T> void bind(Class<T> type)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException,
          NoSuchMethodException,
          InvocationTargetException {

    Set<Class<?>> classesWithAnnotatedConstructors = classesScanner.getAllClassesWithAnnotations();
    Set<Object> parametersForInjection = new HashSet<>();
    Object finishedObject = null;
    for (Class<?> targetClass : classesWithAnnotatedConstructors) {

      for (Constructor constructor : targetClass.getConstructors()) {

        if (constructor.isAnnotationPresent(Inject.class)) {

          Parameter[] paramsOfThisConstructor = constructor.getParameters();

          for (Parameter parameter : paramsOfThisConstructor) {
            if (!(existingBeans.containsKey(parameter.getType().getTypeName()))) {
              for (Object implementation :
                  classesScanner.getAllImplementations(parameter.getType())) {
                parametersForInjection.add(getProvider((Class) implementation).getInstance());
              }
            }
          }
          finishedObject =
              targetClass
                  .getConstructor(constructor.getParameterTypes())
                  .newInstance(parametersForInjection.toArray());
          existingBeans.put(finishedObject.getClass().getTypeName(), finishedObject);
        }
      }
    }
  }
}
