package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.Jerial;
import net.exathunk.jereal.base.core.Jitem;

import java.util.List;

/**
 * charolastra 10/27/12 11:51 PM
 */
public interface ObjectBuilder {
    void put(String key, Jitem jitem);
    Jerial buildObject();
    List<Jitem> buildArray();
}
