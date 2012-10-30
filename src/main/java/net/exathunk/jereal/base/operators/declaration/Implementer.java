package net.exathunk.jereal.base.operators.declaration;

import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.operators.Direction;
import net.exathunk.jereal.base.operators.core.Operator;
import net.exathunk.jereal.base.operators.OperatorMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * charolastra 10/29/12 2:29 PM
 */
public class Implementer<D, E> implements OperatorMapBuilder<D, E> {

    private final Direction dir;
    private final Path path;
    private final Set<SuperModel> models;
    private final Map<SuperModel, Operator<D, E, ?>> implementations;

    public Implementer(Direction dir, Path path, Set<SuperModel> models) {
        this.dir = dir;
        this.path = path;
        this.models = models;
        this.implementations = new HashMap<SuperModel, Operator<D, E, ?>>(models.size());
        assert path != null;
        assert models != null;
        assert !models.isEmpty();
    }

    public Implementer<D, E> implement(SuperModel model, Operator<D, E, ?> operator) throws DeclarationException {
        if (!hasDeclared(model)) {
            throw new DeclarationException("Did not declare: "+path+" "+model);
        }
        if (!operator.canCast(model)) {
            throw new DeclarationException("Cannot cast: "+path+" "+model);
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
            throw new DeclarationException("Did not implement: "+path+" => "+sb.toString());
        }
        for (Map.Entry<SuperModel, Operator<D, E, ?>> entry : implementations.entrySet()) {
            opMap.dir(dir).put(path, entry.getKey(), entry.getValue());
        }
    }
}
