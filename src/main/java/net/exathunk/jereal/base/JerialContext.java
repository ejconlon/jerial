package net.exathunk.jereal.base;

public class JerialContext {

    public final JerialBuilderFactory factory;
    public final JerialBuilder builder;
    public final ConsList<String> path;

    public JerialContext(JerialBuilderFactory factory) {
        this.factory = factory;
        this.path = ConsList.<String>nil();
        this.builder = factory.createJerialBuilder(path);
    }

    public JerialContext(JerialBuilderFactory factory, ConsList<String> path, JerialBuilder builder) {
        this.factory = factory;
        this.path = path;
        this.builder = builder;
    }

    public JerialContext push(String key) {
        final ConsList<String> newPath = path.cons(key);
        JerialBuilder nextBuilder = factory.createJerialBuilder(newPath);
        return new JerialContext(factory, newPath, nextBuilder);
    }
}
