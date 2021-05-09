//package com.IOCContainerFromAliExpress.Annotations;
//
//import com.IOCContainerFromAliExpress.Utils.AnnotationScan;
//import java.util.Iterator;
//import java.util.Set;
//
//public class AnnotationExistenceChecker {
//
//  Set<Class<?>> classesWithAnnotations = new AnnotationScan().getAllClassesWithAnnotations();
//
//  public AnnotationExistenceChecker() throws ClassNotFoundException {}
//
//  Iterator iterator = classesWithAnnotations.iterator();
//
//  public void check() {
//    while (iterator.hasNext()) {
//      Object cl =iterator.next();
//      String name = cl.toString();
//System.out.println(name);
//    }
//
//
//
//
//
////      boolean check() {
////        if (!cl.isAnnotationPresent(Inject.class)) {
////          System.err.println("no annotation");
////        } else {
////          System.out.println("class annotated ; name  -  " +
////     cl.getAnnotation(ControlledObject.class));
////        }
////        boolean hasStart = false;
////        boolean hasStop = false;
////        Method[] method = cl.getMethods();
////        for (Method md : method) {
////          if (md.isAnnotationPresent(StartObject.class)) {
////            hasStart = true;
////          }
////          if (md.isAnnotationPresent(StopObject.class)) {
////            hasStop = true;
////          }
////          if (hasStart && hasStop) {
////            break;
////          }
////        }
////        System.out.println("Start annotaton  - " + hasStart + ";  Stop annotation  - " + hasStop);
////      }
////    return;
//  }
//}