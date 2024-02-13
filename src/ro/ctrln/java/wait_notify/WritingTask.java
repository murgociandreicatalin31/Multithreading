package ro.ctrln.java.wait_notify;


import java.util.Random;

public class WritingTask implements Runnable {

    private FileResource file;

    public WritingTask(FileResource file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println("Am inceput scrierea!");
                long time = (new Random().nextInt(5) + 1) * 10;
                Thread.sleep(time);
                System.out.println("Scrierea s-a incheiat in: " + time + " milisecunde");
                file.markAsWritten();
                file.waitForWriting();
            }
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
