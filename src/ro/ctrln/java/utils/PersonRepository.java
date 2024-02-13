package ro.ctrln.java.utils;

import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.concurrency.model.Teacher;

import java.util.ArrayList;

public class PersonRepository {
    public static ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("John", "Doe", 31, "math"));
        teachers.add(new Teacher("Andrea", "Croft", 32, "physics"));
        teachers.add(new Teacher("Alex", "Jonsey", 41, "biology"));
        teachers.add(new Teacher("Martin", "Silenus", 29, "chemistry"));
        teachers.add(new Teacher("Kyle", "Hughes", 24, "music"));
        teachers.add(new Teacher("Rosie", "Baxter", 32, "history"));
        teachers.add(new Teacher("Steff", "Small", 53, "economics"));
        teachers.add(new Teacher("Charlize", "Whitfield", 26, "literature"));
        return teachers;
    }

    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", 23));
        students.add(new Student("Emily", 25));
        students.add(new Student("Eliza", 21));
        students.add(new Student("Ben", 38));
        students.add(new Student("Frank", 21));
//        students.add(new Student("Nicky", 18));
//        students.add(new Student("Jackie", 67));
//        students.add(new Student("Harper", 22));
        return students;
    }
}
