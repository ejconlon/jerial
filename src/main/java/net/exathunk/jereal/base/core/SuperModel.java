package net.exathunk.jereal.base.core;

/**
 * charolastra 10/29/12 2:11 PM
 */
public enum SuperModel {
    STRING, LONG, DOUBLE, BOOLEAN, OBJECT, ARRAY, ANY;   // NULL too?

    public Model toModel() {
        return Model.valueOf(name());
    }
}
