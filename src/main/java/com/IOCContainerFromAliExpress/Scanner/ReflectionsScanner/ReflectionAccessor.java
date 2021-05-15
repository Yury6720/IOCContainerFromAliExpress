package com.IOCContainerFromAliExpress.Scanner.ReflectionsScanner;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;

public class ReflectionAccessor {
  Reflections reflections;

  public ReflectionAccessor() {
    this.reflections =
        new Reflections(
            "com.IOCContainerFromAliExpress",
            new MethodAnnotationsScanner(),
            new SubTypesScanner());
  }

  public Reflections getReflections() {
    return reflections;
  }
}
