package net.exathunk.jereal.base.operators.declaration;

import net.exathunk.jereal.base.operators.OperatorMap;
import net.exathunk.jereal.base.operators.declaration.DeclarationException;

/**
 * charolastra 10/29/12 12:41 PM
 */
public interface OperatorMapBuilder<D, E> {
    void buildOperatorMap(OperatorMap<D, E> opMap) throws DeclarationException;
}
