package ro.ctrln.java;

import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.concurrency.model.Teacher;
import ro.ctrln.java.utils.PersonRepository;

import java.util.ArrayList;

public class Sequencial {

    public static void main(String[] args) {

        ArrayList<Teacher> teachers = PersonRepository.getAllTeachers();
        ArrayList<Student> students = PersonRepository.getAllStudents();

        teachers.forEach(System.out::println);
        students.forEach(System.out::println);

        System.out.println("Obiectele afisate cu parallelStream");
        teachers.parallelStream().forEach(System.out::println);

        students.parallelStream().forEach(System.out::println);
    }
}
