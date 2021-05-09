package com.IOCContainerFromAliExpress.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Provider <T>{
    T getInstance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
