package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.VisitException;
import net.exathunk.jereal.base.core.Visitable;
import net.exathunk.jereal.base.functional.EitherRef;
import net.exathunk.jereal.base.functional.TwoLevelMap;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.core.Operator;

import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 10/29/12 12:29 PM
 */
public class OperatorMap<J, F> {
    private final Map<Direction, TwoLevelMap<Path, SuperModel, Operator<J, F>>> map;

    public OperatorMap() {
        map = new TreeMap<Direction, TwoLevelMap<Path, SuperModel, Operator<J, F>>>();
        for (Direction d : Direction.values()) {
            map.put(d, new TwoLevelMap<Path, SuperModel, Operator<J, F>>());
        }
    }

    public TwoLevelMap<Path, SuperModel, Operator<J, F>> dir(Direction d) {
        return map.get(d);
    }
}
