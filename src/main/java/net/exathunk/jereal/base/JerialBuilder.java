package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;

public interface JerialBuilder {
    void addJitem(Jitem jitem);
    Jerial buildJerial();
}
