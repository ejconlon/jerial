package net.exathunk.jereal.base.operators.declaration;

import java.util.*;

import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.Path;

/**
 * charolastra 10/29/12 1:44 PM
 */
public class DeclarationBuilder {

    private final Map<Path, Set<Model>> declarations;

    public DeclarationBuilder() {
        this.declarations = new HashMap<Path, Set<Model>>();
    }

    private static <Z> Set<Z> makeSet(Z... zs) {
        Set<Z> set = new HashSet<Z>(zs.length);
        for (Z z : zs) {
            set.add(z);
        }
        return set;
    }

    public void declare(Path path, Set<Model> models) throws DeclarationException {
        if (declarations.containsKey(path)) {
            throw new DeclarationException("Cannot declare twice: "+path);
        }
        declarations.put(path, models);
    }

    public void declare(Path path, Model... models) throws DeclarationException {
        declare(path, makeSet(models));
    }

    public <J, F> ImplementerMap<J, F> buildImplementerMap() {
        Map<Path, Implementer<J, F>> implementers = new HashMap<Path, Implementer<J, F>>();
        for (Map.Entry<Path, Set<Model>> entry : declarations.entrySet()) {
            Implementer<J, F> implementer = new Implementer<J, F>(entry.getKey(), entry.getValue());
            implementers.put(entry.getKey(), implementer);
        }
        return new ImplementerMap<J, F>(implementers);
    }
}
