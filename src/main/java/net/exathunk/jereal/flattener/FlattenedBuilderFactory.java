package net.exathunk.jereal.flattener;

import net.exathunk.jereal.base.ConsList;
import net.exathunk.jereal.base.JerialBuilder;
import net.exathunk.jereal.base.JerialBuilderFactory;
import net.exathunk.jereal.base.Pair;

import java.util.List;

/**
 * charolastra 10/24/12 9:33 PM
 */
public class FlattenedBuilderFactory implements JerialBuilderFactory {

    private final PathBuilder pathBuilder;

    public FlattenedBuilderFactory(PathBuilder pathBuilder) {
        this.pathBuilder = pathBuilder;
    }

    private String revCat(ConsList<String> path) {
        Pair<Integer, List<String>> pair = path.toRevList();
        String newPath = "";
        int i = 0;
        final int len = pair.getKey();
        for (String p : pair.getValue()) {
            if (i < len - 1) {
                pathBuilder.addObjectKey(newPath, p);
            }
            i += 1;
        }
        return newPath;
    }

    @Override
    public JerialBuilder createJerialBuilder(ConsList<String> path) {
        return new FlattenedBuilder(pathBuilder, revCat(path));
    }
}
