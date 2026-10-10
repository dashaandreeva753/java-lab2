package java2.number4;

public class Main {

    public static void main(String[] args) {
        System.out.println("Case 1:");
        System.out.println(testReturn());

        System.out.println("\nCase 2:");
        try {
            testThrow();
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\nCase 3:");
        try {
            testCatch();
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    static int testReturn() {
        try {
            System.out.println("try");
            return 10;
        } finally {
            System.out.println("finally");
        }
    }

    static void testThrow() {
        try {
            System.out.println("try");
            throw new RuntimeException("Error in try");
        } finally {
            System.out.println("finally");
        }
    }

    static void testCatch() {
        try {
            System.out.println("try");
            throw new RuntimeException("Error in try");
        } catch (RuntimeException e) {
            System.out.println("catch");
            throw new RuntimeException("Error in catch");
        } finally {
            System.out.println("finally");
        }
    }
}
