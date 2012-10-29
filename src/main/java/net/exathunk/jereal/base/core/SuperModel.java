package net.exathunk.jereal.base.core;

/**
 * charolastra 10/29/12 2:11 PM
 */
public enum SuperModel {
    STRING, LONG, DOUBLE, BOOLEAN, OBJECT, ARRAY, NULL, ANY;

    public Model toModel() {
        return Model.valueOf(name());
    }
}
