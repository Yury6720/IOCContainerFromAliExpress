package com.IOCContainerFromAliExpress;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.interfaces.EventDAO;
import jdk.jfr.Event;

public class TargetClass {

    EventDAO eventDAO;

    @Inject
    public TargetClass(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
}
