package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.core.PathPart;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 10/25/12 10:46 AM
 */
public class TreeNodeMap<T> implements Iterable<Map.Entry<PathPart, TreeNode<T>>> {

    private boolean sawAdd = false;
    private boolean addedKey = false;
    private final Map<PathPart, TreeNode<T>> map = new TreeMap<PathPart, TreeNode<T>>();

    public void putKeyed(String key, TreeNode<T> node) {
        if (sawAdd) {
            assert addedKey;
        } else {
            sawAdd = true;
            addedKey = true;
        }
        map.put(PathPart.key(key), node);
    }

    public void putIndexed(Integer index, TreeNode<T> node) {
        if (sawAdd) {
            assert !addedKey;
        } else {
            sawAdd = true;
            addedKey = false;
        }
        map.put(PathPart.index(index), node);
    }

    public boolean isObject() {
        return !sawAdd || addedKey;
    }

    public boolean isArray() {
        return sawAdd && !addedKey;
    }

    @Override
    public Iterator<Map.Entry<PathPart, TreeNode<T>>> iterator() {
        return map.entrySet().iterator();
    }

    public boolean isEmpty() {
        return !sawAdd;
    }
}
