package number10;

import java.util.Locale;

public class CourseCode {
    private final String value;

    public CourseCode(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code cannot be empty");
        }

        String normalized = value.trim().toUpperCase(Locale.ROOT);

        if (!normalized.matches("[A-Z]{2,5}-[0-9]{3}")) {
            throw new IllegalArgumentException("Invalid course code");
        }

        this.value = normalized;
    }

    public String value() {
        return value;
    }
}