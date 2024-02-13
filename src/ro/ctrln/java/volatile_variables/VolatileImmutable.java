package ro.ctrln.java.volatile_variables;

import ro.ctrln.java.immutable.ImmutableInteger;

public class VolatileImmutable {

    private ImmutableInteger counterOne = new ImmutableInteger(0);
    private ImmutableInteger counterTwo = new ImmutableInteger(0);

    public synchronized void incrementCounters() {
        counterOne = counterOne.increment();
        counterTwo = counterTwo.increment();
    }

    public synchronized void showCounters() {
        System.out.println("counterOne: " + counterOne.getValue() + "; counterTwo: " + counterTwo.getValue());
    }

    public static void main(String[] args) {

        VolatileImmutable bittnetVolatile = new VolatileImmutable();
        Thread threadOne = new Thread(getTask(bittnetVolatile));
        Thread threadTwo = new Thread(getTask(bittnetVolatile));

        threadOne.start();
        threadTwo.start();
    }

    private static Runnable getTask(VolatileImmutable bittnetVolatile) {
        return () -> {
            for (int i = 0; i < 100000; i++) {
                bittnetVolatile.incrementCounters();
                bittnetVolatile.showCounters();
            }
        };
    }
}
