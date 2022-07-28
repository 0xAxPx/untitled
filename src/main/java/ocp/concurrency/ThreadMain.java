package ocp.concurrency;

public class ThreadMain extends Thread {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i <= 500; i++) {ThreadMain.counter++;}}).start();

        while (ThreadMain.counter < 100) {
            System.out.println("Not reached 100");
            Thread.sleep(1000L);
        }
        System.out.println("Reached 100");
    }
}
