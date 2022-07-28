package ocp.throwable;

/**
 * Simple example how to get StackOverFlow
 */
public class StackOverFlow {

    public static void main (String ... args) {
        new StackOverFlow().calc();
    }

    public void calc() {
            calc();
    }

}
