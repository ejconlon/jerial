package net.exathunk.jereal.base.operators;

import java.util.HashSet;
import java.util.Map;

import net.exathunk.jereal.base.core.SuperModel;

import java.util.HashMap;
import java.util.Set;

/**
 * charolastra 10/29/12 1:44 PM
 */
public class Declarer<D, E> implements OperatorMapBuilder<D, E> {

    private final Map<String, Implementer<D, E>> implementers;

    public Declarer() {
        this.implementers = new HashMap<String, Implementer<D, E>>();
    }

    private static <Z> Set<Z> makeSet(Z... zs) {
        Set<Z> set = new HashSet<Z>(zs.length);
        for (Z z : zs) {
            set.add(z);
        }
        return set;
    }

    public Implementer<D, E> declare(String key, Set<SuperModel> models) throws DeclarationException {
        if (implementers.containsKey(key)) {
            throw new DeclarationException("Cannot declare twice: "+key);
        }
        Implementer<D, E> implementer = new Implementer<D, E>(key, models);
        implementers.put(key, implementer);
        return implementer;
    }

    public Implementer<D, E> declare(String key, SuperModel... models) throws DeclarationException {
        return declare(key, makeSet(models));
    }

    public Implementer<D, E> reopen(String key) throws DeclarationException {
        Implementer<D, E> implementer = implementers.get(key);
        if (implementer != null) {
            if (implementer.hasImplementedAll()) {
                throw new DeclarationException("Implementer is sealed: "+key);
            } else {
                return implementer;
            }
        } else {
            throw new DeclarationException("Have not declared "+key);
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
        for (Map.Entry<String, Implementer<D, E>> entry : implementers.entrySet()) {
            entry.getValue().buildOperatorMap(opMap);
        }
    }
}
