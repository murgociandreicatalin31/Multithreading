package ro.ctrln.java.concurrency.model;

import java.util.List;

public class ListingTaskThread<T> extends Thread {

    private List<T> entities;
    private String name;

    public ListingTaskThread(String name, List<T> entities) {
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
        }

        System.out.println("Taskul " + name + " incheiat!");
    }
}
