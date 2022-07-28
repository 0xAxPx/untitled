package ocp.io;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class FileMain {

    private static String separator = File.separator;
    public static String oldName = "application.properties";
    public static String newName = "application.txt";
    private static String absolutePath = "C:" + separator + "Dev" + separator + "Java" + separator + "ocp11" + separator + "src" + separator + "main" + separator + "resources" + separator + "io" + separator;


    public static String getTestFile(String fileName) {
        return absolutePath + fileName;
    }

    public static void main(String[] args) {

        //absolute path
        var file = new File(getTestFile(oldName));
        if (file.isFile()) {
            System.out.println("File exists");
            System.out.println("File parent dir:" + file.getParent());
            System.out.println("File last modified:" + toDate(file.lastModified()));
            // rename file
            var newFile = new File(getTestFile(newName));
            if (file.renameTo(newFile)) {
                System.out.println("File renamed");
                System.out.println(new File(getTestFile(newName)).getName());
                System.out.println("Is Directory? - " + new File(getTestFile(newName)).isDirectory());

                //revert changes
                var fileRenamed = new File(getTestFile(oldName));
                if (newFile.renameTo(fileRenamed)) {
                    System.out.println("File renamed again:" + fileRenamed.getName());
                    System.out.println(new File(getTestFile(oldName)).getName());
                }
            }
        } else {
            System.out.println("File not found");
        }
    }

    private static LocalDateTime toDate(long timestamp) {
        return  LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
    }
}
