package net.exathunk.jereal.base.operators;

import java.util.HashSet;
import java.util.Map;

import net.exathunk.jereal.base.core.SuperModel;

import java.util.HashMap;
import java.util.Set;

/**
 * charolastra 10/29/12 1:44 PM
 */
public class Declarer<X> implements OperatorMapBuilder<X> {

    private final Map<String, Implementer<X>> implementers;

    public Declarer() {
        this.implementers = new HashMap<String, Implementer<X>>();
    }

    private static <Z> Set<Z> makeSet(Z... zs) {
        Set<Z> set = new HashSet<Z>(zs.length);
        for (Z z : zs) {
            set.add(z);
        }
        return set;
    }

    public Implementer<X> declare(String key, Set<SuperModel> models) throws DeclarationException {
        if (implementers.containsKey(key)) {
            throw new DeclarationException("Cannot declare twice: "+key);
        }
        Implementer<X> implementer = new Implementer<X>(key, models);
        implementers.put(key, implementer);
        return implementer;
    }

    public Implementer<X> declare(String key, SuperModel... models) throws DeclarationException {
        return declare(key, makeSet(models));
    }

    public Implementer<X> reopen(String key) throws DeclarationException {
        Implementer<X> implementer = implementers.get(key);
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
        Implementer<X> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasDeclared(model);
        } else {
            return false;
        }
    }

    public boolean hasImplementedAny(String key) {
        Implementer<X> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasImplementedAny();
        } else {
            return false;
        }
    }

    public boolean hasImplementedAny() {
        for (Implementer<X> implementer : implementers.values()) {
            if (implementer.hasImplementedAny()) return true;
        }
        return false;
    }

    public boolean hasImplementedAll(String key) {
        Implementer<X> implementer = implementers.get(key);
        if (implementer != null) {
            return implementer.hasImplementedAll();
        } else {
            return false;
        }
    }

    public boolean hasImplementedAll() {
        for (Implementer<X> implementer : implementers.values()) {
            if (!implementer.hasImplementedAll()) return false;
        }
        return true;
    }

    @Override
    public void buildOperatorMap(OperatorMap<X> opMap) throws DeclarationException {
        for (Map.Entry<String, Implementer<X>> entry : implementers.entrySet()) {
            entry.getValue().buildOperatorMap(opMap);
        }
    }
}
