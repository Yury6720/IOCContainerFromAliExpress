package com.IOCContainerFromAliExpress.Scanner;

import com.IOCContainerFromAliExpress.Annotations.Inject;

import java.lang.reflect.Constructor;

public class ConstructorScan {

  public ConstructorScan() {}

  public Constructor<?> getDefaultConstructor(Class<?> cl) {

    Constructor defaultConstructor = null;
    Constructor<?>[] constructors = cl.getConstructors();
    for (Constructor constructor : constructors)
      if (constructor.getParameterCount() == 0) {
        defaultConstructor = constructor;
      }
    return defaultConstructor;
  }

  public Constructor<?> getAnnotateConstructor(Class<?> cl) {
    Constructor requiredСonstructor = null;
    Constructor<?>[] constructors = cl.getConstructors();

    for (Constructor<?> constructor : constructors) {
      if (constructor.isAnnotationPresent(Inject.class)) {
        requiredСonstructor = constructor;
      } else {
        ConstructorScan cs = new ConstructorScan();
        requiredСonstructor = cs.getDefaultConstructor(cl);
      }
    }
    return requiredСonstructor;
  }
}
