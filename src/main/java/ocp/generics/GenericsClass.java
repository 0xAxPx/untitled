package ocp.generics;

import java.util.List;

public class GenericsClass {

    /**
     * There are three types of generic
     * onbounded = anything e.g. List<?>
     * upper-bounded e.g. List<? extends Number>
     * lower-bounded e.g. List<? super Number>
     */

    //unbound generic
    //? means - anything
    public static void printEach(List<?> objects) {
        System.out.println(objects.getClass().getName());
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }
    }

    //upper bounded generic
    public static void printEachUpperBounded(List<? extends Number> objects) {
        System.out.println(objects.getClass().getName());
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }
    }

    //lower-bounded
    public static void printEachLowerBounded(List<? super String> objects) {
        System.out.println(objects.getClass().getName());
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }
    }





}
