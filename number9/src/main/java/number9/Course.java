package number9;

public class Course {
    private final int hours;

    public Course(int hours) {
        this.hours = hours;
    }

    public int completeHours() {
        if (hours < 1 || hours > 40) {
            throw new IllegalArgumentException(
                "Duration must be between 1 and 40 hours"
            );
        }

        return hours;
    }
}