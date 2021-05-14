package com.IOCContainerFromAliExpress.Utils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitor extends SimpleFileVisitor {

    public FileVisitor() {
    super();
}

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Directory name:" + dir);
        return FileVisitResult.CONTINUE;
    }

//    @Override
//    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//        System.out.println("Directory name:" + dir);
//        return FileVisitResult.CONTINUE;
//    }


    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Посетили файл " + file.toString());
        return FileVisitResult.CONTINUE;
    }

//    @Override
//    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        System.out.println("Посетили файл " + file.toString());
//        return FileVisitResult.CONTINUE;
//    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        System.out.println("Ошибка при посещении файла " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        System.out.println("Обход папки " + dir.toString() + " закончился");
        return FileVisitResult.CONTINUE;
    }
}
