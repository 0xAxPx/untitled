package ocp.security;

import java.util.ArrayList;
import java.util.List;

public class SecMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        List<String> a = new ArrayList<>();
        a.add("Tiger");
        Animal tiger = new Animal(a);
        Animal cloneT = (Animal) tiger.clone();
        System.out.println(tiger == cloneT);

    }
}
