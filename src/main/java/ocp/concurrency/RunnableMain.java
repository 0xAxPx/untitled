package ocp.concurrency;

public class RunnableMain implements Runnable {

    private static int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": i=" + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableMain()).start();
        new Thread(() -> {
            for (int i = 0; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + ": i=" + i);
            }
        }
        ).start();
    }
}
