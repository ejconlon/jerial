package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.Logger;
import net.exathunk.jereal.base.PathConverter;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.core.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

/**
 * charolastra 10/24/12 9:14 PM
 */
public class FlattenedBuilder extends MapBuilder {
    /*
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
    public void addThing(PathPart part, JThing thing) {
        addThing(part, thing, rootPath);
    }

    private void addThing(PathPart part, JThing thing, ConsList<PathPart> path) {
        Logger.log("HIT PATH: " + pathConverter.convertPath(path) + " => " + part);
        final ConsList<PathPart> newPath = path.cons(part);
        if (thing.isObject()) {
            for (Jitem child : jitem.getObject()) {
                thing.set(child, newPath);
            }
        } else if (jitem.isArray()) {
            for (Jitem child : jitem.getArray()) {
                addJitem(child, newPath);
            }
        } else {
            String converted = pathConverter.convertPath(newPath);
            super.addJitem(jitem.withPart(PathPart.key(converted)));
        }
    } */
}
