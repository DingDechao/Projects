package org.example.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(".");
        System.out.println("path里包含的路径数量：" + path.getNameCount());
        System.out.println("path的根路径：" + path.getRoot());

        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println("absolutePath的根路径：" + absolutePath.getRoot());
        System.out.println("absolutePath里包含的路径数量：" + absolutePath.getNameCount());
        System.out.println(absolutePath.getName(2));

        Path path2 = Paths.get("d:", "projects", "javaproject");
        System.out.println(path2);
    }
}
