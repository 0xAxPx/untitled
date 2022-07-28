package ocp.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerSingleThreadMain {

    public static void main(String[] args) {

        Runnable task1 = () -> System.out.println("Runnable task");
        Callable<String> task2 = () -> "Callable Task";
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        long start = System.currentTimeMillis();
        service.schedule(task1, 5, TimeUnit.SECONDS);
        service.schedule(task2, 3, TimeUnit.SECONDS);
        System.out.println("Finished:" + (System.currentTimeMillis() - start) * 1000L);


    }
}
