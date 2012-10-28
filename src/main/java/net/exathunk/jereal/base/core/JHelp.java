package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.Func0;
import net.exathunk.jereal.base.functional.Func1;
import net.exathunk.jereal.base.functional.ResFunc0;

/**
 * charolastra 10/28/12 1:29 AM
 */
public class JHelp {
    public static <A> A getValue(ResFunc0<A> f) {
        return f.runResFunc();
    }

    public static <A> void setValue(Func1<A> f, A newValue) {
        f.runFunc(newValue);
    }
}
