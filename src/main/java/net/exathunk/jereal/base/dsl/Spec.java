package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.Model;

import java.util.List;
import java.util.Map;

/**
 * charolastra 11/2/12 4:07 PM
 */
public class Spec implements Speclike {
    private final Model model;
    private final Map<String, Speclike> mapSpec;
    private final List<Speclike> listSpec;

    private Spec(Model model, Map<String, Speclike> mapSpec, List<Speclike> listSpec) {
        this.model = model;
        this.mapSpec = mapSpec;
        this.listSpec = listSpec;
    }

    public static Spec makeString() {
        return new Spec(Model.STRING, null, null);
    }

    public static Spec makeBoolean() {
        return new Spec(Model.BOOLEAN, null, null);
    }

    public static Spec makeLong() {
        return new Spec(Model.LONG, null, null);
    }

    public static Spec makeDouble() {
        return new Spec(Model.DOUBLE, null, null);
    }

    public static Spec makeObject(Map<String, Speclike> mapSpec) {
        return new Spec(Model.OBJECT, mapSpec, null);
    }

    public static Spec makeArray(List<Speclike> listSpec) {
        return new Spec(Model.ARRAY, null, listSpec);
    }

    public Model getModel() {
        return model;
    }

    public boolean hasMapSpec() {
        return mapSpec != null;
    }

    public boolean hasListSpec() {
        return listSpec != null;
    }

    public Map<String, Speclike> getMapSpec() {
        return mapSpec;
    }

    public List<Speclike> getListSpec() {
        return listSpec;
    }
}
