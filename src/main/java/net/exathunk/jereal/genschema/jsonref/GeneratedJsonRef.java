package net.exathunk.jereal.genschema.jsonref;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public class GeneratedJsonRef implements GeneratedJsonRefLike, GeneratedJsonRefRefable {


    public GeneratedJsonRef() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedJsonRef{ ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedJsonRefLike) {
            GeneratedJsonRefLike other = (GeneratedJsonRefLike) o;
            return true;
        } else if (o instanceof GeneratedJsonRefRefable) {
            GeneratedJsonRefRefable other = (GeneratedJsonRefRefable) o;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        return result;
    }

}
