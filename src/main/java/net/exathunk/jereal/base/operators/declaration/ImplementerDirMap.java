package net.exathunk.jereal.base.operators.declaration;

import net.exathunk.jereal.base.operators.Direction;

import java.util.Map;

/**
 * charolastra 10/29/12 11:58 PM
 */
public class ImplementerDirMap<J, F> {
    private final Map<Direction, ImplementerPathMap<J, F>> dirMap;

    ImplementerDirMap(Map<Direction, ImplementerPathMap<J, F>> dirMap) {
        this.dirMap = dirMap;
    }

    public ImplementerPathMap<J, F> dir(Direction dir) {
        return dirMap.get(dir);
    }
}
