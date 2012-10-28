package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.Jerial;
import net.exathunk.jereal.base.core.Jitem;
import net.exathunk.jereal.base.visitors.PathPart;

import java.util.*;

public class MapBuilder implements JerialBuilder {

    private final Map<PathPart, Jitem> pairs;

    public MapBuilder() {
        this.pairs = new TreeMap<PathPart, Jitem>();
    }

    @Override
    public void addJitem(Jitem jitem) {
        pairs.put(jitem.getPart(), jitem);
    }

    @Override
    public Jerial buildObject() {
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

    @Override
    public List<Jitem> buildArray() {
        return new ArrayList<Jitem>(pairs.values());
    }
}
