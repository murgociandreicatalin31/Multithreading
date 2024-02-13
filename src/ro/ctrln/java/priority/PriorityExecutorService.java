package ro.ctrln.java.priority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityExecutorService {

    public static void main(String[] args) {

        ExecutorService tasksExecutor = Executors.newFixedThreadPool(1);
        ExecutorService tasksLauncher = Executors.newSingleThreadExecutor();

        PriorityBlockingQueue<PriorityThread> tasksQueue =
                new PriorityBlockingQueue<>(10, Comparator.comparing(PriorityThread::getPriority));

        ArrayList<PriorityThread> priorityThreads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            priorityThreads.add(new PriorityThread("PriorityThread" + i, new Random().nextInt(10) + 1));
        }

        tasksLauncher.execute(() -> {
            while(true) {
                try {
                    tasksExecutor.execute(tasksQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tasksQueue.addAll(priorityThreads);
    }
}
