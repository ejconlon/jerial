package net.exathunk.jereal.genschema.jsonref;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.jsonref.GeneratedJsonRef;
import net.exathunk.jereal.genschema.jsonref.GeneratedJsonRefContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedJsonRefContainerLike {

        boolean hasGeneratedJsonRef();
        GeneratedJsonRef getGeneratedJsonRef();
        void setGeneratedJsonRef(GeneratedJsonRef value);

}
