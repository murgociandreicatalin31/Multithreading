package ro.ctrln.java.concurrency.model;

import java.util.List;
import java.util.Random;

public class ListingTaskWithYield <T> implements Runnable {

    private List<T> entities;
    private String name;

    public ListingTaskWithYield(String name, List<T> entities) {
        this.name = name;
        this.entities = entities;
    }

    @Override
    public void run() {
        System.out.println("Rulez taskul: " + name);
        Thread.yield();
        if(entities.isEmpty()) {
            return;
        }

        String className = entities.get(0).getClass().getSimpleName();

        int i = 0;
        for(Object entity : entities) {
            System.out.println(className + " " + i + ": " + entity);
            i++;

            try {
                long sleepingTime = (new Random().nextInt(9) + 1);
                System.out.println("Dorm pentru o perioada de " + sleepingTime + " secunde!");
                Thread.sleep(sleepingTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Taskul " + name + " incheiat!");
    }
}
