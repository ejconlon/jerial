package net.exathunk.jereal.base.operators.declaration;

import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.OperatorMap;

import java.util.Map;

/**
 * charolastra 10/30/12 12:11 AM
 */
public class ImplementerMap<J, F> implements OperatorMapBuilder<J, F> {
    private final Map<Path, Implementer<J, F>> implementers;

    ImplementerMap(Map<Path, Implementer<J, F>> implementers) {
        this.implementers = implementers;
    }

    public Implementer<J, F> path(Path path) throws DeclarationException {
        Implementer<J, F> implementer = implementers.get(path);
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
        Implementer<J, F> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasDeclared(model);
        } else {
            return false;
        }
    }

    public boolean hasImplementedAny(String key) {
        Implementer<J, F> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasImplementedAny();
        } else {
            return false;
        }
    }

    public boolean hasImplementedAny() {
        for (Implementer<J, F> implementer : implementers.values()) {
            if (implementer.hasImplementedAny()) return true;
        }
        return false;
    }

    public boolean hasImplementedAll(String key) {
        Implementer<J, F> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasImplementedAll();
        } else {
            return false;
        }
    }

    public boolean hasImplementedAll() {
        for (Implementer<J, F> implementer : implementers.values()) {
            if (!implementer.hasImplementedAll()) return false;
        }
        return true;
    }

    @Override
    public void buildOperatorMap(OperatorMap<J, F> opMap) throws DeclarationException {
        for (Map.Entry<Path, Implementer<J, F>> entry : implementers.entrySet()) {
            entry.getValue().buildOperatorMap(opMap);
        }
    }
}
