package ro.ctrln.java.concurrency.model;

import java.util.List;
import java.util.Random;

public class ListingTaskWithSleep <T> implements Runnable {

    private List<T> entities;
    private String name;

    public ListingTaskWithSleep(String name, List<T> entities) {
        this.name = name;
        this.entities = entities;
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
            System.out.println(className + " " + i + ": " + entity);
            i++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Taskul " + name + " incheiat!");
    }
}
