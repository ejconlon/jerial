package net.exathunk.jereal.schema;

import java.util.List;

/**
 * charolastra 10/27/12 1:51 PM
 */
public class Type {
    public enum TYPES {
        STRING, NUMBER, INTEGER, BOOLEAN, OBJECT, ARRAY, NULL, ANY
    }

    public List<TYPES> types;
}
