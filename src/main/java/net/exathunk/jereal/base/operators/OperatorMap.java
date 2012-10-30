package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.Visitable;
import net.exathunk.jereal.base.functional.TwoLevelMap;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.core.Operator;

import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 10/29/12 12:29 PM
 */
public class OperatorMap<D, E> {
    private final Map<Direction, TwoLevelMap<Path, SuperModel, Operator<D, E, ?>>> map;

    public OperatorMap() {
        map = new TreeMap<Direction, TwoLevelMap<Path, SuperModel, Operator<D, E, ?>>>();
        for (Direction d : Direction.values()) {
            map.put(d, new TwoLevelMap<Path, SuperModel, Operator<D, E, ?>>());
        }
    }

    public TwoLevelMap<Path, SuperModel, Operator<D, E, ?>> dir(Direction d) {
        return map.get(d);
    }
}
