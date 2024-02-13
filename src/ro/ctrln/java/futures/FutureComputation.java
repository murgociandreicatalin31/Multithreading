package ro.ctrln.java.futures;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureComputation {

    private ExecutorService stringExecutor = Executors.newSingleThreadExecutor();

    public Future<String> futureConcatenation(String anotherString) {
        return stringExecutor.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return anotherString.concat(anotherString);
        });
    }

    public void shutdownStringExecutor() {
        stringExecutor.shutdown();
    }
}
