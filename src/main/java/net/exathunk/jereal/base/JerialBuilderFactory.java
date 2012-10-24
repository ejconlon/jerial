package net.exathunk.jereal.base;

public interface JerialBuilderFactory {
    // path is the list of keys from the root
    // [] <= at root
    // "foo" : { "bar" : ... }} should create a builder for ... with ["foo", "bar"]
    JerialBuilder createJerialBuilder(ConsList<String> path);
}
