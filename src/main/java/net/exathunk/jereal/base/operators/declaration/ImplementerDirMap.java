package net.exathunk.jereal.base.operators.declaration;

import net.exathunk.jereal.base.operators.Direction;

import java.util.Map;

/**
 * charolastra 10/29/12 11:58 PM
 */
public class ImplementerDirMap<D, E> {
    private final Map<Direction, ImplementerPathMap<D, E>> dirMap;

    ImplementerDirMap(Map<Direction, ImplementerPathMap<D, E>> dirMap) {
        this.dirMap = dirMap;
    }

    public ImplementerPathMap<D, E> dir(Direction dir) {
        return dirMap.get(dir);
    }
}
