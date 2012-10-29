package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.functional.EitherRef;
import net.exathunk.jereal.base.visitors.ArrayVisitor;
import net.exathunk.jereal.base.visitors.ObjectVisitor;
import net.exathunk.jereal.base.visitors.VisitorFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * charolastra 10/29/12 4:16 PM
 */
public class OperatorVisitor<D, E> implements ObjectVisitor<EitherRef<D, E>> {

    private final VisitorFactory<EitherRef<D, E>> factory;
    private final OperatorMap<D, E> map;
    private final JThing thing;
    private final List<Suspension<D, E, ?>> suspensions;

    public OperatorVisitor(VisitorFactory<EitherRef<D, E>> factory, OperatorMap<D, E> map, JThing thing) {
        this.factory = factory;
        this.map = map;
        this.thing = thing;
        this.suspensions = new ArrayList<Suspension<D, E, ?>>();
    }

    @Override
    public ObjectVisitor<EitherRef<D, E>> seeObjectFieldStart(String key) {
        Operator<D, E, ?> op = map.get(key, SuperModel.OBJECT);
        return null;
    }

    @Override
    public ArrayVisitor<EitherRef<D, E>> seeArrayFieldStart(String key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void seeStringField(String key, String value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void seeBooleanField(String key, Boolean value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void seeLongField(String key, Long value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void seeDoubleField(String key, Double value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void runFunc(EitherRef<D, E> context) {
        final Iterator<Suspension<D, E, ?>> it = suspensions.iterator();
        while (context.hasLeft() && it.hasNext()) {
            final Suspension<D, E, ?> susp = it.next();
            susp.runFunc(context);
        }
    }
}
