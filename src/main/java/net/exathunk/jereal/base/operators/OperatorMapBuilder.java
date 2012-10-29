package net.exathunk.jereal.base.operators;

/**
 * charolastra 10/29/12 12:41 PM
 */
public interface OperatorMapBuilder<D, E> {
    void buildOperatorMap(OperatorMap<D, E> opMap) throws DeclarationException;
}
