package net.exathunk.jereal.base.functional;

import java.util.List;
import java.util.Map;

/**
 * charolastra 11/1/12 2:55 PM
 */
public class ContSingle<U> implements Cont<U> {
    private final Ref<U> ref;

    public ContSingle() {
        ref = new RefImpl<U>();
    }

    public ContSingle(Ref<U> ref) {
        this.ref = ref;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public Ref<U> getSingle() {
        return ref;
    }

    @Override
    public Ref<List<U>> getList() {
        throw new IllegalArgumentException("single cont not a list");
    }

    @Override
    public Ref<Map<String, U>> getMap() {
        throw new IllegalArgumentException("single cont not a map");
    }

    @Override
    public void setCont(Cont<U> cont) {
        Ref<U> newRef = cont.getSingle();
        if (!newRef.isEmptyRef())
            ref.setRef(newRef.getRef());
    }
}
