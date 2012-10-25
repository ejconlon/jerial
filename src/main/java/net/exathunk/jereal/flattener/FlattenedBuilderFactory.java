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

    private final String delimiter;
    private final String nullToken;

    public FlattenedBuilderFactory(String delimiter, String nullToken) {
        this.delimiter = delimiter;
        this.nullToken = nullToken;
    }

    private String revCat(ConsList<String> path) {
        Pair<Integer, List<String>> pair = path.toRevList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        final int len = pair.getKey();
        for (String p : pair.getValue()) {
            if (i < len - 1) {
                sb.append(p == null ? nullToken : p);
                if (i < len - 2) {
                    sb.append(delimiter);
                }
            }
            i += 1;
        }
        return sb.toString();
    }

    @Override
    public JerialBuilder createJerialBuilder(ConsList<String> path) {
        return new FlattenedBuilder(revCat(path), delimiter, nullToken);
    }
}
