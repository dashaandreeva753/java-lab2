package java2.number6;

public class CourseImportException extends Exception {

    private final int recordNumber;

    public CourseImportException(int recordNumber, Throwable cause) {
        super("Course import failed at record " + recordNumber, cause);
        this.recordNumber = recordNumber;
    }

    public int getRecordNumber() {
        return recordNumber;
    }
}
