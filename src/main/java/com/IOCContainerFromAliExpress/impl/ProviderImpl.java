package com.IOCContainerFromAliExpress.impl;

import com.IOCContainerFromAliExpress.interfaces.Provider;

import java.lang.reflect.Constructor;

public class ProviderImpl implements Provider {

    public <T> ProviderImpl(Class<T> type) {
        this.newClass = type;
    }

    @Override
    public Object getInstance() {
        Constructor constructor = newClass.class.getConstructor(String.class);

        SomeObject myObject = (SomeObject) constructor.newInstance("здесь какой-то строковый аргумент");
        return null;
    }
}
