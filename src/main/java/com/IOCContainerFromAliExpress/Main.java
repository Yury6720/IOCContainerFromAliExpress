package com.IOCContainerFromAliExpress;

import com.IOCContainerFromAliExpress.impl.InjectorImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
  public static void main(String[] args)
      throws ClassNotFoundException, IOException, InvocationTargetException, NoSuchMethodException,
          InstantiationException, IllegalAccessException {

    InjectorImpl injector = new InjectorImpl();
    System.out.println("Bean " + injector.getBean(TargetClass.class));

  }
}
