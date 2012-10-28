package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.Jerial;
import net.exathunk.jereal.base.core.Jitem;

import java.util.List;

public interface JerialBuilder {
    void addJitem(Jitem jitem);
    Jerial buildObject();
    List<Jitem> buildArray();
}
