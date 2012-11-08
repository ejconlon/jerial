package net.exathunk.jereal.genschema.links;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaContainer;
import net.exathunk.jereal.genschema.links.Links;

public class LinksContainerJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, LinksContainer> {

    @Override
    public LinksContainer prototype(Speclike spec) {
        return new LinksContainer();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, LinksContainer domain) throws JerializerException {
        recurser.seeCustom(dsl, domain.getLinksRef(), Links.class);
        return null;
    }

}
