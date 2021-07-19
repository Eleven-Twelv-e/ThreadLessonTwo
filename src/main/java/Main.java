import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> myCallable1 = new MyCall(1, "Task 1");
        Callable<Integer> myCallable2 = new MyCall(2, "Task 2");
        Callable<Integer> myCallable3 = new MyCall(3, "Task 3");
        Callable<Integer> myCallable4 = new MyCall(4, "Task 4");

        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Future<Integer> task1 = threadPool.submit(myCallable1);
        Future<Integer> task2 = threadPool.submit(myCallable2);
        Future<Integer> task3 = threadPool.submit(myCallable3);
        Future<Integer> task4 = threadPool.submit(myCallable4);

        System.out.println("Result 1 = " + task1.get());
        System.out.println("Result 2 = " + task2.get());
        System.out.println("Result 3 = " + task3.get());
        System.out.println("Result 4 = " + task4.get());

        List<Callable<Integer>> list = new ArrayList<>();
        list.add(myCallable1);
        list.add(myCallable2);
        list.add(myCallable3);
        list.add(myCallable4);

        System.out.println();
        Integer fastest = threadPool.invokeAny(list);
        System.out.println("Faster task ever: " +  fastest);

        threadPool.shutdown();
    }
}
