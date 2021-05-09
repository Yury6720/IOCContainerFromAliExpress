package com.IOCContainerFromAliExpress.Utils;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.interfaces.EventDAO;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class ClassesScanner<T> {
  Reflections reflections = new ReflectionAccessor().getReflections();

  public ClassesScanner() {

  }


  public <T> Set<T> getAllClassesWithAnnotations() {

    Set<Constructor> constructorsAnnotatedWith = reflections.getConstructorsAnnotatedWith(Inject.class);

//    @Depricated
//    Set<Constructor> constructorsAnnotatedWith =
//        new Reflections("com.IOCContainerFromAliExpress", new MethodAnnotationsScanner())
//            .getConstructorsAnnotatedWith(Inject.class);


    Set<T> classesWithAnnotatedConstructor = new HashSet<>();
    for (Constructor constructor : constructorsAnnotatedWith) {
      classesWithAnnotatedConstructor.add((T) constructor.getDeclaringClass());
      System.out.println("This Constructor " + constructor);
    }

    return classesWithAnnotatedConstructor;
  }

  public <T> Set<Class<? extends T>> getAllImplementations(Class<T>intf){
    Set<Class<? extends T>> impl = reflections.getSubTypesOf(intf);
    for (Class clazz : impl) {
      System.out.println("Implementations of EventDAO: " + clazz);
    }
    return (Set<Class<? extends T>>) impl;
  }
}
