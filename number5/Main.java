package java2.number5;

public class Main {

    static class TestResource implements AutoCloseable {
        private final boolean failOnUse;
        private final boolean failOnClose;

        TestResource(boolean failOnUse, boolean failOnClose) {
            this.failOnUse = failOnUse;
            this.failOnClose = failOnClose;
            System.out.println("open");
        }

        void use() {
            System.out.println("use");

            if (failOnUse) {
                throw new RuntimeException("Use failed");
            }
        }

        @Override
        public void close() {
            System.out.println("close");

            if (failOnClose) {
                throw new RuntimeException("Close failed");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Success ===");
        try (TestResource resource = new TestResource(false, false)) {
            resource.use();
        }

        System.out.println("\n=== Use failure ===");
        try (TestResource resource = new TestResource(true, false)) {
            resource.use();
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n=== Use and close failure ===");
        try (TestResource resource = new TestResource(true, true)) {
            resource.use();
        } catch (RuntimeException e) {
            System.out.println("Main exception: " + e.getMessage());

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println(
                        "Suppressed: " + suppressed.getMessage()
                );
            }
        }
    }
}

