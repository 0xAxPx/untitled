package ocp.io.serialization;


import ocp.io.FileMain;

import java.io.*;

/**
 * Serialization -> Object transformation into byte stream
 * Deserialization -> Byte stream into object
 * To serialize object with IO API class must implement Serializable interface, it is marker interface i.e, it does not contain methods
 * If class does not implement Serializable, NotSerializableException will be thrown
 * ObjectInputStream is used for deserialize object from byte stream
 * ObjectOutputStream is used for serialization object into byte stream
 */

public class SerializationMain implements Serializable {

    private static final long serialVersionID = 1L;
    private String name;
    private int age;
    private Boolean friendly;
    //any field marked with transient will not be saved into byte stream
    private transient String favoriteFood;

    public SerializationMain(){};

    public SerializationMain(String name, int age, Boolean friendly, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
        this.favoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return "SerializationMain{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendly=" + friendly +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }

    public static void main(String[] args) {
        SerializationMain gorilla = new SerializationMain("Jane", 14, true, "apple");
        gorilla.saveToFile(gorilla, FileMain.getTestFile(FileMain.oldName));

    }

    void saveToFile(SerializationMain gorilla, String fileName) {
        try (var in = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            in.writeObject(gorilla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
