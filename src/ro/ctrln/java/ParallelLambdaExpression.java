package ro.ctrln.java;

import ro.ctrln.java.concurrency.model.ListingTaskLambdaExpression;
import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.concurrency.model.Teacher;
import ro.ctrln.java.utils.PersonRepository;

import java.util.List;

public class ParallelLambdaExpression {

    public static void main(String[] args) {

        List<Teacher> teachers = PersonRepository.getAllTeachers();
        List<Student> students = PersonRepository.getAllStudents();
        ListingTaskLambdaExpression<Teacher> teacherListingTask = new ListingTaskLambdaExpression<>();
        ListingTaskLambdaExpression<Student> studentListingTask = new ListingTaskLambdaExpression<>();

        new Thread(() -> {
            teacherListingTask.processEntities(teachers, Thread.currentThread().getName());
        }).start();

        new Thread(() -> {
            studentListingTask.processEntities(students, Thread.currentThread().getName());
        }).start();
    }
}
