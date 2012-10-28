package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.PathConverter;
import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.visitors.PathPart;

/**
 * charolastra 10/24/12 9:33 PM
 */
public class FlattenedBuilderFactory implements JerialBuilderFactory {

    private final PathConverter pathConverter;

    public FlattenedBuilderFactory(PathConverter pathConverter) {
        this.pathConverter = pathConverter;
    }

    @Override
    public JerialBuilder createJerialBuilder(ConsList<PathPart> path) {
        return new FlattenedBuilder(pathConverter, ConsList.<PathPart>nil());
    }
}
