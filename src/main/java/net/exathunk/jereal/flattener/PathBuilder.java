package net.exathunk.jereal.flattener;

/**
 * charolastra 10/25/12 9:18 AM
 */
public interface PathBuilder {
    String addObjectKey(String path, String key);
    String addArrayIndex(String path, int index);
}
