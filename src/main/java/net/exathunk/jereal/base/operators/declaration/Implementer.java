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
public class Implementer<J, F> implements OperatorMapBuilder<J, F> {

    private final Path path;
    private final Set<SuperModel> models;
    private final Map<SuperModel, Operator<J, F>> implementations;

    public Implementer(Path path, Set<SuperModel> models) {
        this.path = path;
        this.models = models;
        this.implementations = new HashMap<SuperModel, Operator<J, F>>(models.size());
        assert path != null;
        assert models != null;
        assert !models.isEmpty();
    }

    public Implementer<J, F> implement(SuperModel model, Operator<J, F> operator) throws DeclarationException {
        if (!hasDeclared(model)) {
            throw new DeclarationException("Did not declare: "+path+" "+model);
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
    public void buildOperatorMap(OperatorMap<J, F> opMap) throws DeclarationException {
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
        for (Map.Entry<SuperModel, Operator<J, F>> entry : implementations.entrySet()) {
            opMap.put(path, entry.getKey(), entry.getValue());
        }
    }
}
