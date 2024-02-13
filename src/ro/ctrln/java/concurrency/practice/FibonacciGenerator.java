package ro.ctrln.java.concurrency.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciGenerator {

    public static void main(String[] args) {

        FibonacciSequence sequence = new FibonacciSequence();

        int TASKS = 20;
        ExecutorService executor = Executors.newFixedThreadPool(TASKS);

        for (int i = 0; i < TASKS; i++) {
            executor.execute(new FibonacciTask(i, sequence));
        }

        executor.shutdown();
    }
}
