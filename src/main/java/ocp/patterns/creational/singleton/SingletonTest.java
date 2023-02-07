package ocp.patterns.creational.singleton;

public class SingletonTest {

    public static void main(String... args) {


        Thread t1 = new Thread(new Boo());
        Thread t2 = new Thread(new Foo());
        t1.start();
        t2.start();


    }

    static class Boo implements Runnable {
        @Override
        public void run() {
            SingletonThreadSafe boo = SingletonThreadSafe.getInstance("BOO");
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), boo.getValue());
        }
    }

    static class Foo implements Runnable {
        @Override
        public void run() {
            SingletonThreadSafe foo = SingletonThreadSafe.getInstance("FOO");
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), foo.getValue());
        }
    }


}
