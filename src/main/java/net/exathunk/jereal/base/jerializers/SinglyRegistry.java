package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Questionable;

/**
 * charolastra 10/31/12 2:08 AM
 */
public class SinglyRegistry<T extends PushableContext<T, U>, U extends Questionable, V> implements JerializerRegistry<T, U> {

    private final Class<V> klass;
    private final Jerializer<T, U, V> jerializer;
    private final JerializerRegistry<T, U> next;

    public SinglyRegistry(Class<V> klass, Jerializer<T, U, V> jerializer) {
        this(klass, jerializer, null);
    }

    public SinglyRegistry(Class<V> klass, Jerializer<T, U, V> jerializer, JerializerRegistry<T, U> next) {
        this.klass = klass;
        this.jerializer = jerializer;
        this.next = next;
    }

    @Override
    public <X> boolean hasJerializer(Class<X> key) {
        if (klass.equals(key)) {
            return true;
        } else if (next != null) {
            return next.hasJerializer(key);
        } else {
            return false;
        }
    }

    @Override
    public <X> Jerializer<T, U, X> getJerializer(Class<X> key) throws JerializerException {
        if (klass.equals(key)) {
            return (Jerializer<T, U, X>)jerializer;
        } else if (next != null) {
            return next.getJerializer(key);
        } else {
            throw new JerializerException("Could not find "+key+" (only "+klass+")");
        }
    }
}
