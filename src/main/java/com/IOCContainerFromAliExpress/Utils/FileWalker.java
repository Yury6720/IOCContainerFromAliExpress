package com.IOCContainerFromAliExpress.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * "FileWalker" - содержит метод для старта сканирования директории Контейнера
 * (IOCContainerFromAliExpress) для нахождения всех классов. Является способом №2 для сканирования
 * директории. Использует библиотеку "NIO"
 *
 * @param "path"
 *         сожержит абсолютный путь к директории Контейнера ("IOCContainerFromAliExpress")
 *
 * @Constructor
 *              1. Default constructor.
 *
 * @throws IOException
 */

public class FileWalker {
    private final Path path = Paths.get("src\\main\\java\\com\\IOCContainerFromAliExpress").toAbsolutePath();
    Set<String> allF = new HashSet<>();

    public FileWalker() throws IOException {
    }

    /**
     * @Method "walkDirectory"
     *                         -запускает "FileVisitor"
     *                         -"FileVisitor" осуществляет проход по всему дереву директории
     *                         -"FileVisitor" @return Set<String> содержащий абсолютные пути к классам
     *                         в дирретории Контейнера
     *                         -сохранение коллекции абсолютных путей классов.
     *
     *
     * @return Set<String> allF
     *                         коллекция абсолютных путей всех классов в директории Контейнера
     * @throws NoSuchFileException
     * @throws IOException
     */
    public Set<String> walkDirectory (){

    try {
        FileVisitor fileVisitor = new FileVisitor();
        Files.walkFileTree(path, fileVisitor);
        allF.addAll(fileVisitor.getFilesInPresentDirectory());

    } catch (
    NoSuchFileException e){
        e.printStackTrace();
        System.out.println("Pizdec");
    } catch (
    IOException e) {
        e.printStackTrace();
    }
    return allF;
    }
}
