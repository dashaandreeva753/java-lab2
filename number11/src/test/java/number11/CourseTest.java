package number11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseTest {

    @Test
    void rejectedEnrollmentPreservesCourseState() {
        // Arrange
        Course course = new Course("JAVA-101", 1);
        course.enroll("student-1");

        List<String> studentsBefore = course.getStudents();

        // Act
        EnrollmentRejectedException exception = assertThrows(
                EnrollmentRejectedException.class,
                () -> course.enroll("student-2")
        );

        // Assert
        assertEquals(
                "Course JAVA-101 is full; student student-2 cannot enroll",
                exception.getMessage()
        );
        assertEquals("JAVA-101", exception.getCourseCode());
        assertEquals("student-2", exception.getStudentId());
        assertEquals(studentsBefore, course.getStudents());
        assertEquals(List.of("student-1"), course.getStudents());
    }
}