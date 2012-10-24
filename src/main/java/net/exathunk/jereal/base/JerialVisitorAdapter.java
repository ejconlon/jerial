package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.JerialVisitor;
import net.exathunk.jereal.base.visitors.Writer;

public interface JerialVisitorAdapter<T, U> {
    Writer<U> runJerialVisitor(T object, JerialVisitor<U> visitor) throws JerializerException;
}
