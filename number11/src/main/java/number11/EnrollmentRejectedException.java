package number11;

public class EnrollmentRejectedException extends RuntimeException {
    private final String courseCode;
    private final String studentId;

    public EnrollmentRejectedException(String courseCode, String studentId) {
        super("Course " + courseCode + " is full; student " + studentId
                + " cannot enroll");
        this.courseCode = courseCode;
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }
}