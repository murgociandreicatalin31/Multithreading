package ro.ctrln.java.wait_notify;


import java.util.Random;

public class ReadingTask implements Runnable {

    private FileResource file;

    public ReadingTask(FileResource file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                file.waitForReading();
                System.out.println("Am inceput citirea!");
                long time = (new Random().nextInt(5) + 1) * 10;
                Thread.sleep(time);
                System.out.println("Citirea s-a incheiat in: " + time + " milisecunde");
                file.markAsRead();
            }
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
