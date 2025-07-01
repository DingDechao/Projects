package org.example.nio2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
    public static void main(String[] args) throws Exception {

        var path = Paths.get("D:\\projects\\javaproject\\Projects\\java17\\src\\main\\java\\org\\example\\nio2\\FilesTest.java");
        var fileOutputStream = new FileOutputStream("a.txt");
        Files.copy(path, fileOutputStream);

        System.out.println("FilesTest.java是否为隐藏文件：" + Files.isHidden(path));


        List<String> lines = Files.readAllLines(path, Charset.forName("utf-8"));
        System.out.println(lines);
        System.out.println("FilesTest.java的大小为：" + Files.size(path));

        List<String> poem = new ArrayList<>();
        poem.add("水晶潭底银鱼跃");
        poem.add("清徐风中碧竿横");
        Files.write(Paths.get("pome.txt"), poem, Charset.forName("utf-8"));

        Files.list(Paths.get(".")).forEach(path1 -> System.out.println(path1));

        Files.lines(path, Charset.forName("utf-8")).forEach(line -> System.out.println(line));
        FileStore cStore = Files.getFileStore(Paths.get("C:"));
        System.out.println("C:共有空间：" + cStore.getTotalSpace());
        System.out.println("C:可用空间：" + cStore.getUsableSpace());
    }
}
