package net.exathunk.jereal.base.core;

/**
 * charolastra 10/28/12 3:07 AM
 */
public interface JMutableCollection<K, V> extends JCollection<K, V> {
    boolean set(K key, V value);
    boolean remove(K key);
}
