package net.exathunk.jereal.base;

import java.util.List;

public class SimpleMapBuilderFactory implements JerialBuilderFactory {
    @Override
    public JerialBuilder createJerialBuilder(List<String> path) {
        return new MapBuilder();
    }
}
