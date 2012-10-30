package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.PathPart;

public class JerialContext {

    public final JerialBuilderFactory factory;
    public final JerialBuilder builder;
    public final Path path;

    public JerialContext() {
        this(new SimpleMapBuilderFactory());
    }

    private JerialContext(JerialBuilderFactory factory) {
        this.factory = factory;
        this.path = Path.root();
        this.builder = factory.createJerialBuilder(path);
    }

    private JerialContext(JerialBuilderFactory factory, Path path, JerialBuilder builder) {
        this.factory = factory;
        this.path = path;
        this.builder = builder;
    }

    public JerialContext push(PathPart key) {
        final Path newPath = path.cons(key);
        JerialBuilder nextBuilder = factory.createJerialBuilder(newPath);
        return new JerialContext(factory, newPath, nextBuilder);
    }

    public JerialContext pushKey(String key) {
        return push(PathPart.key(key));
    }

    public JerialContext pushIndex(Integer index) {
        return push(PathPart.index(index));
    }
}
