package net.exathunk.jereal.base;

public class JsonParser<U> implements JerialVisitorAdapter<String, U> {
    public Writer<U> runJerialVisitor(String s, JerialVisitor<U> visitor) throws JerializerException {
        int i = 0;
        final int z = s.length();
        Writer<U> writer = null;
        while (i < z) {
            final char c = s.charAt(i);
            switch (c) {
                case '{':
                    if (writer != null) {
                        throw new JerializerException("Already read object start.");
                    }
                    i += 1;
                    Pair<Integer, Writer<U>> pair = objectVisitorInner(s, i, visitor.getObjectVisitor());
                    i = pair.getKey();
                    writer = pair.getValue();
                    break;
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    break;
                default:
                    throw new JerializerException("Expected object start: "+c);
            }
            i += 1;
        }
        if (i != z) {
            throw new JerializerException("Did not consume all input.");
        }
        if (writer == null) {
            throw new JerializerException("Did not read object start.");
        }
        return writer;
    }

    private static <U> Pair<Integer,Writer<U>> objectVisitorInner(String s, int i, JerialVisitor.ObjectVisitor objectVisitor) throws JerializerException {
        boolean inquote = false;
        final int z = s.length();
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        StringBuilder cur = key;

        boolean skipComma = false;
        while (i < z) {
            final char c = s.charAt(i);
            switch (c) {
                case '{':
                    i += 1;
                    assert key.length() > 0;
                    assert cur == value;
                    Pair<Integer, Writer<U>> pair = objectVisitorInner(s, i, objectVisitor.seeObjectFieldStart(key.toString()));
                    i = pair.getKey();
                    break;

                case '}':
                    if (key.length() > 0) {
                        assert cur == value;
                        assert value.length() > 0;
                        emit(key, value, objectVisitor);
                    }
                    return new Pair<Integer, Writer<U>>(i, objectVisitor);

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
                        emit(key, value, objectVisitor);
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
        throw new JerializerException("Did not read object end.");
    }

    private static void emit(StringBuilder key, StringBuilder value, JerialVisitor.ObjectVisitor objectVisitor) throws JerializerException {
        final String ks = key.toString();
        if (value.length() > 1 && value.charAt(0) == '"' && value.charAt(value.length()-1) == '"') {
            objectVisitor.seeStringField(ks, value.substring(1, value.length() - 1));
            return;
        }
        final String vs = value.toString();
        try {
            objectVisitor.seeLongField(ks, Long.parseLong(vs));
            return;
        } catch (NumberFormatException ignored) {}
        try {
            objectVisitor.seeDoubleField(ks, Double.parseDouble(vs));
            return;
        } catch (NumberFormatException ignored) {}
        if (vs.equals("true")) {
            objectVisitor.seeBooleanField(ks, true);
        } else if (vs.equals("false")) {
            objectVisitor.seeBooleanField(ks, false);
        } else {
            throw new JerializerException("Bad value in kv: "+ks+" => "+vs);
        }
    }
}
