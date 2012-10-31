package net.exathunk.jereal.base.jerializers;

/**
 * charolastra 10/31/12 2:08 AM
 */
public class SinglyRegistry<X, C> implements JerializerRegistry<C> {

    private final Class<X> klass;
    private final Jerializer<X, C> jerializer;
    private final JerializerRegistry<C> next;

    public SinglyRegistry(Class<X> klass, Jerializer<X, C> jerializer) {
        this(klass, jerializer, null);
    }

    public SinglyRegistry(Class<X> klass, Jerializer<X, C> jerializer, JerializerRegistry<C> next) {
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
    public <T> Jerializer<T, C> getJerializer(Class<T> key) throws JerializerException {
        if (klass.equals(key)) {
            return (Jerializer<T, C>)jerializer;
        } else if (next != null) {
            return next.getJerializer(key);
        } else {
            throw new JerializerException("Could not find "+key+" (only "+klass+")");
        }
    }
}
