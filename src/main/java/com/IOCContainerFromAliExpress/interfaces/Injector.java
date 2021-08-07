package com.IOCContainerFromAliExpress.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Injector {
    <T> Provider<T> getProvider(Class <T> type);
    <T> Object bind() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;//(Class<T> intf, Class<? extends T> impl);
   // <T> void bindSingleton(Class<T> intf, Class<? extends T> impl);
}
