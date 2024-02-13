package ro.ctrln.java.concurrency.model;

import java.util.Date;
import java.util.List;

public class ListingTaskWithSleepTime<T> implements Runnable {

    private List<T> entities;
    private String name;
    private long sleepTime;

    public ListingTaskWithSleepTime(String name, List<T> entities, long sleepTime) {
        this.name = name;
        this.entities = entities;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println("Rulez taskul: " + name);

        if(entities.isEmpty()) {
            return;
        }

        String className = entities.get(0).getClass().getSimpleName();

        int i = 0;
        for(Object entity : entities) {
            System.out.println(name + " " + new Date()+ " -> " + className + " " + i + ": " + entity);
            i++;

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Taskul " + name + " incheiat!");
    }
}
