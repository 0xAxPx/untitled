package ocp.nio2;

import ocp.io.FileMain;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Cornerstone in NIO.2 is PATH interface (replacement of FILE in NIO API
 */

public class Nio2Main {


    public static void main(String[] args) {

        Path path = Path.of(FileMain.getTestFile(FileMain.oldName));

        System.out.format("\nCount is %d",path.getNameCount());

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.format("\nDir is %s", path.getName(i));
        }
        System.out.format("\nFile is %s", path);
        System.out.format("\nPath is absolute: %s", path.isAbsolute());
        System.out.format("\nPath to absolute: %s", path.toAbsolutePath());

        if (System.getProperty("user.dir").equalsIgnoreCase(path.toAbsolutePath().toString())) {
            System.out.format("\nuser.dir and absolute path is the same");
        } else {
            System.out.format("\nuser.dir and absolute path is not the same: %s", System.getProperty("user.dir"));
        }

        FileSystem fileSystem = FileSystems.getDefault();

        System.out.format("\nFileSystem: %s", fileSystem.getRootDirectories());

        var newPath = Paths.get(FileMain.getTestFile(FileMain.oldName));

        System.out.format("File is %s", path);

        if (Files.exists(Paths.get(FileMain.getTestFile(FileMain.newName)), LinkOption.NOFOLLOW_LINKS)) {
            System.out.format("\nFile %s exists", FileMain.newName);
        } else {
            throw new IllegalArgumentException("\nFile does not exists");
        }


        try {
            final List<String> lines = Files.readAllLines(newPath);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
