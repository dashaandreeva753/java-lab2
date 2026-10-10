package java2.number6;

public class Main {

    static int parseCourseHours(String value) {
        return Integer.parseInt(value);
    }

    static int importCourse(String value, int recordNumber)
            throws CourseImportException {
        try {
            return parseCourseHours(value);
        } catch (NumberFormatException e) {
            throw new CourseImportException(recordNumber, e);
        }
    }

    public static void main(String[] args) {
        try {
            int hours = importCourse("abc", 3);
            System.out.println("Course hours: " + hours);
        } catch (CourseImportException e) {
            System.out.println(e.getMessage());
            System.out.println("Record: " + e.getRecordNumber());
            System.out.println(
                    "Original cause: "
                            + e.getCause().getClass().getSimpleName()
            );
        }
    }
}
