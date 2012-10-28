package net.exathunk.jereal.base.visitors;

import java.util.Iterator;

/**
 * charolastra 10/27/12 4:20 PM
 */
public class JerialUtils {
    public static Jerial singleton(final Jitem item) {
        return new Jerial() {
            @Override
            public Iterator<Jitem> iterator() {
                return new Iterator<Jitem>() {
                    private boolean called = false;

                    @Override
                    public boolean hasNext() {
                        return !called;
                    }

                    @Override
                    public Jitem next() {
                        if (!called) {
                            called = true;
                            return item;
                        }
                        throw new RuntimeException("Called next on empty iterator");
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
