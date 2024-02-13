package ro.ctrln.java.wait_notify;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileTasks {

    public static void main(String[] args) {

        FileResource fileResource = new FileResource();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WritingTask(fileResource));
        executorService.execute(new ReadingTask(fileResource));
        executorService.execute(new DeletingTask(fileResource));

        executorService.shutdown();
    }
}
