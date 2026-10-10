package number10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseCodeTest {

    @ParameterizedTest(name = "[{index}] input=''{0}'' -> expected=''{1}''")
    @CsvSource({
            "java-101, JAVA-101",
            "  net-202  , NET-202",
            "WEB-303, WEB-303",
            "cYbEr-404, CYBER-404"
    })
    void normalizesValidCourseCodes(String input, String expected) {
        CourseCode code = new CourseCode(input);

        assertEquals(expected, code.value());
    }

    @ParameterizedTest(name = "[{index}] invalid input=''{0}'' -> IllegalArgumentException")
    @CsvSource({
            "''",
            "'   '",
            "JAVA101",
            "A-123",
            "TOOLONG-123",
            "JAVA-12A"
    })
    void rejectsInvalidCourseCodes(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CourseCode(input)
        );
    }
}