package com.IOCContainerFromAliExpress.Utils;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

public class PackageScan extends SimpleFileVisitor<Path> {

    Path path = Paths.get("/src");
    FileVisitor fv = new FileVisitor();



  Path testFilePath = Paths.get("./src");

    public PackageScan() {
    }

    // Пример строки пути для запуска в Windows
  // Path testFilePath = Paths.get(".\\Test");
  public String show() throws IOException {
    System.out.println("The file name is: " + testFilePath.getFileName());
    System.out.println("It's URI is: " + testFilePath.toUri());
    System.out.println("It's absolute path is: " + testFilePath.toAbsolutePath());
    System.out.println("It's normalized path is: " + testFilePath.normalize());

    // Получение другого объекта строки по нормализованному относительному пути
    Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
    System.out.println("It's normalized absolute path is: " + testPathNormalized.toAbsolutePath());

    System.out.println(
        "It's normalized real path is: " + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
    String p = String.valueOf(testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
    return p;
}






//public  Path walkFileTree(Path path, FileVisitor<? super Path> visitor) throws IOException {

//  @Override
//  public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
//    if (attr.isSymbolicLink()) {
//     System.out.format("Symbolic link: %s ", file);
//    } else if (attr.isRegularFile()) {
//      System.out.format("Regular file: %s ", file);
//    } else {
//      System.out.format("Other: %s ", file);
//    }
//    System.out.println("(" + attr.size() + "bytes)");
//    return CONTINUE;
//  }
//
//  // Пишет в консоль каждый посещаяемый каталог
//  @Override
//  public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
//    System.out.format("Directory: %s%n", dir);
//    return CONTINUE;
//  }
//
//  // Если возникла какая-нибудь ошибка при доступе к файлу,
//  // то выводим эту ошибку.
//  // Если вы не переопределите этот метод, и возникнет
//  // ошибка, то бросится исключение IOException
//  @Override
//  public FileVisitResult visitFileFailed(Path file, IOException exc) {
//    System.err.println(exc);
//    return CONTINUE;
//  }
//}
  // Path path = Paths.get("com.IOCContainerFromAliExpress");
  //    Set<String> allFiles = new HashSet<>();
  //
  //    Path path = Paths.get("src/main/java/com/IOCContainerFromAliExpress");
  //    try {
  //        Files.walkFileTree(path, new PackageScan());
  //    } catch (IOException e) {
  //        e.printStackTrace();
  //    }
  //
  //    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
  //        System.out.println("file name:" + path.getFileName());
  //        if(path.toString().endsWith(""))
  //            allFiles.add(path.toString());
  //        return FileVisitResult.CONTINUE;
  //    }
  //
  //
  //    public FileVisitResult preVisitDirectory(Path path,
  //                                             BasicFileAttributes fileAttributes) {
  //        System.out.println("Directory name:" + path);
  //        return FileVisitResult.CONTINUE;
  //    }
  //
  //
  //
  //    public Set<String> getAllFiles() {
  //        return allFiles;
  //    }

  //    public static Map<Package, ClassLoader[]> getPackageMap(
  //            List<ClassLoader> classLoaders, Set<String> ignorePackages) {
  //        Map<Package, ClassLoader[]> answer = new HashMap<Package, ClassLoader[]>();
  //
  //        ClassLoader[] globalClassLoaders = {
  //                Thread.currentThread().getContextClassLoader(),
  // ClassScanner.class.getClassLoader()
  //        };
  //
  //        Set<Package> packages = new HashSet<Package>();
  //        add(answer, Package.getPackages(), globalClassLoaders, ignorePackages);
  //
  //        ClassLoader[] classLoaderArray = new ClassLoader[classLoaders.size()];
  //        classLoaders.toArray(classLoaderArray);
  //
  //        for (ClassLoader classLoader : classLoaders) {
  //            Package[] loaderPackages = findPackagesForClassLoader(classLoader);
  //            add(answer, loaderPackages, classLoaderArray, ignorePackages);
  //        }
  //        SortedSet<String> names = new TreeSet<String>();
  //        for (Package aPackage : packages) {
  //            names.add(aPackage.getName());
  //        }
  //        for (String name : names) {
  //            LOG.info("Got package " + name);
  //        }
  //        return answer;
  //    }

  //  private static final char PKG_SEPARATOR = '.';
  //
  //  private static final char DIR_SEPARATOR = '/';
  //
  //  private static final String CLASS_FILE_SUFFIX = ".class";
  //
  //  private static final String BAD_PACKAGE_ERROR =
  //      "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";
  //
  //  /** Возвращает список классов в пакете */
  //  public static List<Class<?>> find(String scannedPackage) {
  //    String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
  //    URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
  //    if (scannedUrl == null) {
  //      throw new IllegalArgumentException(
  //          String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
  //    }
  //    File scannedDir = new File(scannedUrl.getFile());
  //    List<Class<?>> classes = new ArrayList<>();
  //    for (File file : scannedDir.listFiles()) {
  //      classes.addAll(find(file, scannedPackage));
  //    }
  //    return classes;
  //  }
  //
  //  private static List<Class<?>> find(File file, String scannedPackage) {
  //    List<Class<?>> classes = new ArrayList<>();
  //    String resource = scannedPackage + PKG_SEPARATOR + file.getName();
  //    if (file.isDirectory()) {
  //      for (File child : file.listFiles()) {
  //        classes.addAll(find(child, resource));
  //      }
  //    } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
  //      int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
  //      String className = resource.substring(0, endIndex);
  //      try {
  //        classes.add(Class.forName(className));
  //      } catch (ClassNotFoundException ignore) {
  //      }
  //    }
  //    return classes;
  //  }

}
