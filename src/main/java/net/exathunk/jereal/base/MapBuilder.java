package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.Jerial;
import net.exathunk.jereal.base.visitors.Jitem;

import java.util.*;

public class MapBuilder implements JerialBuilder {

    private final Map<String, Jitem> objectPairs;
    private final List<Jitem> arrayItems;

    public MapBuilder() {
        this.objectPairs = new HashMap<String, Jitem>();
        this.arrayItems = new ArrayList<Jitem>();
    }

    @Override
    public void addJitem(Jitem jitem) {
        if (jitem.key != null) {
            objectPairs.put(jitem.key, jitem);
        } else {
            arrayItems.add(jitem);
        }
    }

    @Override
    public Jerial buildJerial() {
        return new Jerial() {
            @Override
            public Iterator<Jitem> iterator() {
                return new Iterator<Jitem>() {
                    private final Iterator<Map.Entry<String, Jitem>> objit = objectPairs.entrySet().iterator();
                    private final Iterator<Jitem> arrit = arrayItems.iterator();

                    @Override
                    public boolean hasNext() {
                        return objit.hasNext() || arrit.hasNext();
                    }

                    @Override
                    public Jitem next() {
                        if (objit.hasNext()) return objit.next().getValue();
                        else return arrit.next();
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
