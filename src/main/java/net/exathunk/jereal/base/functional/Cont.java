package net.exathunk.jereal.base.functional;

import java.util.List;
import java.util.Map;

/**
 * charolastra 11/1/12 2:50 PM
 */
public interface Cont<U> {
    boolean isSingle();
    boolean isMap();
    boolean isList();
    Ref<U> getSingle();
    Ref<List<U>> getList();
    Ref<Map<String, U>> getMap();
    void setCont(Cont<U> cont);
}
