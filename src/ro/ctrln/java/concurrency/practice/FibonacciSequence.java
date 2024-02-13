package ro.ctrln.java.concurrency.practice;

import java.math.BigInteger;

public class FibonacciSequence {

    private boolean stopped = false;
    private BigInteger[] fibonacciSequence = new BigInteger[3];

    public FibonacciSequence() {
        fibonacciSequence[0] = BigInteger.ONE;
        fibonacciSequence[1] = BigInteger.ONE;
        fibonacciSequence[2] = BigInteger.valueOf(2);
    }

    public BigInteger nextFibonacciNumber() {
        fibonacciSequence[0] = fibonacciSequence[1];
        fibonacciSequence[1] = fibonacciSequence[2];
        fibonacciSequence[2] = fibonacciSequence[0].add(fibonacciSequence[1]);
        return fibonacciSequence[2];
    }

    public boolean isFibonacciNumber(BigInteger fibonacciNumber) {
        long n = fibonacciNumber.longValue();
        return perfectSquare(5 * n * n + 4) || perfectSquare(5 * n * n - 4);
    }

    private boolean perfectSquare(long number) {
        int square = (int) Math.sqrt(number);
        return (square * square) == number;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
