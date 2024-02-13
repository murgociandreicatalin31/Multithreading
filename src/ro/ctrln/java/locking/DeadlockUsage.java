package ro.ctrln.java.locking;

public class DeadlockUsage {

    public static void main(String[] args) {

        Deadlock deadlock = new Deadlock();

        Thread threadOne = new Thread(deadlock::energizeObjectOne);
        threadOne.start();

        Thread threadTwo = new Thread(deadlock::energizeObjectTwo);
        threadTwo.start();

        for (int i = 0; i < 1000000; i++) {
            new Thread(deadlock::energizeObjectOne).start();
        }

        for (int i = 0; i < 1000000; i++) {
            new Thread(deadlock::energizeObjectTwo).start();
        }
    }
}
