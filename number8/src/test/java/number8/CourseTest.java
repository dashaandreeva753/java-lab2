package number8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseTest {

    @Test
    void completeHoursReturns40() {
        // Arrange
        Course course = new Course();

        // Act
        int hours = course.completeHours();

        // Assert
        assertEquals(40, hours);
    }
}