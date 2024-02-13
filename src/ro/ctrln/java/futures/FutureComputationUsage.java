package ro.ctrln.java.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureComputationUsage {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        FutureComputation futureComputation = new FutureComputation();

        Future<String> futureConcatenation = futureComputation.futureConcatenation("bla");

        while(!futureConcatenation.isDone()) {
            System.out.println("Inca procesez!");
            Thread.sleep(300);
        }

        //System.out.println("Rezultatul este: " + futureConcatenation.get());
        System.out.println("Rezultatul este: " + futureConcatenation.get(2000, TimeUnit.MILLISECONDS));
        futureComputation.shutdownStringExecutor();
    }
}
