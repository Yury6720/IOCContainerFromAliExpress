package com.IOCContainerFromAliExpress;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.interfaces.EventDAO;
import jdk.jfr.Event;

public class Cat {
    EventDAO eventDAO;
    String name;
    @Inject
    public Cat(EventDAO eventDAO, String name) {
        this.eventDAO = eventDAO;
        this.name= name;
    }
}
