package net.exathunk.jereal.base.operators.declaration;

import java.util.*;

import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.Direction;

/**
 * charolastra 10/29/12 1:44 PM
 */
public class DeclarationBuilder<J, F> {

    private final Map<Path, Set<SuperModel>> declarations;

    public DeclarationBuilder() {
        this.declarations = new HashMap<Path, Set<SuperModel>>();
    }

    private static <Z> Set<Z> makeSet(Z... zs) {
        Set<Z> set = new HashSet<Z>(zs.length);
        for (Z z : zs) {
            set.add(z);
        }
        return set;
    }

    public void declare(Path path, Set<SuperModel> models) throws DeclarationException {
        if (declarations.containsKey(path)) {
            throw new DeclarationException("Cannot declare twice: "+path);
        }
        declarations.put(path, models);
    }

    public void declare(Path path, SuperModel... models) throws DeclarationException {
        declare(path, makeSet(models));
    }

    public ImplementerDirMap<J, F> buildImplementers() {
        Map<Direction, ImplementerPathMap<J, F>> dirMap = new TreeMap<Direction, ImplementerPathMap<J, F>>();
        for (Direction dir : Direction.values()) {
            Map<Path, Implementer<J, F>> implementers = new HashMap<Path, Implementer<J, F>>();
            for (Map.Entry<Path, Set<SuperModel>> entry : declarations.entrySet()) {
                Implementer<J, F> implementer = new Implementer<J, F>(dir, entry.getKey(), entry.getValue());
                implementers.put(entry.getKey(), implementer);
            }
            dirMap.put(dir, new ImplementerPathMap<J, F>(implementers));
        }
        return new ImplementerDirMap<J, F>(dirMap);
    }
}
