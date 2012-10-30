package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.core.PathPart;

public class JerialContext {

    public final JerialBuilderFactory factory;
    public final JerialBuilder builder;
    public final ConsList<PathPart> path;

    public JerialContext() {
        this(new SimpleMapBuilderFactory());
    }

    private JerialContext(JerialBuilderFactory factory) {
        this.factory = factory;
        this.path = ConsList.nil();
        this.builder = factory.createJerialBuilder(path);
    }

    private JerialContext(JerialBuilderFactory factory, ConsList<PathPart> path, JerialBuilder builder) {
        this.factory = factory;
        this.path = path;
        this.builder = builder;
    }

    public JerialContext push(PathPart key) {
        final ConsList<PathPart> newPath = path.cons(key);
        JerialBuilder nextBuilder = factory.createJerialBuilder(newPath);
        return new JerialContext(factory, newPath, nextBuilder);
    }
}
