package ro.ctrln.java.wait_notify;


import java.util.Random;

public class DeletingTask implements Runnable {

    private FileResource file;

    public DeletingTask(FileResource file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                file.waitForDeleting();
                System.out.println("Am inceput stergerea!");
                long time = (new Random().nextInt(5) + 1) * 10;
                Thread.sleep(time);
                System.out.println("Stergerea s-a incheiat in: " + time + " milisecunde");
                file.markAsDeleted();
            }
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
