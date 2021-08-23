public class Timer {
    private static Long start;

    public static void start() {
        start = System.nanoTime();
    }

    public static void stop() {
        System.out.println((System.nanoTime() - start) / 1000000 + " ms");
    }
}
