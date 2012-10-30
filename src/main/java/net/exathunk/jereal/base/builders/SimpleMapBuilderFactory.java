package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.Path;

class SimpleMapBuilderFactory implements JerialBuilderFactory {
    @Override
    public JerialBuilder createJerialBuilder(Path path) {
        return new MapBuilder();
    }
}
