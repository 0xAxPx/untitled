package ocp.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierMain {

    private void removeLions() {
        System.out.println("Removing lions");
    }

    private void cleanPen() {
        System.out.println("Clean pen");
    }

    private void addLions() {
        System.out.println("Add lions");
    }

    private void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeLions();
            c1.wait();
            cleanPen();
            c2.wait();
            addLions();
        } catch (InterruptedException e) {
            //
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            var manager = new CyclicBarrierMain();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("Pen cleaned"));
            for (int i = 0;  i < 4 ; i++) {
                service.submit(() -> manager.performTask(c1, c2));
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
