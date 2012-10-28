package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.Logger;
import net.exathunk.jereal.base.PathConverter;
import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.List;

/**
 * charolastra 10/24/12 9:14 PM
 */
public class FlattenedBuilder extends MapBuilder {

    private final ConsList<PathPart> rootPath;
    private final PathConverter pathConverter;

    public FlattenedBuilder(PathConverter pathConverter, ConsList<PathPart> rootPath) {
        super();
        this.pathConverter = pathConverter;
        this.rootPath = rootPath;
        assert pathConverter != null;
        assert rootPath != null;
    }

    @Override
    public void addJitem(Jitem jitem) {
        addJitem(jitem, rootPath);
    }

    private void addJitem(Jitem jitem, ConsList<PathPart> path) {
        Logger.log("HIT PATH: " + pathConverter.convertPath(path) + " => " + jitem.getPart());
        final ConsList<PathPart> newPath = path.cons(jitem.getPart());
        if (jitem.isObject()) {
            for (Jitem child : jitem.getObject()) {
                addJitem(child, newPath);
            }
        } else if (jitem.isArray()) {
            for (Jitem child : jitem.getArray()) {
                addJitem(child, newPath);
            }
        } else {
            String converted = pathConverter.convertPath(newPath);
            super.addJitem(jitem.withPart(PathPart.key(converted)));
        }
    }
}
