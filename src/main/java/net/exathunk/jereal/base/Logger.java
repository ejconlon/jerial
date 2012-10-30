package net.exathunk.jereal.base;

public class Logger {

    public static enum Level implements Comparable<Level> {
        TRACE, DEBUG, INFO, WARN, ERROR, CRITICAL
    }

    private static final Level LEVEL = Level.INFO;

    public static void log(Level level, Object message) {
        if (LEVEL.compareTo(level) <= 0) {
            System.err.println("LOG["+LEVEL.name()+"]: "+message);
        }
    }
}
