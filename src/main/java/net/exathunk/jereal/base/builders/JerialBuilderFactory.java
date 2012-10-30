package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.Path;

interface JerialBuilderFactory {
    // path is the list of keys from the root
    // [] <= at root
    // "foo" : { "bar" : ... }} should create a builder for ... with ["foo", "bar"]
    JerialBuilder createJerialBuilder(Path path);
}
