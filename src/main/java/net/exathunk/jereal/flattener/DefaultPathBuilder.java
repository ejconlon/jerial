package net.exathunk.jereal.flattener;

/**
 * charolastra 10/25/12 9:17 AM
 */
public class DefaultPathBuilder implements PathBuilder {

    private final String delimiter = "/";
    private final String nullToken = "NULL";
    private final String arrayStart = "[";
    private final String arrayEnd = "]";

    private String format(String key) {
        if (key == null) return nullToken;
        else return key;
    }

    private String format(int index) {
        return arrayStart + index + arrayEnd;
    }

    @Override
    public String addObjectKey(String path, String key) {
        if (path == null || path.isEmpty()) return format(key);
        else return path + delimiter + format(key);
    }

    @Override
    public String addArrayIndex(String path, int index) {
        if (path == null || path.isEmpty()) return format(index);
        else return path + delimiter + format(index);
    }
}
