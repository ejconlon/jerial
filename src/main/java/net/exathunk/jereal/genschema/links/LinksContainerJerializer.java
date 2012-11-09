package net.exathunk.jereal.genschema.links;

import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.*;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschema.*;
import net.exathunk.jereal.genschema.links.*;

public class LinksContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, LinksContainer> {

    @Override
    public LinksContainer prototype(Speclike spec) throws JerializerException {
        return new LinksContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, LinksContainer domain) throws JerializerException {
        return (new LinksJerializer()).jerialize(recurser, dsl, domain.getLinksRef().getRef());
    }

}
