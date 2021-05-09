package com.IOCContainerFromAliExpress;

//import com.IOCContainerFromAliExpress.Annotations.AnnotationExistenceChecker;
import com.IOCContainerFromAliExpress.Utils.AnnotationScan;
import com.IOCContainerFromAliExpress.impl.InMemoryEventDAOImpl;
import com.IOCContainerFromAliExpress.impl.InjectorImpl;
import com.IOCContainerFromAliExpress.interfaces.EventDAO;
import com.IOCContainerFromAliExpress.interfaces.Injector;
import com.IOCContainerFromAliExpress.interfaces.Provider;

import java.util.Set;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException {
//    AnnotationScan annotationScan = new AnnotationScan();
//    Set<?> t = annotationScan.getAllClassesWithAnnotations();
//    System.out.println(t.toString());
////    AnnotationExistenceChecker annotationExistenceChecker= new AnnotationExistenceChecker();
////    annotationExistenceChecker.check();

      Injector injector = new InjectorImpl(); //создаем имплементацию инжектора
      injector.bind(EventDAO.class, InMemoryEventDAOImpl.class); //добавляем в инжектор реализацию интерфейса
      Provider<EventDAO> daoProvider = injector.getProvider(EventDAO.class); //получаем инстанс класса из инжектора
//      assertNotNull(daoProvider);
//      assertNotNull(daoProvider.getInstance());
//      assertSame(InMemoryEventDAOImpl.class, daoProvider.getInstance().getClass());


  }
}
