package net.exathunk.jereal.base;

import net.exathunk.jereal.base.functional.Func1;
import net.exathunk.jereal.base.visitors.VisitorFactory;

public interface JerialVisitorAdapter<T, U> {
    Func1<U> runJerialVisitor(T object, VisitorFactory<U> visitorFactory) throws JerializerException;
}
