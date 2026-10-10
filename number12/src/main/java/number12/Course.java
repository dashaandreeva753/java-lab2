package number12;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String code;
    private final List<String> students = new ArrayList<>();

    public Course(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void enroll(String studentId) {
        students.add(studentId);
    }

    public List<String> getStudents() {
        return List.copyOf(students);
    }

    @Override
    public String toString() {
        return "Course{code='" + code + "', students=" + students + "}";
    }
}
