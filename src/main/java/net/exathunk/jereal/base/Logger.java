package net.exathunk.jereal.base;

public class Logger {
    private static boolean enabled = true;

    public static void log(Object message) {
        if (enabled) {
            System.err.println("LOG: "+message);
        }
    }
}
