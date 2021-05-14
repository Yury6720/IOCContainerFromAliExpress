package com.IOCContainerFromAliExpress;

// import com.IOCContainerFromAliExpress.Annotations.AnnotationExistenceChecker;
import com.IOCContainerFromAliExpress.Utils.ClassesScanner;
import com.IOCContainerFromAliExpress.Utils.FileVisitor;
import com.IOCContainerFromAliExpress.Utils.PackageScan;
import com.IOCContainerFromAliExpress.impl.InjectorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    System.out.println("\n"+"New part"+ "\n");

    PackageScan ps = new PackageScan();
    Path path = Paths.get("src\\main\\java\\com\\IOCContainerFromAliExpress").toAbsolutePath();
    //Path path=Paths.get("src\\main\\java\\com\\IOCContainerFromAliExpress").toAbsolutePath();
    //Path path = Paths.get("\\IOCContainerFromAliExpress");
    try {
      Files.walkFileTree(path, new FileVisitor());
    } catch (NoSuchFileException e){
     e.printStackTrace();
      System.out.println("Pizdec");
    } catch (IOException e) {
      e.printStackTrace();
    }


//    PackageScan ps = new PackageScan();
//    ps.show();

    //    Path path = Paths.get(".\\src");
    //    Path walkFileTree (Path path, new PackageScan<? super Path> visitor)
    //                         throws IOException

    //    Path startingDir = "src/main/java";
    //    PackageScan pf = new PackageScan();
    //    Files.(startingDir, pf);


//    PackageScan ps = new PackageScan();
//    Set<String> ns = ps.getAllFiles();
//    for (String name : ns) {
//      System.out.println(name);
//    }
  }
}
