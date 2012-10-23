package net.exathunk.jereal.base;

public class JsonObjectReader implements JerialReader {

    private final JerialBuilderFactory jerialBuilderFactory;
    private int numOpen = 0;
    private boolean opened = false;
    private boolean closed = false;
    private Stack<JerialBuilder> builders = new Stack<JerialBuilder>();
    private Stack<String> keys = new Stack<String>();

    public JsonObjectReader(JerialBuilderFactory jerialBuilderFactory) {
        this.jerialBuilderFactory = jerialBuilderFactory;
    }

    @Override
    public void seeStartObject() {
        if (opened) assert numOpen > 0;
        assert !closed;
        opened = true;
        numOpen += 1;
        builders.push(jerialBuilderFactory.createJerialBuilder(keys.asList()));
    }

    @Override
    public void seeEndObject() {
        assert opened && !closed;
        numOpen -= 1;
        if (numOpen == 0) {
            closed = true;
        }
        if (!keys.isEmpty()) {
            int s = builders.size();
            int t = keys.size();
            assert s > 1 && s == t + 1;
            Jerial ended = builders.pop().buildJerial();
            builders.peek().addJitem(Jitem.makeObject(keys.pop(), ended));
        }
    }

    @Override
    public void seeObjectFieldStart(String key) {
        assert opened && !closed;
        numOpen += 1;
        keys.push(key);
        builders.push(jerialBuilderFactory.createJerialBuilder(keys.asList()));
    }

    @Override
    public void seeStringField(String key, String value) {
        assert opened && !closed;
        builders.peek().addJitem(Jitem.makeString(key, value));
    }

    @Override
    public void seeBooleanField(String key, Boolean value) {
        assert opened && !closed;
        builders.peek().addJitem(Jitem.makeBoolean(key, value));
    }

    @Override
    public void seeLongField(String key, Long value) {
        assert opened && !closed;
        builders.peek().addJitem(Jitem.makeLong(key, value));
    }

    @Override
    public void seeDoubleField(String key, Double value) {
        assert opened && !closed;
        builders.peek().addJitem(Jitem.makeDouble(key, value));
    }

    @Override
    public Jerial readJerial() {
        assert opened && closed;
        assert numOpen == 0;
        assert builders.size() == 1;
        assert keys.size() == 0;
        return builders.peek().buildJerial();
    }
}
