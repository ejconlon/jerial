package net.exathunk.jereal.base;

import java.util.List;

public interface JerialBuilderFactory {
    // path is the list of keys from the root
    // [] <= at root
    // "foo" : { "bar" : ... }} should create a builder for ... with ["foo", "bar"]
    JerialBuilder createJerialBuilder(List<String> path);
}
