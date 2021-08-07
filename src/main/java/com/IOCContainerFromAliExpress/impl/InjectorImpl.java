package com.IOCContainerFromAliExpress.impl;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.Scanner.ReflectionsScanner.ClassesScanner;
import com.IOCContainerFromAliExpress.interfaces.Injector;
import com.IOCContainerFromAliExpress.interfaces.Provider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Set;

public class InjectorImpl implements Injector {
  private static HashMap<Object, String> existingBeans = new HashMap<>();
    ClassesScanner classesScanner = new ClassesScanner();

  @Override
  public <T> Provider<T> getProvider(Class<T> type) {
    ProviderImpl provider = new ProviderImpl(type);
    return provider;
  }

  @Override
  public <T> Object bind()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException,
          NoSuchMethodException,
          InvocationTargetException { // Class<T> intf, Class<? extends T> impl
    System.out.println("binding start");


    Set<Class<?>> classesWithAnnotatedConstructors = classesScanner.getAllClassesWithAnnotations();
Object finishedObject = null;
    for (Class<?> targetClass : classesWithAnnotatedConstructors) {

      for (Constructor constructor : targetClass.getConstructors()) {

        if (constructor.isAnnotationPresent(Inject.class)) {

          Parameter[] paramsOfThisConstructor = constructor.getParameters();

          for (Parameter parameter : paramsOfThisConstructor) {
            if (!(existingBeans.containsKey(parameter))) {
              for (Object implementation :
                  classesScanner.getAllImplementations(parameter.getType())) {
                existingBeans.put(
                    getProvider((Class) implementation).getInstance(),
                    parameter.getType().getSimpleName());
                System.out.println("existing beans : " + existingBeans);
              }
            }
          }
          finishedObject = targetClass.getConstructor(constructor.getParameterTypes()).newInstance(paramsOfThisConstructor);
        }
      }
      //            Constructor[] constructors = cl.getConstructors();
      //            for (Constructor constructor: constructors){
      //                Parameter[] parameters = constructor.getParameters();
      //                for (Parameter parameter: parameters){
      //
      //
      //          System.out.println(parameter.getDeclaringExecutable());
      //
      //          System.out.println("Param: " + parameter);
      //          System.out.println("Param type: " + parameter.getType() );
      //          Set<Class<?>>implementations =
      // classesScanner.getAllImplementations(parameter.getType());
      //          System.out.println("impls" + implementations);
      //                }
      //            }
    }
return finishedObject;
  }

  //    @Override
  //    public <T> void bindSingleton(Class<T> intf, Class<? extends T> impl) {
  //
  //    }
}
