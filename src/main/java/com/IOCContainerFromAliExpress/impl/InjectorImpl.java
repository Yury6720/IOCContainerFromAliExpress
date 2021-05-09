package com.IOCContainerFromAliExpress.impl;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.Utils.ConstructorScan;
import com.IOCContainerFromAliExpress.interfaces.Injector;
import com.IOCContainerFromAliExpress.interfaces.Provider;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class InjectorImpl implements Injector {
    Constructor requiredСonstructor;
    @Override
    public <T> Provider<T> getProvider(Class<T> type) {
        ProviderImpl provider = new ProviderImpl(type);
        provider.getInstance(constructor);
        return provider;
    }

    @Override
    public <T> void bind(Class<T> intf, Class<? extends T> impl) {
       ConstructorScan cs = new ConstructorScan();
       cs.getAnnotateConstructor(impl);
    }

    @Override
    public <T> void bindSingleton(Class<T> intf, Class<? extends T> impl) {

    }
}
