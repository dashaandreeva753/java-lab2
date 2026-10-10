package java2.number3;

public class EnrollmentRejectedException extends Exception {

    private final long studentId;
    private final long courseId;
    private final ReasonCode reasonCode;

    public enum ReasonCode {
        COURSE_FULL,
        COURSE_CLOSED,
        PREREQUISITE_NOT_MET,
        ALREADY_ENROLLED
    }

    public EnrollmentRejectedException(
            long studentId,
            long courseId,
            ReasonCode reasonCode) {
        super("Enrollment rejected: " + reasonCode);
        this.studentId = studentId;
        this.courseId = courseId;
        this.reasonCode = reasonCode;
    }

    public EnrollmentRejectedException(
            long studentId,
            long courseId,
            ReasonCode reasonCode,
            Throwable cause) {
        super("Enrollment rejected: " + reasonCode, cause);
        this.studentId = studentId;
        this.courseId = courseId;
        this.reasonCode = reasonCode;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public ReasonCode getReasonCode() {
        return reasonCode;
    }

    @Override
    public String toString() {
        return "EnrollmentRejectedException{" +
                "reasonCode=" + reasonCode +
                '}';
    }
}
