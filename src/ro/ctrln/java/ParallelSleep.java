package ro.ctrln.java;

import ro.ctrln.java.concurrency.model.ListingTaskWithSleep;
import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.concurrency.model.Teacher;
import ro.ctrln.java.utils.PersonRepository;

import java.util.List;

public class ParallelSleep {

    public static void main(String[] args) {

        List<Teacher> teachers = PersonRepository.getAllTeachers();
        List<Student> students = PersonRepository.getAllStudents();

        Thread threadOne = new Thread(new ListingTaskWithSleep<>("TeacherTask", teachers));
        Thread threadTwo = new Thread(new ListingTaskWithSleep<>("StudentTask", students));

        threadOne.start();
        threadTwo.start();
    }
}
