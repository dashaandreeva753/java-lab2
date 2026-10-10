package java2.number3;

public class Main {

    public static void main(String[] args) {
        try {
            try {
                throw new NumberFormatException("Sensitive internal details");
            } catch (NumberFormatException cause) {
                throw new EnrollmentRejectedException(
                        12345,
                        67890,
                        EnrollmentRejectedException.ReasonCode.COURSE_FULL,
                        cause
                );
            }
        } catch (EnrollmentRejectedException e) {
            System.out.println(e.getMessage());
            System.out.println(e);
            System.out.println("Cause type: " +
                    e.getCause().getClass().getSimpleName());
            System.out.println("Student ID: " + e.getStudentId());
            System.out.println("Course ID: " + e.getCourseId());
        }
    }
}
