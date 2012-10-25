package net.exathunk.jereal.base;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.visitors.PathPart;

public class SimpleMapBuilderFactory implements JerialBuilderFactory {
    @Override
    public JerialBuilder createJerialBuilder(ConsList<PathPart> path) {
        return new MapBuilder();
    }
}
