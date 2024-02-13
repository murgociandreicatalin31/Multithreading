package ro.ctrln.java;

import ro.ctrln.java.concurrency.model.ListingTask;
import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.concurrency.model.Teacher;
import ro.ctrln.java.utils.PersonRepository;

import java.util.List;

public class Parallel {

    public static void main(String[] args) {

        List<Teacher> teachers = PersonRepository.getAllTeachers();
        List<Student> students = PersonRepository.getAllStudents();

        new Thread(new ListingTask<>("Teachers", teachers)).start();
        new Thread(new ListingTask<>("Students", students)).start();
    }
}
