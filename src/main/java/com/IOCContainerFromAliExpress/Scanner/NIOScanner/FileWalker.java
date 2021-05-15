package com.IOCContainerFromAliExpress.Scanner.NIOScanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * "FileWalker" - содержит метод для старта сканирования директории Контейнера
 * (IOCContainerFromAliExpress) для нахождения всех классов.
 *
 * <p>Является способом №2 для сканирования директории.
 *
 * <p>Использует библиотеку "NIO"
 *
 * <p>@Constructor
 * <li>1. Default constructor.
 *
 * @param "path" сожержит абсолютный путь к директории Контейнера ("IOCContainerFromAliExpress")
 * @throws IOException
 */
public class FileWalker {
  private final Path path =
      Paths.get("src\\main\\java\\com\\IOCContainerFromAliExpress").toAbsolutePath();
  Set<String> allF = new HashSet<String>();

  public FileWalker() throws IOException {}

  /**
   * @Method "walkDirectory"
   *
   * <p>запускает "FileVisitor"
   *
   * <p>"FileVisitor" осуществляет проход по всему дереву директории
   *
   * <p>"FileVisitor" @return Set<String> содержащий абсолютные пути к классам в дирретории
   * Контейнера
   *
   * <p>сохранение коллекции абсолютных путей классов.
   *
   * @return Set<String> allF коллекция абсолютных путей всех классов в директории Контейнера
   * @throws NoSuchFileException
   * @throws IOException
   *     <p>@NB !!!DELETE sout fom catch block before release
   */
  public Set<String> walkDirectory() {

    try {
      FileVisitor fileVisitor = new FileVisitor();
      Files.walkFileTree(path, fileVisitor);
      allF.addAll(fileVisitor.getFilesInPresentDirectory());

    } catch (NoSuchFileException e) {
      e.printStackTrace();
      // !!!DELETE
      System.out.println("Pizdec");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return allF;
  }
}
