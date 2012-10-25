package net.exathunk.jereal.flattener;

import net.exathunk.jereal.base.ConsList;
import net.exathunk.jereal.base.JerialBuilder;
import net.exathunk.jereal.base.MapBuilder;
import net.exathunk.jereal.base.Pair;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;

import java.util.*;

/**
 * charolastra 10/24/12 9:14 PM
 */
public class FlattenedBuilder extends MapBuilder {

    private final String rootPath;
    private final PathBuilder pathBuilder;

    public FlattenedBuilder(PathBuilder pathBuilder, String rootPath) {
        super();
        this.pathBuilder = pathBuilder;
        this.rootPath = rootPath;
        assert pathBuilder != null;
        assert rootPath != null;
    }

    @Override
    public void addJitem(Jitem jitem) {
        addJitem(jitem, rootPath);
    }

    private void addJitem(Jitem jitem, String path) {
        if (jitem.model.equals(Jitem.Model.OBJECT)) {
            String newPath = pathBuilder.addObjectKey(path, jitem.key);
            for (Jitem child : (Jerial)jitem.value) {
                addJitem(child, newPath);
            }
        } else if (jitem.model.equals(Jitem.Model.ARRAY)) {
            int i = 0;
            for (Jitem child : (List<Jitem>)jitem.value) {
                String newPath = pathBuilder.addArrayIndex(path, i);
                addJitem(child, newPath);
                i += 1;
            }
        } else {
            String newPath = pathBuilder.addObjectKey(path, jitem.key);
            super.addJitem(jitem.withKey(newPath));
        }
    }
}
