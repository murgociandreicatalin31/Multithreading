package ro.ctrln.java.concurrency.model;

import java.util.List;

public class ListingTaskLambdaExpression<T> {

    public void processEntities(List<T> entities, String taskName) {
        System.out.println("Rulez taskul: " + taskName);

        if(entities.isEmpty()) {
            return;
        }

        String className = entities.get(0).getClass().getSimpleName();

        int i = 0;
        for(Object entity : entities) {
            System.out.println(className + " " + i + ": " + entity);
            i++;
        }

        System.out.println("Taskul " + taskName + " incheiat!");
    }
}
