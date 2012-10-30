package net.exathunk.jereal.base.operators.declaration;

import net.exathunk.jereal.base.operators.OperatorMap;

/**
 * charolastra 10/29/12 12:41 PM
 */
public interface OperatorMapBuilder<J, F> {
    void buildOperatorMap(OperatorMap<J, F> opMap) throws DeclarationException;
}
