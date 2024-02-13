package ro.ctrln.java.priority;

public class PriorityThreadUsage {

    public static void main(String[] args) {

        PriorityThread threadOne = new PriorityThread();
        threadOne.setPriorityThreadName("threadOne");
        PriorityThread threadTwo = new PriorityThread();
        threadTwo.setPriorityThreadName("threadTwo");

        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadTwo.setPriority(Thread.NORM_PRIORITY);

        threadOne.start();
        threadTwo.start();
    }
}
