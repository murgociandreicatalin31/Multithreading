package ro.ctrln.java.volatile_variables;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicInteger {

    private final AtomicInteger counterOne = new AtomicInteger(0);
    private final AtomicInteger counterTwo = new AtomicInteger(0);

    public synchronized void incrementCounters() {
        counterOne.set(counterOne.get()+1);
        counterTwo.set(counterTwo.get()+1);
    }

    public synchronized void showCounters() {
        System.out.println("counterOne: " + counterOne + "; counterTwo: " + counterTwo);
    }

    public static void main(String[] args) {

        VolatileAtomicInteger bittnetVolatile = new VolatileAtomicInteger();
        Thread threadOne = new Thread(getTask(bittnetVolatile));
        Thread threadTwo = new Thread(getTask(bittnetVolatile));

        threadOne.start();
        threadTwo.start();
    }

    private static Runnable getTask(VolatileAtomicInteger bittnetVolatile) {
        return () -> {
            for (int i = 0; i < 100000; i++) {
                bittnetVolatile.incrementCounters();
                bittnetVolatile.showCounters();
            }
        };
    }
}
