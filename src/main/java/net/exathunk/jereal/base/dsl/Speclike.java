package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.Modeled;

import java.util.List;
import java.util.Map;

/**
 * charolastra 11/2/12 6:49 PM
 */
public interface Speclike extends Modeled {
    boolean hasMapSpec();
    Map<String, ? extends Speclike> getMapSpec();
    boolean hasListSpec();
    List<? extends Speclike> getListSpec();
}
