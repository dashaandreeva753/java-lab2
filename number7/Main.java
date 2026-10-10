package java2.number7;
import java.util.Optional;

public class Main {

    static class Course {
        private final String code;
        private final double price;

        Course(String code, double price) {
            this.code = code;
            this.price = price;
        }

        public String getCode() {
            return code;
        }

        public double getPrice() {
            return price;
        }
    }

    sealed interface EnrollResult
            permits EnrollSuccess, EnrollFailure {
    }

    record EnrollSuccess(String message) implements EnrollResult {
    }

    record EnrollFailure(String errorCode) implements EnrollResult {
    }

    // 1. Курс может отсутствовать — это нормальный результат поиска
    static Optional<Course> findCourse(String code) {
        if ("JAVA".equals(code)) {
            return Optional.of(new Course("JAVA", 5000));
        }
        return Optional.empty();
    }

    static int parseCourse(String value) throws CourseImportException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new CourseImportException("Invalid course hours", e);
        }
    }

    static EnrollResult enroll(boolean hasAvailableSeats) {
        if (!hasAvailableSeats) {
            return new EnrollFailure("COURSE_FULL");
        }
        return new EnrollSuccess("Enrollment successful");
    }

    static double calculatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative"
            );
        }
        return price * 1.2;
    }

    static class CourseImportException extends Exception {
        CourseImportException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) {
        
        System.out.println("findCourse ");
        System.out.println(findCourse("JAVA").isPresent());
        System.out.println(findCourse("UNKNOWN").isPresent());

       
        System.out.println("\n enroll ");
        System.out.println(enroll(true));
        System.out.println(enroll(false));

       
        System.out.println("\nparseCourse");
        try {
            System.out.println(parseCourse("abc"));
        } catch (CourseImportException e) {
            System.out.println(e.getMessage());
            System.out.println(
                    "Cause: " + e.getCause().getClass().getSimpleName()
            );
        }

      
        System.out.println("\ncalculatePrice ");
        System.out.println(calculatePrice(100));

        try {
            calculatePrice(-10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
