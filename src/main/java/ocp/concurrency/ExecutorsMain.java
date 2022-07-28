package ocp.concurrency;

import java.util.concurrent.*;

public class ExecutorsMain {

    private static int counter = 0;

    public static void main(String[] args) {
        ExecutorService executors = Executors.newSingleThreadExecutor();
        Future<?> result = executors.submit(
                () -> {
                    for (int i = 0; i<= 400; i++) {
                        ExecutorsMain.counter++;
                    };
                }
        );
        try {
            result.get(10, TimeUnit.MILLISECONDS);
            System.out.println("Reached!");
        } catch (TimeoutException | InterruptedException | ExecutionException e) {
            System.out.println("Not Reached in Time!");
        } finally {
            if (executors != null) executors.shutdown();
        }
    }

}
