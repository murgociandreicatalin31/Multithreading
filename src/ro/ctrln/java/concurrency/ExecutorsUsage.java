package ro.ctrln.java.concurrency;

import ro.ctrln.java.concurrency.model.ListingTask;
import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.concurrency.model.Teacher;
import ro.ctrln.java.utils.PersonRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsUsage {

    public static void main(String[] args) {

        List<Teacher> teachers = PersonRepository.getAllTeachers();
        List<Student> students = PersonRepository.getAllStudents();

        ListingTask<Teacher> teacherListingTask = new ListingTask<>("Teachers", teachers);
        ListingTask<Student> studentListingTask = new ListingTask<>("Students", students);

        ExecutorService executorService;

        executorService = Executors.newCachedThreadPool();
        executorService.submit(teacherListingTask);
        executorService.submit(studentListingTask);

//        executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(studentListingTask);
//        executorService.submit(teacherListingTask);

//        executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(new ListingTask<>("Teachers1", teachers));
//        executorService.submit(new ListingTask<>("Students1", students));
//        executorService.submit(new ListingTask<>("Students2", students));
//        executorService.submit(new ListingTask<>("Teachers2", teachers));


        //executorService.shutdown();
        executorService.shutdownNow();
    }
}
