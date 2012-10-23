package net.exathunk.jereal.base;

public class JsonObjectWriter implements JerialWriter<StringBuilder> {

    private final StringBuilder stringBuilder;
    private int numOpen = 0;
    private boolean needComma = false;
    private boolean opened = false;
    private boolean closed = false;

    public JsonObjectWriter() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public void seeStartObject() {
        assert !closed;
        opened = true;
        numOpen += 1;
        stringBuilder.append('{');
    }

    @Override
    public void seeEndObject() {
        assert opened && !closed;
        assert numOpen > 0;
        numOpen -= 1;
        if (numOpen == 0) {
            closed = true;
        }
        stringBuilder.append('}');
    }

    private void writeQuoted(String key) {
        stringBuilder.append('"');
        stringBuilder.append(key);
        stringBuilder.append('"');
    }

    private void writeUnquoted(String key) {
        stringBuilder.append(key);
    }

    private void addComma() {
        if (needComma) {
            stringBuilder.append(',');
        }
        needComma = true;
    }

    @Override
    public void seeObjectFieldStart(String key) {
        assert opened && !closed;
        writeQuoted(key);
        stringBuilder.append(':');
        seeStartObject();
    }


    @Override
    public void seeStringField(String key, String value) {
        assert opened && !closed;
        addComma();
        writeQuoted(key);
        stringBuilder.append(':');
        writeQuoted(value);
    }

    @Override
    public void seeBooleanField(String key, Boolean value) {
        assert opened && !closed;
        addComma();
        writeQuoted(key);
        stringBuilder.append(':');
        writeUnquoted(value.toString());
    }

    @Override
    public void seeLongField(String key, Long value) {
        assert opened && !closed;
        addComma();
        writeQuoted(key);
        stringBuilder.append(':');
        writeUnquoted(value.toString());
    }

    @Override
    public void seeDoubleField(String key, Double value) {
        assert opened && !closed;
        addComma();
        writeQuoted(key);
        stringBuilder.append(':');
        writeUnquoted(value.toString());
    }

    @Override
    public void writeJerial(StringBuilder out) {
        assert opened && closed;
        out.append(stringBuilder);
    }
}
