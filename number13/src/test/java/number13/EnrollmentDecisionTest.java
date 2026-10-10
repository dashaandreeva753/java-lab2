package number13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentDecisionTest {

    boolean canEnroll(
            boolean courseOpen,
            boolean hasSeats,
            boolean prerequisiteMet,
            boolean duplicateApplication
    ) {
        return courseOpen
                && hasSeats
                && prerequisiteMet
                && !duplicateApplication;
    }

    @Test
    void rule1_enrollWhenAllConditionsAreMet() {
        assertTrue(canEnroll(true, true, true, false));
    }

    @Test
    void rule2_rejectWhenCourseIsClosed() {
        assertFalse(canEnroll(false, true, true, false));
    }

    @Test
    void rule3_rejectWhenNoSeatsAvailable() {
        assertFalse(canEnroll(true, false, true, false));
    }

    @Test
    void rule4_rejectWhenPrerequisiteIsNotMet() {
        assertFalse(canEnroll(true, true, false, false));
    }

    @Test
    void rule5_rejectDuplicateApplication() {
        assertFalse(canEnroll(true, true, true, true));
    }
}