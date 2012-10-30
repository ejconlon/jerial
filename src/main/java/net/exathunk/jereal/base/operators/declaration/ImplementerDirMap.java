package net.exathunk.jereal.base.operators.declaration;

import java.util.Map;

/**
 * charolastra 10/29/12 11:58 PM
 */
public class ImplementerDirMap<D, E> {
    private final Map<Implementer.Direction, ImplementerPathMap<D, E>> dirMap;

    ImplementerDirMap(Map<Implementer.Direction, ImplementerPathMap<D, E>> dirMap) {
        this.dirMap = dirMap;
    }

    public ImplementerPathMap<D, E> dir(Implementer.Direction dir) {
        return dirMap.get(dir);
    }
}
