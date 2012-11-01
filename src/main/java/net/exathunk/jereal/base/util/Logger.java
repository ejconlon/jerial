package net.exathunk.jereal.base.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Logger {

    public static enum Level implements Comparable<Level> {
        TRACE, DEBUG, INFO, WARN, ERROR, CRITICAL
    }

    public static InternalLogger getLogger(Class name) {
        return new InternalLogger(name, POLICY_BUILDER.buildPolicy());
    }

    public static PolicyBuilder getPolicyBuilder() {
        return POLICY_BUILDER;
    }

    private static final PolicyBuilder POLICY_BUILDER = new PolicyBuilder();

    public static class PolicyBuilder extends Policy {
        public PolicyBuilder() {
            super(Level.CRITICAL, new HashMap<Class, Level>());
        }

        public void reset() {
            defaultLevel = Level.CRITICAL;
            customLevels = new HashMap<Class, Level>();
        }

        public PolicyBuilder add(Class name, Level level) {
            customLevels.put(name, level);
            return this;
        }

        private Policy buildPolicy() {
            return new Policy(defaultLevel, new HashMap<Class, Level>(customLevels));
        }
    }

    private static class Policy {
        protected Level defaultLevel;
        protected Map<Class, Level> customLevels;

        protected Policy(Level defaultLevel, Map<Class, Level> customLevels) {
            this.defaultLevel = defaultLevel;
            this.customLevels = customLevels;
        }

        private boolean canLog(Class name, Level level) {
            if (customLevels.containsKey(name)) {
                return customLevels.get(name).compareTo(level) <= 0;
            } else if (defaultLevel.compareTo(level) <= 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static class InternalLogger {
        private final Class name;
        private final Policy policy;

        private InternalLogger(Class name, Policy policy) {
            this.name = name;
            this.policy = policy;
        }

        public void log(Level level, Object... messages) {
            if (policy.canLog(name, level)) {
                StringBuilder sb = new StringBuilder();
                sb.append(level.name());
                sb.append("[");
                sb.append(name.getSimpleName());
                sb.append("] ");
                for (Object message : messages) {
                    sb.append(message);
                    sb.append(' ');
                }
                sb.deleteCharAt(sb.length()-1);
                System.err.println(sb);
            }
        }

        public void trace(Object... messages) {
            log(Level.TRACE, messages);
        }

        public void debug(Object... messages) {
            log(Level.DEBUG, messages);
        }

        public void info(Object... messages) {
            log(Level.INFO, messages);
        }

        public void warn(Object... messages) {
            log(Level.WARN, messages);
        }

        public void error(Object... messages) {
            log(Level.ERROR, messages);
        }

        public void critical(Object... messages) {
            log(Level.CRITICAL, messages);
        }
    }
}
