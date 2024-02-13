package ro.ctrln.java.concurrency.model;

// read-modify-write
public class StudentCampus {

    private String students = "";
    private long studentId = 0;

    public synchronized long addStudent() {
        // aici este un punct critic
        students += ("Student" + studentId);
        studentId++;
        return studentId;
    }

    public synchronized String getStudents() {
        // aici este un punct critic
        return students;
    }

    public long addStudentIntrinsicLock() {
        synchronized (this) { //intrinsic lock
            students += ("Student" + studentId);
            studentId++;
            return studentId;
        }
    }
}
