package ro.ctrln.java.concurrency.model;

import java.util.List;
import java.util.concurrent.Callable;

public class ListingTaskWithResult<T> implements Callable<Integer> {

    private final List<T> entities;
    private final String name;

    public ListingTaskWithResult(String name, List<T> entities) {
        this.name = name;
        this.entities = entities;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Rulez taskul: " + name);

        if(entities.isEmpty()) {
            return 0;
        }

        String className = entities.get(0).getClass().getSimpleName();

        int i = 0;
        for(Object entity : entities) {
            System.out.println(className + " " + i + ": " + entity);
            i++;
        }

        System.out.println("Taskul " + name + " incheiat!");
        return i;
    }
}
