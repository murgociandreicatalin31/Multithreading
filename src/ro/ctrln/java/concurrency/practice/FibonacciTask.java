package ro.ctrln.java.concurrency.practice;

import java.math.BigInteger;

public class FibonacciTask implements Runnable{

    private FibonacciSequence sequence;
    private int taskNumber;

    public FibonacciTask() {
    }

    public FibonacciTask(int taskNumber, FibonacciSequence sequence) {
        this.taskNumber = taskNumber;
        this.sequence = sequence;
    }

    @Override
    public void run() {
        while(!sequence.isStopped()) {
            synchronized (sequence) {
                BigInteger nextFibonacciCandidate = sequence.nextFibonacciNumber();
                System.out.println(Thread.currentThread().getName() + "-Task" + taskNumber + ": " + nextFibonacciCandidate);
                if(!sequence.isFibonacciNumber(nextFibonacciCandidate)) {
                    sequence.setStopped(true);
                }
            }
        }
    }
}
