package ocp.concurrency.threadsafe;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Simple Example with synchronized()
 */
public class SynchronizedMain {

    private static int counter = 0;

    private synchronized void incrementCounter() {
        System.out.println("Incremented counter: " + counter++);
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            SynchronizedMain main = new SynchronizedMain();
            for (int i = 0; i <= 10; i++) {
                service.submit(main::incrementCounter);
            }
        } finally {
            if (Objects.nonNull(service)) service.shutdown();
        }
    }
}
