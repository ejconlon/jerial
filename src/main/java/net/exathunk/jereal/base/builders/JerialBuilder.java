package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.List;

public interface JerialBuilder {
    void addThing(PathPart part, JThing thing);
    JObject buildObject();
    JArray buildArray();
}
