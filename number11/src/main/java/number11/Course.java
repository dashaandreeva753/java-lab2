package number11;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String courseCode;
    private final int capacity;
    private final List<String> students = new ArrayList<>();

    public Course(String courseCode, int capacity) {
        this.courseCode = courseCode;
        this.capacity = capacity;
    }

    public void enroll(String studentId) {
        if (students.size() >= capacity) {
            throw new EnrollmentRejectedException(courseCode, studentId);
        }

        students.add(studentId);
    }

    public List<String> getStudents() {
        return List.copyOf(students);
    }
}