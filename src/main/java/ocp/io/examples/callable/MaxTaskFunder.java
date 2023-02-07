package ocp.io.examples.callable;

import java.util.concurrent.*;

public class MaxTaskFunder {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        int[] array = {1,5,6,7,22,-5,1090003,4,6, Integer.MAX_VALUE, Integer.MIN_VALUE};
        System.out.println(max(array));
        System.out.println("Finished");


    }

    public static int max(int[] data) throws ExecutionException, InterruptedException, TimeoutException {

        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException("No data in array");
        }

        FindMaxTask findMaxTask1 = new FindMaxTask(data, 0, data.length/2);
        FindMaxTask findMaxTask2 = new FindMaxTask(data, data.length/2, data.length);

        //spawn task
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> result1 = executorService.submit(findMaxTask1);
        Future<Integer> result2 = executorService.submit(findMaxTask2);

        //Future.get() - blocking operation
        //once result1.get() finishes then result2.get() starts only
        return Math.max(result1.get(10, TimeUnit.SECONDS), result2.get(10, TimeUnit.SECONDS));
    }

}
