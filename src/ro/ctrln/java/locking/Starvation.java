package ro.ctrln.java.locking;

public class Starvation {

    public synchronized void starve() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " scrie pe consola!");
        while(true) {
            System.out.println(threadName + " lucreaza de zor!");
        }
    }
}
