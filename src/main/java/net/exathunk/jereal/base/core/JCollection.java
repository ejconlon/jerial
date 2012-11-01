package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.Maybe;
import net.exathunk.jereal.base.functional.Sequence;

import java.util.Map;

/**
 * charolastra 10/28/12 1:49 AM
 */
public interface JCollection<K, V> extends Visitable {
    Sequence<Map.Entry<K, V>> seq();
    boolean containsKey(K key);
    Maybe<V> get(K key);
}
