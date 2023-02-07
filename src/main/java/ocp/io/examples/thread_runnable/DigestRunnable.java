package ocp.io.examples.thread_runnable;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestRunnable implements Runnable{

    private String fileName;

    public DigestRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            FileInputStream file = new FileInputStream(fileName);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(file, sha);
            while (din.read() != -1);
            din.close();
            byte[] digest = sha.digest();
            StringBuilder result = new StringBuilder(fileName);
            result.append(": ");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        for (String f : args) {
            DigestRunnable runnable = new DigestRunnable(f);
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
