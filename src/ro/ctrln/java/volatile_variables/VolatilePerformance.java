package ro.ctrln.java.volatile_variables;

public class VolatilePerformance {

    private volatile int counterOne = 0;
    private volatile int counterTwo = 0;

    private static volatile int numberOfCounts = 0;

    private static long timeForCounterOne;
    private static long timeForCounterTwo;

    public static void main(String[] args) {

        VolatilePerformance volatilePerformance = new VolatilePerformance();

        new Thread(() -> {
            timeForCounterOne = System.currentTimeMillis();
            while(numberOfCounts < 10) {
                volatilePerformance.counterOne++;
                if(volatilePerformance.counterOne % 100_000_000 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-Am ajuns la 100 mil in: " + (System.currentTimeMillis() - timeForCounterOne) + " ms");
                    timeForCounterOne = System.currentTimeMillis();
                    volatilePerformance.counterOne = 0;
                    numberOfCounts++;
                }
            }
        }).start();

        new Thread(() -> {
            timeForCounterTwo = System.currentTimeMillis();
            while(numberOfCounts < 10) {
                volatilePerformance.counterTwo++;
                if(volatilePerformance.counterTwo % 100_000_000 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-Am ajuns la 100 mil in: " + (System.currentTimeMillis() - timeForCounterTwo) + " ms");
                    timeForCounterTwo = System.currentTimeMillis();
                    volatilePerformance.counterTwo = 0;
                    numberOfCounts++;
                }
            }
        }).start();
    }
}
