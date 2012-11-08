package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.SchemaRef;

/**
 * charolastra 11/6/12 2:08 AM
 */
public interface TypeOracle {
    KlassTree makeType(SchemaRef type);
}
