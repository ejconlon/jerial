package net.exathunk.jereal.base;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.*;

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
        Logger.log("HIT PATH: "+pathConverter.convertPath(path)+" => "+jitem.part);
        if (jitem.model.equals(Jitem.Model.OBJECT)) {
            for (Jitem child : (Jerial)jitem.value) {
                addJitem(child, path.cons(jitem.part));
            }
        } else if (jitem.model.equals(Jitem.Model.ARRAY)) {
            for (Jitem child : (List<Jitem>)jitem.value) {
                addJitem(child, path.cons(jitem.part));
            }
        } else {
            ConsList<PathPart> newPath = path.cons(jitem.part);
            String converted = pathConverter.convertPath(newPath);
            super.addJitem(jitem.withPart(PathPart.makeLeft(converted)));
        }
    }
}
