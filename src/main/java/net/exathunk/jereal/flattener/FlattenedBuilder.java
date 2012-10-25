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

    // path is delimiter-trailed
    private final String path;
    private final String delimiter;
    private final String nullToken;

    public FlattenedBuilder(String path, String delimiter, String nullToken) {
        super();
        this.path = path;
        this.delimiter = delimiter;
        this.nullToken = nullToken;
        assert path != null && delimiter != null && nullToken != null;
    }

    @Override
    public void addJitem(Jitem jitem) {
        addJitem(jitem, path);
    }

    private void addJitem(Jitem jitem, String path) {
        String newPath;
        if (path.isEmpty()) {
            newPath = (jitem.key == null ? nullToken : jitem.key);
        } else {
          newPath = path + delimiter + (jitem.key == null ? nullToken : jitem.key);
        }
        if (jitem.model.equals(Jitem.Model.OBJECT)) {
            for (Jitem child : (Jerial)jitem.value) {
                addJitem(child, newPath);
            }
        } else {
            super.addJitem(jitem.withKey(newPath));
        }
    }
}
