package ro.ctrln.java.priority;

public class PriorityThread extends Thread{

    private String priorityThreadName;

    public PriorityThread() {}

    public PriorityThread(String priorityThreadName, int priority) {
        setPriority(priority);
        this.priorityThreadName = priorityThreadName;
    }

    public void setPriorityThreadName(String priorityThreadName) {
        this.priorityThreadName = priorityThreadName;
    }

    @Override
    public void run() {
        System.out.println("Numele threadului este: " + priorityThreadName + " cu prioritatea: " + getPriority());
    }
}
