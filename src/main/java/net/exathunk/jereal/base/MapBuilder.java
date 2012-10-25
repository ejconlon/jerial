package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.*;

public class MapBuilder implements JerialBuilder {

    private final Map<PathPart, Jitem> pairs;

    public MapBuilder() {
        this.pairs = new TreeMap<PathPart, Jitem>();
    }

    @Override
    public void addJitem(Jitem jitem) {
        pairs.put(jitem.part, jitem);
    }

    @Override
    public Jerial buildJerial() {
        return new Jerial() {
            @Override
            public Iterator<Jitem> iterator() {
                return new Iterator<Jitem>() {
                    private final Iterator<Map.Entry<PathPart, Jitem>> it = pairs.entrySet().iterator();

                    @Override
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override
                    public Jitem next() {
                        return it.next().getValue();
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
