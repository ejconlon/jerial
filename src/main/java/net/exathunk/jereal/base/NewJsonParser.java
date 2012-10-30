package net.exathunk.jereal.base;

import net.exathunk.jereal.base.core.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * charolastra 10/29/12 5:47 PM
 */
public class NewJsonParser {

    public JThing parse(String s) {
        return parse(new StringIterator(s));
    }

    public JThing parse(Iterator<Character> chit) {
        Iterator<Token<TokenType>> tokit = new Tokenizer(chit);
        Iterator<Token<StreamType>> streamit = new Streamer(tokit);
        return recurse(streamit, null, null);
    }

    private static class StringIterator implements Iterator<Character> {

        private final String s;
        private int index;

        public StringIterator(String s) {
            this.s = s;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return s != null && index < s.length();
        }

        @Override
        public Character next() {
            return s.charAt(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    private void fail(Token<StreamType> token, String message) {
        throw new IllegalArgumentException(message+": "+token);
    }

    private JThing recurse(Iterator<Token<StreamType>> streamit, JObject curObject, JArray curArray) {
        Token<StreamType> storedId = null;
        while (streamit.hasNext()) {
            Token<StreamType> token = streamit.next();
            Logger.log(Logger.Level.TRACE, "Considering: "+token);
            JThing thing = null;
            switch (token.type) {
                case OBJECTSTART:
                    thing = recurse(streamit, new JObject(), null);
                    break;
                case OBJECTEND:
                    assert curObject != null;
                    return JThing.make(curObject);
                case ARRAYSTART:
                    thing = recurse(streamit, null, new JArray());
                    break;
                case ARRAYEND:
                    assert curArray != null;
                    return JThing.make(curArray);
                case ID:
                    storedId = token;
                    break;
                case STRING:
                    thing = JThing.make(token.value);
                    break;
                case LONG:
                    thing = JThing.make(Long.parseLong(token.value));
                    break;
                case BOOLEAN:
                    thing = JThing.make(Boolean.parseBoolean(token.value));
                    break;
                case DOUBLE:
                    thing = JThing.make(Double.parseDouble(token.value));
                    break;
                case NULL:
                    // TODO NULL TYPE
                    thing = JThing.make((String)null);
                    break;
                default:
                    fail(token, "ERROR");
                    return null;
            }

            if (thing == null) {
                continue;
            } else if (curObject == null && curArray == null) {
                assert storedId == null;
                return thing;
            } else if (curObject != null) {
                assert storedId != null;
                curObject.set(storedId.value, thing);
                storedId = null;
            } else {
                assert storedId == null;
                curArray.set(null, thing);
            }
        }
        fail(null, "end of input");
        return null;
    }


    private static enum StreamType {
        OBJECTSTART, OBJECTEND, ARRAYSTART, ARRAYEND, ID, STRING, LONG, BOOLEAN, DOUBLE, NULL, ERROR
    }

    private static class Streamer implements Iterator<Token<StreamType>> {
        private final Iterator<Token<TokenType>> it;
        private final Deque<Token<StreamType>> nextStreams;
        private Token<TokenType> first;
        private Token<TokenType> second;
        boolean secondString = false;
        boolean error = false;

        private Streamer(Iterator<Token<TokenType>> it) {
            this.it = it;
            nextStreams = new ArrayDeque<Token<StreamType>>();
        }

        private Token<StreamType> fail(String message) {
            error = true;
            return new Token<StreamType>(StreamType.ERROR, message);
        }

        private Token<StreamType> makeScalar(String value) {
            if (secondString) {
                return new Token<StreamType>(StreamType.STRING, value);
            } else if ("null".equals(value)) {
                return new Token<StreamType>(StreamType.NULL, value);
            } else if ("true".equals(value)) {
                return new Token<StreamType>(StreamType.BOOLEAN, value);
            } else if ("false".equals(value)) {
                return new Token<StreamType>(StreamType.BOOLEAN, value);
            } else {
                try {
                    long l = Long.parseLong(value);
                    return new Token<StreamType>(StreamType.LONG, value);
                } catch (NumberFormatException nfe) {}
                try {
                    double d = Double.parseDouble(value);
                    return new Token<StreamType>(StreamType.DOUBLE, value);
                } catch (NumberFormatException nfe) {}
                return fail("cannot type: "+value);
            }
        }

        void emitPair(boolean force) {
            Logger.log(Logger.Level.TRACE, "emit pair?");
            if (force && first == null) {
                //emitOne(fail("no pair present"));
            } else if (force || first != null) {
                if (second != null) {
                    Logger.log(Logger.Level.TRACE, "emit pair");
                    emitOne(new Token<StreamType>(StreamType.ID, first.value));
                    emitOne(makeScalar(second.value));
                } else {
                    Logger.log(Logger.Level.TRACE, "emit item");
                    emitOne(makeScalar(first.value));
                }
            }

            first = null;
            second = null;
            secondString = false;
        }

        void emitId(boolean force) {
            Logger.log(Logger.Level.TRACE, "emit id?");
            if (force && first == null) {
                emitOne(fail("no id present"));
            } else if (force || first != null){
                Logger.log(Logger.Level.TRACE, "emitting id");
                emitOne(new Token<StreamType>(StreamType.ID, first.value));

            }
            first = null;
            second = null;
            secondString = false;
        }

        void emitOne(Token<StreamType> token) {
            nextStreams.addLast(token);
        }

        void advance() {
            boolean inQuote = false;
            while (!error && nextStreams.isEmpty() && it.hasNext()) {
                final Token<TokenType> token = it.next();
                switch (token.type) {
                    case OPENCURLY:
                        emitId(false);
                        emitOne(new Token<StreamType>(StreamType.OBJECTSTART));
                        break;
                    case CLOSECURLY:
                        emitPair(false);
                        emitOne(new Token<StreamType>(StreamType.OBJECTEND));
                        break;
                    case OPENSQUARE:
                        emitId(false);
                        emitOne(new Token<StreamType>(StreamType.ARRAYSTART));
                        break;
                    case CLOSESQUARE:
                        emitPair(false);
                        emitOne(new Token<StreamType>(StreamType.ARRAYEND));
                        break;
                    case COLON:
                        break;
                    case COMMA:
                        emitPair(true);
                        break;
                    case QUOTE:
                        if (inQuote && first != null) {
                            secondString = true;
                        }
                        inQuote = !inQuote;
                        break;
                    case OTHER:
                        if (first == null) {
                            first = token;
                        } else if (second == null) {
                            secondString = false;
                            second = token;
                        } else {
                            emitOne(fail("stack smash"));
                        }
                        break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            advance();
            return !nextStreams.isEmpty();
        }

        @Override
        public Token<StreamType> next() {
            advance();
            return nextStreams.removeFirst();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private static enum TokenType {
        OPENCURLY, CLOSECURLY, OPENSQUARE, CLOSESQUARE, COLON, COMMA, QUOTE, OTHER
    }

    private static class Token<Type> {
        public final Type type;
        public final String value;
        public Token(Type type) {
            this(type, null);
        }
        public Token(Type type, String value) {
            this.type = type;
            this.value = value;
            assert type != null;
        }
        @Override
        public String toString() {
            return "Token{" +
                    "type=" + type +
                    (value != null ? ", value='" + value + '\'' : "") +
                    '}';
        }
    }
    
    private static class Tokenizer implements Iterator<Token<TokenType>> {
        private final Iterator<Character> it;
        private final Deque<Token> nextTokens;
        private final StringBuilder currentToken;
        private boolean inQuote = false;  
        
        private Tokenizer(Iterator<Character> it) {
            this.it = it;
            nextTokens = new ArrayDeque<Token>();
            currentToken = new StringBuilder();
        }

        private void emit(Token token) {
            Logger.log(Logger.Level.TRACE, "TOKEN: "+token);
            nextTokens.addLast(token);
        }
        
        private void emitCurrent(boolean force) {
            if (force || currentToken.length() > 0) {
                emit(new Token(TokenType.OTHER, currentToken.toString()));
            }
            currentToken.setLength(0);
        }
        
        private void addAndEmit(Token token, boolean force) {
            emitCurrent(force);
            emit(token);
        }
        
        private void advance() {
            while (nextTokens.isEmpty() && it.hasNext()) {
                final char c = it.next();
                if (inQuote) {
                    switch (c) {
                        case '"':
                            addAndEmit(new Token(TokenType.QUOTE), true);
                            inQuote = false;
                            break;
                        default:
                            currentToken.append(c);
                    }
                } else {
                    switch (c) {
                        case '"':
                            addAndEmit(new Token(TokenType.QUOTE), false);
                            inQuote = true;
                            break;
                        case '{':
                            addAndEmit(new Token(TokenType.OPENCURLY), false);
                            break;
                        case '}':
                            addAndEmit(new Token(TokenType.CLOSECURLY), false);
                            break;
                        case '[':
                            addAndEmit(new Token(TokenType.OPENSQUARE), false);
                            break;
                        case ']':
                            addAndEmit(new Token(TokenType.CLOSESQUARE), false);
                            break;
                        case ',':
                            addAndEmit(new Token(TokenType.COMMA), false);
                            break;
                        case ':':
                            addAndEmit(new Token(TokenType.COLON), false);
                            break;
                        case ' ':
                        case '\t':
                        case '\r':
                        case '\n':
                            break;
                        default:
                            currentToken.append(c);
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            advance();
            return !nextTokens.isEmpty();
        }

        @Override
        public Token next() {
            advance();
            return nextTokens.removeFirst();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
}
