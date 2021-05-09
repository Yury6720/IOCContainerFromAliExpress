package com.IOCContainerFromAliExpress;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.interfaces.EventDAO;
import jdk.jfr.Event;

public class Cat {
    EventDAO eventDAO;
    @Inject
    public Cat(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
}
