package net.exathunk.jereal.base;

public class SimpleMapBuilderFactory implements JerialBuilderFactory {
    @Override
    public JerialBuilder createJerialBuilder(ConsList<String> path) {
        return new MapBuilder();
    }
}
