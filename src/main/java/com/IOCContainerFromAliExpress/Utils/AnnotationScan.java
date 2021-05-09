package com.IOCContainerFromAliExpress.Utils;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class AnnotationScan  {

  public AnnotationScan() {

  }

  public Set<Class> getAllClassesWithAnnotations() {
    Set<Constructor> constructorsAnnotatedWith = new Reflections("com.IOCContainerFromAliExpress",
            new MethodAnnotationsScanner()).getConstructorsAnnotatedWith(Inject.class);
    Set<Class> classesWithAnnotatedConstructor = new HashSet<>();
    for (Constructor constructor: constructorsAnnotatedWith){
      classesWithAnnotatedConstructor.add(constructor.getClass());
      System.out.println(constructor);
    }

    return classesWithAnnotatedConstructor;
  }
}
