package com.IOCContainerFromAliExpress.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FileWalker {
    private final Path path = Paths.get("src\\main\\java\\com\\IOCContainerFromAliExpress").toAbsolutePath();
    Set<Set<String>> allF = new HashSet<Set<String>>();
    public FileWalker() throws IOException {
    }

    public Set walkDirectory (){

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
