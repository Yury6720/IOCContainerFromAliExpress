package com.IOCContainerFromAliExpress.impl;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import com.IOCContainerFromAliExpress.interfaces.EventDAO;

public class InMemoryEventDAOImpl implements EventDAO {

    public InMemoryEventDAOImpl() {
    System.out.println("InMemoryEventDAOImpl initialized");
    }
}
