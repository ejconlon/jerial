package net.exathunk.jereal.base;

public class JsonParser implements JerialVisitorAdapter<String> {
    public void runJerialVisitor(String s, JerialVisitor visitor) throws JerializerException {
        boolean inquote = false;
        int i = 0;
        final int z = s.length();
        int numOpen = 0;
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        StringBuilder cur = key;
        boolean skipComma = false;
        while (i < z) {
            final char c = s.charAt(i);
            switch (c) {
                case '{':
                    if (numOpen > 0) {
                        assert key.length() > 0;
                        assert cur == value;
                        visitor.seeObjectFieldStart(key.toString());
                        key.setLength(0);
                        cur = key;
                        skipComma = true;
                    } else {
                        visitor.seeStartObject();
                    }
                    numOpen += 1;
                    break;

                case '}':
                    assert numOpen > 0;
                    numOpen -= 1;
                    if (key.length() > 0) {
                        assert value.length() > 0;
                        emit(key, value, visitor);
                        key.setLength(0);
                        value.setLength(0);
                        cur = key;
                    }
                    visitor.seeEndObject();
                    break;

                case ':':
                    assert key.length() > 0;
                    assert cur == key;
                    assert value.length() == 0;
                    assert !inquote;
                    cur = value;
                    break;

                case '"':
                    if (cur == value) {
                        cur.append(c);
                    }
                    inquote = !inquote;
                    break;

                case ',':
                    if (!skipComma) {
                        assert key.length() > 0;
                        assert value.length() > 0;
                        emit(key, value, visitor);
                        key.setLength(0);
                        value.setLength(0);
                        cur = key;
                    } else {
                        skipComma = false;
                    }
                    break;

                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    if (inquote) {
                        cur.append(c);
                    }
                    break;

                default:
                    cur.append(c);
                    break;
            }
            i += 1;
        }

    }

    private static void emit(StringBuilder key, StringBuilder value, JerialVisitor visitor) throws JerializerException {
        final String ks = key.toString();
        if (value.length() > 1 && value.charAt(0) == '"' && value.charAt(value.length()-1) == '"') {
            visitor.seeStringField(ks, value.substring(1, value.length() - 1));
            return;
        }
        final String vs = value.toString();
        try {
            visitor.seeLongField(ks, Long.parseLong(vs));
            return;
        } catch (NumberFormatException ignored) {}
        try {
            visitor.seeDoubleField(ks, Double.parseDouble(vs));
            return;
        } catch (NumberFormatException ignored) {}
        if (vs.equals("true")) {
            visitor.seeBooleanField(ks, true);
        } else if (vs.equals("false")) {
            visitor.seeBooleanField(ks, false);
        } else {
            throw new JerializerException("Bad value in kv: "+ks+" => "+vs);
        }
    }
}
