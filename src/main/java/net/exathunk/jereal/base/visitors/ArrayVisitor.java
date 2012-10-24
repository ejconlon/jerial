package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/23/12 10:15 PM
 */
public interface ArrayVisitor<W> extends Writer<W> {
    ObjectVisitor<W> seeObjectItemStart();
    ArrayVisitor<W> seeArrayItemStart();
    void seeStringItem(String value);
    void seeBooleanItem(Boolean value);
    void seeLongItem(Long value);
    void seeDoubleItem(Double value);
}
