package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.SchemaRef;

/**
 * charolastra 11/6/12 2:08 AM
 */
public interface TypeOracle {
    String makeType(String selfType, SchemaRef type, SchemaRef itemType, SchemaRef addlPropType);
}
