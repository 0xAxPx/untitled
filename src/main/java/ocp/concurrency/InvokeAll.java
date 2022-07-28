package ocp.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAll {

    public static void main(String[] args) {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            Callable<String> task = () -> "result";
            List<Future<String>> results = service.invokeAll(List.of(task, task, task));
            for (Future<String> s : results) {
                System.out.println(s.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
