package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/23/12 10:15 PM
 */
public interface ObjectVisitor<W> extends Writer<W> {
    ObjectVisitor<W> seeObjectFieldStart(String key);
    ArrayVisitor<W> seeArrayFieldStart(String key);
    void seeStringField(String key, String value);
    void seeBooleanField(String key, Boolean value);
    void seeLongField(String key, Long value);
    void seeDoubleField(String key, Double value);
}
