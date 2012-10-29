package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;

import java.util.HashMap;
import java.util.Map;

/**
 * charolastra 10/29/12 12:29 PM
 */
public class OperatorMap<D> {
    private final Map<JThing.Model, Map<PathPart, Operator<D>>> map;

    public OperatorMap() {
        map = new HashMap<JThing.Model, Map<PathPart, Operator<D>>>();
    }

    public void put(JThing.Model model, PathPart part, Operator<D> operator) {
        Map<PathPart, Operator<D>> sub = map.get(model);
        if (sub == null) {
            sub = new HashMap<PathPart, Operator<D>>();
            map.put(model, sub);
        }
        sub.put(part, operator);
    }

    public Operator<D> get(JThing.Model model, PathPart part) {
        Map<PathPart, Operator<D>> sub = map.get(model);
        if (sub != null) {
            return sub.get(part);
        } else {
            return null;
        }
    }

    public boolean containsKey(JThing.Model model, PathPart part) {
        Map<PathPart, Operator<D>> sub = map.get(model);
        if (sub != null) {
            return sub.containsKey(part);
        } else {
            return false;
        }
    }
}
