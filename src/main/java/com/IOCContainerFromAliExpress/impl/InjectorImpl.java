package com.IOCContainerFromAliExpress.impl;

import com.IOCContainerFromAliExpress.Scanner.ReflectionsScanner.ClassesScanner;
import com.IOCContainerFromAliExpress.interfaces.Injector;
import com.IOCContainerFromAliExpress.interfaces.Provider;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Set;

public class InjectorImpl implements Injector {
private static HashMap<String,String> hm = new HashMap<>();
    @Override
    public <T> Provider<T> getProvider(Class<T> type) {
        ProviderImpl provider = new ProviderImpl(type);
        return provider;
    }

    @Override
    public <T> void bind() {//Class<T> intf, Class<? extends T> impl
    System.out.println("binding start");

    ClassesScanner classesScanner = new ClassesScanner();
        Set<Class<?>>classesWithAnnotatedConstructors = classesScanner.getAllClassesWithAnnotations();

        for (Class<?> cl: classesWithAnnotatedConstructors){
      System.out.println("1 range");
           // T [] interfaces = (T[]) cl.getInterfaces();
//            for(T interF: interfaces){
//        System.out.println("2 range");
//                System.out.println("Interface in class: " + interF);
//            }
            Constructor[] constructors = cl.getConstructors();
            for (Constructor constructor: constructors){
                Parameter[] parameters = constructor.getParameters();
                for (Parameter parameter: parameters){


          System.out.println(parameter.getDeclaringExecutable());

          System.out.println("Param: " + parameter);
          System.out.println("Param type: " + parameter.getType() );
          Set<Class<?>>implementations = classesScanner.getAllImplementations(parameter.getType());
                }
            }
        }
    }

//    @Override
//    public <T> void bindSingleton(Class<T> intf, Class<? extends T> impl) {
//
//    }
}
