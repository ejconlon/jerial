package net.exathunk.jereal.base.util;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.core.PathPart;

/**
 * charolastra 10/25/12 9:18 AM
 */
public interface PathConverter {
    String convertPath(ConsList<PathPart> path);
}
