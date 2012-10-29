package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.core.PathPart;

public class SimpleMapBuilderFactory implements JerialBuilderFactory {
    @Override
    public JerialBuilder createJerialBuilder(ConsList<PathPart> path) {
        return new MapBuilder();
    }
}
