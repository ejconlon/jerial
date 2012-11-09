package net.exathunk.jereal.genschema.jsonref;

import java.util.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.jsonref.*;

public class JsonRefContainer implements JsonRefContainerLike, JsonRefContainerRefable {

    private final Ref<JsonRef> jsonRef;

    public JsonRefContainer() {
        jsonRef = new RefImpl<JsonRef>();
    }

    @Override
    public boolean hasJsonRef() {
        return !jsonRef.isEmptyRef();
    }
    @Override
    public JsonRef getJsonRef() {
        return jsonRef.getRef();
    }
    @Override
    public void setJsonRef(JsonRef value) {
        jsonRef.setRef(value);
    }
    @Override
    public Ref<JsonRef> getJsonRefRef() {
        return jsonRef;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JsonRefContainer{ ");
        if (!jsonRef.isEmptyRef()) sb.append("jsonRef='").append(jsonRef).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof JsonRefContainerRefable) {
            JsonRefContainerRefable other = (JsonRefContainerRefable) o;
            if (!getJsonRefRef().equals(other.getJsonRefRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + jsonRef.hashCode();
        return result;
    }

}
