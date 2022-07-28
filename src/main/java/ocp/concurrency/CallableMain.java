package ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableMain {

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> 50 * 405);
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service !=null) service.shutdown();
        }
        if (service != null) {
            try {
                service.awaitTermination(10, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (service.isTerminated()) {
            System.out.println("All task completed");
        }


    }


}
