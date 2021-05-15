package com.IOCContainerFromAliExpress.Utils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

/**
 * "FileVisitor"
 *              класс реализующий методы для прохода по всем пакетам и файлам
 *              в директории Контейнера (IOCContainerFromAliExpress)
 *
 * @param <T>
 *
 *
 *
 */

public class FileVisitor<T> extends SimpleFileVisitor {

    Set<String> filesInPresentDirectory = new HashSet<>();

    public FileVisitor() {
    super();
}

    public Set<String> getFilesInPresentDirectory() {
        return filesInPresentDirectory;
    }

  /**
   * @param dir
   *            The type of reference to the directory
   * @param attrs
   *            Basic attributes associated with a file in a file system.
   *            <p>Basic file attributes are attributes that are common to many file systems
   *            and consist of mandatory and optional file attributes as defined by this interface.
   * @return enum FileVisitResult
   *
   * @throws IOException
   *
   * @NB replace checking by JUnit test
   * @NB delete checking
   *
   */
  @Override
  public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs)
      throws IOException {
      //Check
        System.out.println("Directory name:" + dir);
        return FileVisitResult.CONTINUE;
    }
    /**
     *
     * @Method "visitFile"
     *          -visit current file and save absolute classpath to Collection
     *
     * @param file
     *            The type of reference to the file
     * @param attrs
     *            Basic attributes associated with a file in a file system.
     *            <p>Basic file attributes are attributes that are common to many file systems
     *            and consist of mandatory and optional file attributes as defined by this interface.
     *
     * @return enum FileVisitResult
     *
     * @throws IOException
     *
     * @NB replace checking by JUnit test
     * @NB delete checking
     *
     */
    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        //Check
        System.out.println("Посетили файл " + file.toString());
        filesInPresentDirectory.add(file.toString());
        return FileVisitResult.CONTINUE;
    }
    /**
     * @param file
     *            The type of reference to the file
     *
     * @return enum FileVisitResult
     *
     * @throws IOException
     *
     * @NB replace checking by JUnit test
     * @NB delete checking
     *
     */
    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        //Check
        System.out.println("Ошибка при посещении файла " + file.toString());
        return FileVisitResult.CONTINUE;
    }

  /**
   *
   * @param dir The type of reference to the file
   *
   * @return enum FileVisitResult
   *
   *  @throws IOException
   *
   *
   * @NB replace checking by JUnit test
   * @NB delete checking
   */
  @Override
  public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        //Check
        System.out.println("Обход папки " + dir.toString() + " закончился");
        return FileVisitResult.CONTINUE;
    }
}
