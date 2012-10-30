package net.exathunk.jereal.base.operators.declaration;

import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.OperatorMap;

import java.util.HashMap;
import java.util.Map;

/**
 * charolastra 10/30/12 12:11 AM
 */
public class ImplementerPathMap<D, E> implements OperatorMapBuilder<D, E> {
    private final Map<Path, Implementer<D, E>> implementers;

    ImplementerPathMap(Map<Path, Implementer<D, E>> implementers) {
        this.implementers = implementers;
    }

    public Implementer<D, E> path(Path path) throws DeclarationException {
        Implementer<D, E> implementer = implementers.get(path);
        if (implementer != null) {
            if (implementer.hasImplementedAll()) {
                throw new DeclarationException("Implementer is sealed: "+path);
            } else {
                return implementer;
            }
        } else {
            throw new DeclarationException("Have not declared "+path);
        }
    }

    public boolean hasDeclaredAny(String key) {
        return implementers.containsKey(key);
    }

    public boolean hasDeclaredAny() {
        return !implementers.isEmpty();
    }

    public boolean hasDeclaredOne(String key, SuperModel model) {
        Implementer<D, E> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasDeclared(model);
        } else {
            return false;
        }
    }

    public boolean hasImplementedAny(String key) {
        Implementer<D, E> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasImplementedAny();
        } else {
            return false;
        }
    }

    public boolean hasImplementedAny() {
        for (Implementer<D, E> implementer : implementers.values()) {
            if (implementer.hasImplementedAny()) return true;
        }
        return false;
    }

    public boolean hasImplementedAll(String key) {
        Implementer<D, E> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasImplementedAll();
        } else {
            return false;
        }
    }

    public boolean hasImplementedAll() {
        for (Implementer<D, E> implementer : implementers.values()) {
            if (!implementer.hasImplementedAll()) return false;
        }
        return true;
    }

    @Override
    public void buildOperatorMap(OperatorMap<D, E> opMap) throws DeclarationException {
        for (Map.Entry<Path, Implementer<D, E>> entry : implementers.entrySet()) {
            entry.getValue().buildOperatorMap(opMap);
        }
    }
}
