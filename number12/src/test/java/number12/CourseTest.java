package number12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseTest {

    @TempDir
    Path tempDir;

    @Test
    void eachCourseHasIndependentState() {
        Course first = new Course("JAVA-101");
        Course second = new Course("JAVA-102");

        first.enroll("student-1");

        assertEquals(List.of("student-1"), first.getStudents());
        assertTrue(second.getStudents().isEmpty());
    }

    @Test
    void courseStateDoesNotDependOnTestOrder() {
        Course course = new Course("JAVA-101");

        assertTrue(course.getStudents().isEmpty());

        course.enroll("student-1");

        assertEquals(List.of("student-1"), course.getStudents());
    }

    @Test
    void writesFileIntoTemporaryDirectory() throws Exception {
        Path file = tempDir.resolve("course.txt");

        Files.writeString(file, "JAVA-101");

        assertTrue(Files.exists(file));
        assertEquals("JAVA-101", Files.readString(file));
    }

    @Test
    void toStringContainsCourseCode() {
        Course course = new Course("JAVA-101");

        assertTrue(course.toString().contains("JAVA-101"));
    }
}