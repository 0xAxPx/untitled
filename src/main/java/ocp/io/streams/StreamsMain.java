package ocp.io.streams;


import ocp.io.FileMain;

import java.io.*;

/**
 * Differences between Byte and Character Streams
 * Byte streams read/write binary data (0s and 1s) and have class names that end in InputStream or OutputStream.
 * Character streams read/write text data and have class names that end in Reader or Writer.
 */

public class StreamsMain {

    public static void main(String[] args) {

        //read buffered stream
        try (var ois = new BufferedInputStream(new FileInputStream(FileMain.getTestFile(FileMain.oldName)), 4 * 1048)) {
            System.out.println("Loaded the file!");
            System.out.println("Start : " + ois.available());
            while (ois.available() > 0) {
                System.out.println((char) ois.read());
            }
            System.out.println("Finish : " + ois.available());
        } catch (IOException io) {
            System.out.println("Can't load the file!");
        }

        //character stream
        //copy files
        try (var in = new BufferedReader(new FileReader(FileMain.getTestFile(FileMain.oldName)));
             var out = new BufferedWriter(new FileWriter(FileMain.getTestFile(FileMain.newName)))) {
            int b;
            //if use String readLine() then != null not !=-1
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void printData(InputStream is) throws IOException {
        int b;
        while ((b = is.read()) != -1) {
            System.out.print(b);
        }
    }

    public void readFile(String fileName) throws IOException {
        try (var fis = new FileInputStream(fileName)) {
            printData(fis);
        }
    }


}
