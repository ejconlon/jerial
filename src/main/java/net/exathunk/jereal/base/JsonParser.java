package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.ArrayVisitor;
import net.exathunk.jereal.base.visitors.JerialVisitor;
import net.exathunk.jereal.base.visitors.ObjectVisitor;
import net.exathunk.jereal.base.visitors.Writer;

public class JsonParser<U> implements JerialVisitorAdapter<String, U> {
    public Writer<U> runJerialVisitor(String s, JerialVisitor<U> visitor) throws JerializerException {
        int i = 0;
        final int z = s.length();
        Pair<Integer, Writer<U>> pair = null;
        while (i < z) {
            final char c = s.charAt(i);
            switch (c) {
                case '{':
                    if (pair != null) {
                        throw new JerializerException("Already read object start.");
                    }
                    i += 1;
                    pair = objectVisitorInner(s, i, visitor.makeObjectVisitor());
                    i = pair.getKey();
                    break;
                case '[':
                    if (pair != null) {
                        throw new JerializerException("Already read array start");
                    }
                    i += 1;
                    pair = arrayVisitorInner(s, i, visitor.makeArrayVisitor());
                    i = pair.getKey();
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    break;
                default:
                    throw new JerializerException("Expected object/array start: "+c);
            }
            i += 1;
        }
        if (i != z) {
            throw new JerializerException("Did not consume all input.");
        }
        if (pair == null) {
            throw new JerializerException("Did not read object/array start.");
        }
        return pair.getValue();
    }

    private static <U> Pair<Integer,Writer<U>> objectVisitorInner(String s, int i, ObjectVisitor<U> objectVisitor) throws JerializerException {
        boolean inquote = false;
        final int z = s.length();
        Pair<Integer, Writer<U>> pair;
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        StringBuilder cur = key;

        boolean skipComma = false;
        while (i < z) {
            final char c = s.charAt(i);
            if (inquote || c == '"') {
                cur.append(c);
                i += 1;
                if (c == '"') inquote = !inquote;
                continue;
            }
            switch (c) {
                case '{':
                    i += 1;
                    assert key.length() > 0;
                    assert value.length() == 0;
                    assert cur == value;
                    pair = objectVisitorInner(s, i, objectVisitor.seeObjectFieldStart(key.substring(1, key.length()-1)));
                    i = pair.getKey();
                    key.setLength(0);
                    cur = key;
                    break;

                case '[':
                    i += 1;
                    assert key.length() > 0;
                    assert value.length() == 0;
                    assert cur == value;
                    pair = arrayVisitorInner(s, i, objectVisitor.seeArrayFieldStart(key.substring(1, key.length()-1)));
                    i = pair.getKey();
                    key.setLength(0);
                    cur = key;
                    break;

                case '}':
                    if (value.length() > 0) {
                        assert cur == value;
                        assert key.length() > 0;
                        emit(key, value, objectVisitor);
                        key.setLength(0);
                        value.setLength(0);
                        cur = key;
                    }
                    return new Pair<Integer, Writer<U>>(i, objectVisitor);

                case ':':
                    assert key.length() > 0;
                    assert cur == key;
                    assert value.length() == 0;
                    cur = value;
                    break;

                case ',':
                    if (!skipComma) {
                        if (value.length() > 0) {
                            assert key.length() > 0;
                            emit(key, value, objectVisitor);
                            key.setLength(0);
                            value.setLength(0);
                            cur = key;
                        }
                    } else {
                        skipComma = false;
                    }
                    break;

                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    break;

                default:
                    cur.append(c);
                    break;
            }
            i += 1;
        }
        throw new JerializerException("Did not read object end.");
    }

    private static <U> Pair<Integer,Writer<U>> arrayVisitorInner(String s, int i, ArrayVisitor<U> arrayVisitor) throws JerializerException {
        boolean inquote = false;
        final int z = s.length();
        Pair<Integer, Writer<U>> pair;
        StringBuilder value = new StringBuilder();

        boolean skipComma = false;
        while (i < z) {
            final char c = s.charAt(i);
            if (inquote || c == '"') {
                value.append(c);
                i += 1;
                if (c == '"') inquote = !inquote;
                continue;
            }
            switch (c) {
                case '{':
                    i += 1;
                    assert value.length() == 0;
                    pair = objectVisitorInner(s, i, arrayVisitor.seeObjectItemStart());
                    i = pair.getKey();
                    break;

                case '[':
                    i += 1;
                    assert value.length() == 0;
                    pair = arrayVisitorInner(s, i, arrayVisitor.seeArrayItemStart());
                    i = pair.getKey();
                    break;

                case ']':
                    if (value.length() > 0) {
                        emit(value, arrayVisitor);
                        value.setLength(0);
                    }
                    return new Pair<Integer, Writer<U>>(i, arrayVisitor);

                case ',':
                    if (!skipComma) {
                        if (value.length() > 0) {
                            emit(value, arrayVisitor);
                            value.setLength(0);
                        }
                    } else {
                        skipComma = false;
                    }
                    break;

                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    break;

                default:
                    value.append(c);
                    break;
            }
            i += 1;
        }
        throw new JerializerException("Did not read object end.");
    }

    private static <U> void emit(StringBuilder key, StringBuilder value, ObjectVisitor<U> objectVisitor) throws JerializerException {
        final String ks = key.substring(1, key.length()-1);
        if (value.length() > 1 && value.charAt(0) == '"' && value.charAt(value.length()-1) == '"') {
            objectVisitor.seeStringField(ks, value.substring(1, value.length() - 1));
            return;
        } else if (value.equals("null")) {
            // NOTE nulls are strings by default
            objectVisitor.seeStringField(ks, value.toString());
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

    private static <U> void emit(StringBuilder value, ArrayVisitor<U> arrayVisitor) throws JerializerException {
        if (value.length() > 1 && value.charAt(0) == '"' && value.charAt(value.length()-1) == '"') {
            arrayVisitor.seeStringItem(value.substring(1, value.length() - 1));
            return;
        } else if (value.equals("null")) {
            // NOTE nulls are strings by default
            arrayVisitor.seeStringItem(value.toString());
            return;
        }
        final String vs = value.toString();
        try {
            arrayVisitor.seeLongItem(Long.parseLong(vs));
            return;
        } catch (NumberFormatException ignored) {}
        try {
            arrayVisitor.seeDoubleItem(Double.parseDouble(vs));
            return;
        } catch (NumberFormatException ignored) {}
        if (vs.equals("true")) {
            arrayVisitor.seeBooleanItem(true);
        } else if (vs.equals("false")) {
            arrayVisitor.seeBooleanItem(false);
        } else {
            throw new JerializerException("Bad value in v: "+vs);
        }
    }
}
