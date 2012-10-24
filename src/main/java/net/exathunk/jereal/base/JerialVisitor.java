package net.exathunk.jereal.base;

public interface JerialVisitor<T> {

    static interface ObjectVisitor<W> extends Writer<W> {
        ObjectVisitor seeObjectFieldStart(String key);
        //ArrayVisitor seeArrayFieldStart(String key);
        void seeStringField(String key, String value);
        void seeBooleanField(String key, Boolean value);
        void seeLongField(String key, Long value);
        void seeDoubleField(String key, Double value);
    }

    /*static interface ArrayVisitor {
        ObjectVisitor seeObjectItemStart();
        ArrayVisitor seeArrayItemStart();
        void seeStringItem(String value);
        void seeBooleanItem(Boolean value);
        void seeLongItem(Long value);
        void seeDoubleItem(Double value);
    }*/

   ObjectVisitor<T> getObjectVisitor();
}
