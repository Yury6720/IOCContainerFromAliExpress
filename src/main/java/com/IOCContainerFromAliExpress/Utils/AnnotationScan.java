package com.IOCContainerFromAliExpress.Utils;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.Constructor;
import java.util.Set;

public class AnnotationScan  {

  public AnnotationScan() {

  }

  public Set<Constructor> getAllClassesWithAnnotations() {
    //Reflections reflections = new Reflections();//(Main.class.getPackage().getName());
    Set<Constructor> consAnnotatedWith = new Reflections("com.IOCContainerFromAliExpress",
            new MethodAnnotationsScanner()).getConstructorsAnnotatedWith(Inject.class);
//    Iterator iterator = (Iterator) reflections.getAllTypes();
//    while (iterator.hasNext()){
//      Object cl = iterator.next();
//      reflections.g
//    }
    return consAnnotatedWith;//reflections.getConstructorsAnnotatedWith(Inject.class);
  }
}
