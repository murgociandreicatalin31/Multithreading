package ro.ctrln.java.volatile_variables;

public class Volatile {

    private volatile int counterOne = 0;
    private volatile int counterTwo = 0;

    public synchronized void incrementCounters() {
        counterOne++;
        counterTwo++;
    }

    public synchronized void showCounters() {
        System.out.println("counterOne: " + counterOne + "; counterTwo: " + counterTwo);
    }

    public static void main(String[] args) {

        Volatile bittnetVolatile = new Volatile();
        Thread threadOne = new Thread(getTask(bittnetVolatile));
        Thread threadTwo = new Thread(getTask(bittnetVolatile));

        threadOne.start();
        threadTwo.start();
    }

    private static Runnable getTask(Volatile bittnetVolatile) {
        return () -> {
            for (int i = 0; i < 1000000; i++) {
                bittnetVolatile.incrementCounters();
                bittnetVolatile.showCounters();
            }
        };
    }
}
