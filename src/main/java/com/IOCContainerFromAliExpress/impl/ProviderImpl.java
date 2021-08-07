package com.IOCContainerFromAliExpress.impl;

import com.IOCContainerFromAliExpress.interfaces.Provider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProviderImpl implements Provider {
Class newClass;
  public <T> ProviderImpl(Class <T> type) {
    this.newClass = type;
  }

  @Override
  public Object getInstance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor constructor = newClass.getConstructor();

    Object newObject =  constructor.newInstance();
    return newObject;
  }
}
