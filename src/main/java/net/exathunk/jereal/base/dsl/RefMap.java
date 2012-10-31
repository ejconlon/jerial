package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.functional.Ref;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 10/31/12 1:19 PM
 */
public class RefMap<K, V> implements Iterable<Map.Entry<K, Ref<V>>> {
    private final Map<K, Ref<V>> map;

    public RefMap() {
        map = new TreeMap<K, Ref<V>>();
    }

    public void put(K key, Ref<V> value) {
        map.put(key, value);
    }

    public Iterator<Map.Entry<K, Ref<V>>> iterator() {
        return map.entrySet().iterator();
    }
}
