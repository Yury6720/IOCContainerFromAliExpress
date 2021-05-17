package com.IOCContainerFromAliExpress;

// import com.IOCContainerFromAliExpress.Annotations.AnnotationExistenceChecker;
import com.IOCContainerFromAliExpress.Scanner.ClassScanner3.ClassFinder;
import com.IOCContainerFromAliExpress.Scanner.NIOScanner.FileWalker;
import com.IOCContainerFromAliExpress.impl.InjectorImpl;
import javassist.bytecode.ClassFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException, IOException {
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



    FileWalker fileWalker = new FileWalker();
    Set <String> adf = new HashSet();
    Set<String> urlFromUnit = new HashSet<>();
    adf.addAll(fileWalker.walkDirectory());
    urlFromUnit.addAll(fileWalker.walkDirectory());
//    System.out.println("\n" + "new Part 3" + "\n");
//    Class<?> c = Class.forName("com.IOCContainerFromAliExpress.Utils.PackageScan.java");
//    System.out.println("Element toString: " + c + "\n");
    System.out.println("Part 4");

    System.out.println("\n" + "New part" + "\n");
    ClassFinder classFinder = new ClassFinder();
    List<Class<?>> classes = ClassFinder.find("src/main/java/com/IOCContainerFromAliExpress");
    for (Class clazz : classes) {
      System.out.println("Part 4 : " + clazz);
    }

/**
 * Косяк с получением класса по имени
 * Поменять формат стрингового отображения пути к классу
 */
//    for (String el : adf) {
//      Class<?> c = Class.forName(el);
//      System.out.println("Element toString: " + c + "\n");
//
//
//    }

    //    PackageScan ps = new PackageScan();
    //    Path path =
    // Paths.get("src\\main\\java\\com\\IOCContainerFromAliExpress").toAbsolutePath();
    //
    //    try {
    //      Files.walkFileTree(path, new FileVisitor());
    //    } catch (NoSuchFileException e){
    //     e.printStackTrace();
    //      System.out.println("Pizdec");
    //    } catch (IOException e) {
    //      e.printStackTrace();
    //    }

    /*
    1. Сканирование пакета.
        Получаем на входе Set классов
    2. Нахождение всех классов
    3. Скаирование всех классов для нахождения аннотированных конструкторов.
    4. Сканирование Конструктора для нахождения всех параметров.
    5. Определение является ли параметр классом
    6. Определение является ли параметр имплементацией интерфейса.
    7. Нахождение конкретной импрементации конкретного интерфейса.
    8. Инстанцирование класса через конструктор с передачей бинов имплементаций


     */



  }
}
