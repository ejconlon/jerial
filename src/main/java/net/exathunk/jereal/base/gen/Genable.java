package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.Schema;

import java.util.Map;
import java.util.Set;

/**
 * charolastra 11/7/12 2:20 PM
 */
public interface Genable {
    Klass getKlass();

    Set<Klass> getImports();

    Map<String, KlassTree> getFields();

    Schema getSchema();
}
