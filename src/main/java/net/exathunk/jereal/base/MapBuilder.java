package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapBuilder implements JerialBuilder {

    private final Map<String, Jitem> pairs;

    public MapBuilder() {
        this.pairs = new HashMap<String, Jitem>();
    }

    @Override
    public void addJitem(Jitem jitem) {
        pairs.put(jitem.key, jitem);
    }

    @Override
    public Jerial buildJerial() {
        return new Jerial() {
            @Override
            public Iterator<Jitem> iterator() {
                return new Iterator<Jitem>() {
                    private final Iterator<Map.Entry<String, Jitem>> underit = pairs.entrySet().iterator();

                    @Override
                    public boolean hasNext() {
                        return underit.hasNext();
                    }

                    @Override
                    public Jitem next() {
                        return underit.next().getValue();
                    }

                    @Override
                    public void remove() {
                        underit.remove();
                    }
                };
            }
        };
    }
}
