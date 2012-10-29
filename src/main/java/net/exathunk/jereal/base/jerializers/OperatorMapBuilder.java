package net.exathunk.jereal.base.jerializers;

/**
 * charolastra 10/29/12 12:41 PM
 */
public interface OperatorMapBuilder<D> {
    void buildOperatorMap(OperatorMap<D> opMap) throws DeclarationException;
}
