package ro.ctrln.java;

import ro.ctrln.java.concurrency.model.ListingTaskThread;
import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.concurrency.model.Teacher;
import ro.ctrln.java.utils.PersonRepository;

import java.util.List;

public class ParallelThread {

    public static void main(String[] args) {

        List<Teacher> teachers = PersonRepository.getAllTeachers();
        List<Student> students = PersonRepository.getAllStudents();

        ListingTaskThread<Teacher> listingTaskTeacherThread = new ListingTaskThread<>("Teachers", teachers);
        listingTaskTeacherThread.start();

        ListingTaskThread<Student> listingTaskStudentThread = new ListingTaskThread<>("Students", students);
        listingTaskStudentThread.start();
    }
}
