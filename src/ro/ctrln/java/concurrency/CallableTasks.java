package ro.ctrln.java.concurrency;

import ro.ctrln.java.concurrency.model.ListingTaskWithResult;
import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.utils.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTasks {

    public static void main(String[] args) {

        List<Student> students = PersonRepository.getAllStudents();

        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(executor.submit(new ListingTaskWithResult<>("Task" + i, students)));
        }

        for(Future<Integer> result : results) {
            try {
                if(result.isDone()) {
                    System.out.println(result.get());
                }
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
