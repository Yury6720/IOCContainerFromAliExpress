package com.IOCContainerFromAliExpress;

import java.lang.reflect.Constructor;

public class Binding {
    Constructor constructor;
    boolean requairedInteerface;

    public Binding() {
    }

    public Binding(Constructor constructor, boolean requairedInteerface) {
        this.constructor = constructor;
        this.requairedInteerface = requairedInteerface;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public boolean isRequairedInteerface() {
        return requairedInteerface;
    }

    public void setRequairedInteerface(boolean requairedInteerface) {
        this.requairedInteerface = requairedInteerface;
    }
}
