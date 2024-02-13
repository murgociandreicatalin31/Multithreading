package ro.ctrln.java.semaphores;

import javax.swing.plaf.SeparatorUI;
import java.util.concurrent.Semaphore;

public class Stadium {

    private Semaphore semaphore;

    public Stadium(int maximumPlaces) {
        semaphore = new Semaphore(maximumPlaces);
    }

    public boolean tryToAccess() {
        return semaphore.tryAcquire();
    }

    public void exitStadium() {
        semaphore.release();
    }

    public int availablePlaces() {
        return semaphore.availablePermits();
    }
}
