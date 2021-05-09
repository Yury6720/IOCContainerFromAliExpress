package com.IOCContainerFromAliExpress.impl;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.Utils.AnnotationScan;
import com.IOCContainerFromAliExpress.Utils.ConstructorScan;
import com.IOCContainerFromAliExpress.interfaces.Injector;
import com.IOCContainerFromAliExpress.interfaces.Provider;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Set;

public class InjectorImpl implements Injector {

    @Override
    public <T> Provider<T> getProvider(Class<T> type) {
        ProviderImpl provider = new ProviderImpl(type);
        return provider;
    }

    @Override
    public <T> void bind(Class<T> intf, Class<? extends T> impl) {
        Set<Class>classesWithAnnotatedConstructors = new AnnotationScan().getAllClassesWithAnnotations();

    }

    @Override
    public <T> void bindSingleton(Class<T> intf, Class<? extends T> impl) {

    }
}
