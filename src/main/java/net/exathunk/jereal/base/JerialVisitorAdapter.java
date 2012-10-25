package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.VisitorFactory;
import net.exathunk.jereal.base.visitors.Writer;

public interface JerialVisitorAdapter<T, U> {
    Writer<U> runJerialVisitor(T object, VisitorFactory<U> visitorFactory) throws JerializerException;
}
