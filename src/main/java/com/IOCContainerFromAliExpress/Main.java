package com.IOCContainerFromAliExpress;

// import com.IOCContainerFromAliExpress.Annotations.AnnotationExistenceChecker;
import com.IOCContainerFromAliExpress.impl.InjectorImpl;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException {
    //    AnnotationScan annotationScan = new AnnotationScan();
    //    Set<?> t = annotationScan.getAllClassesWithAnnotations();
    //    System.out.println(t.toString());
    ////    AnnotationExistenceChecker annotationExistenceChecker= new AnnotationExistenceChecker();
    ////    annotationExistenceChecker.check();

    //      Injector injector = new InjectorImpl(); //создаем имплементацию инжектора
    //      injector.bind(EventDAO.class, InMemoryEventDAOImpl.class); //добавляем в инжектор
    // реализацию интерфейса
    //      Provider<EventDAO> daoProvider = injector.getProvider(EventDAO.class); //получаем
    // инстанс класса из инжектора
    //      assertNotNull(daoProvider);
    //      assertNotNull(daoProvider.getInstance());
    //      assertSame(InMemoryEventDAOImpl.class, daoProvider.getInstance().getClass());
//    AnnotationScan as = new AnnotationScan();
//    as.getAllClassesWithAnnotations();
    InjectorImpl injector = new InjectorImpl();
    injector.bind();
  }
}
