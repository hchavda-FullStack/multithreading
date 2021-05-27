package io.hitesh.learning;

import java.util.concurrent.*;

public class ThreadLearning {
    public static void main(String[] args) {
       Callable<Integer> c1 = ()->{
           int sum = 0;
           Thread.sleep(11000);
           for (int i = 0; i < 100000; i++) {
               sum+=i;
           }
           return sum;
       };

        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Integer> future = service.submit(c1);
        Future<Integer> future1 = service.submit(c1);
        System.out.println("Done with main thread");
        try {
            System.out.println(future.get(10, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("After doing future.get");
        service.shutdown();
    }
}


