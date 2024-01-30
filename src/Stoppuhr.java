public class Stoppuhr {

    private static long startZeit;

    public static void start() {
        startZeit = System.nanoTime();
    }

    public static void stop(String str) {
        long elapsedNanos = (System.nanoTime() - startZeit)/ 1000000;
        System.out.println(str + " hat " + elapsedNanos + " Millisekunden gedauert.");
    }
}
