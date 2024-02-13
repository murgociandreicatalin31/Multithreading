package ro.ctrln.java.volatile_variables;

public class VolatileUsage {

    private static volatile boolean volatileRun = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while(!volatileRun) {

            }
            System.out.println(Thread.currentThread().getName() + "-Am pornit!");

            while(volatileRun) {

            }
            System.out.println(Thread.currentThread().getName() + "-Am oprit!");
        }).start();

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "-Startare!");
        volatileRun = true;

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "-Oprire!");
        volatileRun = false;
    }
}
