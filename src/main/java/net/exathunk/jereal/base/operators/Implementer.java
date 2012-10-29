package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.SuperModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * charolastra 10/29/12 2:29 PM
 */
public class Implementer<D, E> implements OperatorMapBuilder<D, E> {

    private final String key;
    private final Set<SuperModel> models;
    private final Map<SuperModel, Operator<D, E, ?>> implementations;

    public Implementer(String key, Set<SuperModel> models) {
        this.key = key;
        this.models = models;
        this.implementations = new HashMap<SuperModel, Operator<D, E, ?>>(models.size());
        assert key != null;
        assert models != null;
        assert !models.isEmpty();
    }

    public Implementer<D, E> implement(SuperModel model, Operator<D, E, ?> operator) throws DeclarationException {
        if (!hasDeclared(model)) {
            throw new DeclarationException("Did not declare: "+key+" "+model);
        }
        if (!operator.canCast(model)) {
            throw new DeclarationException("Cannot cast: "+key+" "+model);
        }
        implementations.put(model, operator);
        return this;
    }

    public boolean hasDeclared(SuperModel model) {
        return models.contains(model);
    }

    public boolean hasImplemented(SuperModel model) {
        return implementations.containsKey(model);
    }

    public boolean hasImplementedAny() {
        return implementations.size() > 0;
    }

    public boolean hasImplementedAll() {
        return implementations.size() == models.size();
    }

    @Override
    public void buildOperatorMap(OperatorMap<D, E> opMap) throws DeclarationException {
        if (!hasImplementedAll()) {
            StringBuilder sb = new StringBuilder();
            for (SuperModel model : models) {
                if (!hasImplemented(model)) {
                    sb.append(model).append(",");
                }

            }
            if (sb.length() > 0) sb.deleteCharAt(sb.length()-1);
            throw new DeclarationException("Did not implement: "+key+" => "+sb.toString());
        }
        for (Map.Entry<SuperModel, Operator<D, E, ?>> entry : implementations.entrySet()) {
            opMap.put(key, entry.getKey(), entry.getValue());
        }
    }
}