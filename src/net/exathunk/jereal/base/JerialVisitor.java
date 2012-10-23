package net.exathunk.jereal.base;

public interface JerialVisitor {
    void seeStartObject();
    void seeEndObject();
    void seeObjectFieldStart(String key);
    void seeStringField(String key, String value);
    void seeBooleanField(String key, Boolean value);
    void seeLongField(String key, Long value);
    void seeDoubleField(String key, Double value);
}
