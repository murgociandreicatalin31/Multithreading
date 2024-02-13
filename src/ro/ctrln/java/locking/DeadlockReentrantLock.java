package ro.ctrln.java.locking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockReentrantLock {

    private final ReentrantLock objectOne = new ReentrantLock();
    private final ReentrantLock objectTwo = new ReentrantLock();

    public void energizeObjectOne() {
        try {
            if(objectOne.tryLock(50, TimeUnit.MILLISECONDS)) {
                if(objectTwo.tryLock(50, TimeUnit.MILLISECONDS)) {
                    energize();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if(objectOne.isHeldByCurrentThread()) {
                objectOne.unlock();
            }
            if(objectTwo.isHeldByCurrentThread()) {
                objectTwo.unlock();
            }
        }
    }

    public void energizeObjectTwo() {
        try {
            if(objectTwo.tryLock(50, TimeUnit.MILLISECONDS)) {
                if(objectOne.tryLock(50, TimeUnit.MILLISECONDS)) {
                    energizeAgain();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if(objectOne.isHeldByCurrentThread()) {
                objectOne.unlock();
            }
            if(objectTwo.isHeldByCurrentThread()) {
                objectTwo.unlock();
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
