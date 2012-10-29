package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.core.PathPart;

public interface JerialBuilder {
    void addThing(PathPart part, JThing thing);
    JObject buildObject();
    JArray buildArray();
}
