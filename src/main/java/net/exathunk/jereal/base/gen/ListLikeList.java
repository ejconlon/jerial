package net.exathunk.jereal.base.gen;

import java.util.List;

/**
 * charolastra 11/8/12 1:45 AM
 */
public class ListLikeList<T> implements ListLike<T> {

    private final List<T> list;

    public ListLikeList(List<T> list) {
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void set(int index, T value) {
        list.set(index, value);
    }

    @Override
    public void add(T value) {
        list.add(value);
    }
}
