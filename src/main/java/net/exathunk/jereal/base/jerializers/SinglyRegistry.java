package net.exathunk.jereal.base.jerializers;

/**
 * charolastra 10/31/12 2:08 AM
 */
public class SinglyRegistry<X> implements JerializerRegistry {

    private final Class<X> klass;
    private final Jerializer<X> jerializer;
    private final JerializerRegistry next;

    public SinglyRegistry(Class<X> klass, Jerializer<X> jerializer) {
        this(klass, jerializer, null);
    }

    public SinglyRegistry(Class<X> klass, Jerializer<X> jerializer, JerializerRegistry next) {
        this.klass = klass;
        this.jerializer = jerializer;
        this.next = next;
    }

    @Override
    public <T> boolean hasJerializer(Class<T> key) {
        if (klass.equals(key)) {
            return true;
        } else if (next != null) {
            return next.hasJerializer(key);
        } else {
            return false;
        }
    }

    @Override
    public <T> Jerializer<T> getJerializer(Class<T> key) throws JerializerException {
        if (klass.equals(key)) {
            return (Jerializer<T>)jerializer;
        } else if (next != null) {
            return next.getJerializer(key);
        } else {
            throw new JerializerException("Could not find "+key+" (only "+klass+")");
        }
    }
}
