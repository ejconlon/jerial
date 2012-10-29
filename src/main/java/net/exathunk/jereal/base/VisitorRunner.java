package net.exathunk.jereal.base;

import net.exathunk.jereal.base.functional.Func1;
import net.exathunk.jereal.base.visitors.VisitorFactory;

public interface VisitorRunner<T, U> {
    Func1<U> runVisitor(T object, VisitorFactory<U> factory) throws JerializerException;
}
