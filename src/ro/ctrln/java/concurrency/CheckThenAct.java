package ro.ctrln.java.concurrency;

import java.util.Vector;

public class CheckThenAct {

    public static void main(String[] args) {

        Vector<String> vector = new Vector<>();
        Thread threadOne = new Thread(getTask("Task1", vector));
        Thread threadTwo = new Thread(getTask("Task2", vector));

        threadOne.start();
        threadTwo.start();
    }

    private static Runnable getTask(String task, Vector<String> vector) {
        return () -> {
            for (int i = 0; i < 1000000; i++) {
                synchronized (vector) {
                    if (vector.contains("string")) {
                        boolean removed = vector.remove("string");
                        if (!removed) {
                            System.out.println("Task: " + task + " - Iteratia: " + i + " are valoarea null pentru 'string'");
                        }
                    } else {
                        vector.add("string");
                    }
                }
            }
        };
    }
}
