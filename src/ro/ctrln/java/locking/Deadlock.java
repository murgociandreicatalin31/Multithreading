package ro.ctrln.java.locking;

public class Deadlock {

    private final Object objectOne = new Object();
    private final Object objectTwo = new Object();

    public void energizeObjectOne() {
        synchronized (objectOne) {
            synchronized (objectTwo) {
                energize();
            }
        }
    }

    public void energizeObjectTwo() {
        synchronized (objectTwo) {
            synchronized (objectOne) {
                energizeAgain();
            }
        }
    }

    private void energizeAgain() {
        System.out.println("Energize again!");
    }

    private void energize() {
        System.out.println("Energize!");
    }
}
