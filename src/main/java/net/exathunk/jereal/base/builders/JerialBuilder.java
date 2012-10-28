package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;

import java.util.List;

public interface JerialBuilder {
    void addJitem(Jitem jitem);
    Jerial buildObject();
}
