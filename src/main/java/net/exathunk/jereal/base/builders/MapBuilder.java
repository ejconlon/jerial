package net.exathunk.jereal.base.builders;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.core.PathPart;

class MapBuilder implements JerialBuilder {

    private final JObject object;
    private final JArray array;
    private boolean isObject = false;
    private boolean isArray = false;

    public MapBuilder() {
        this.object = new JObject();
        this.array = new JArray();
    }

    @Override
    public void addThing(PathPart part, JThing thing) {
        //Logger.getLogger(getClass()).critical("addThing: "+part+" "+thing);
        if (part.hasLeft()) {
            assert !isArray;
            isObject = true;
            object.set(part.getLeft(), thing);
        } else {
            assert !isObject;
            isArray = true;
            array.set(part.getRight(), thing);
        }
    }

    @Override
    public JObject buildObject() {
        assert !isArray;
        return object;
    }

    @Override
    public JArray buildArray() {
        assert !isObject;
        return array;
    }
}
