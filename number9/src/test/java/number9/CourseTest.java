package number9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseTest {

    @Test
    void rejectsDurationBelowMinimum() {
        Course course = new Course(0);

        assertThrows(IllegalArgumentException.class,
                course::completeHours);
    }

    @Test
    void acceptsMinimumDuration() {
        Course course = new Course(1);

        assertEquals(1, course.completeHours());
    }

    @Test
    void acceptsMaximumDuration() {
        Course course = new Course(40);

        assertEquals(40, course.completeHours());
    }

    @Test
    void rejectsDurationAboveMaximum() {
        Course course = new Course(41);

        assertThrows(IllegalArgumentException.class,
                course::completeHours);
    }
}