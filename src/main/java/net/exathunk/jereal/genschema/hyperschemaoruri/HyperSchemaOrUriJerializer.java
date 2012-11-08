package net.exathunk.jereal.genschema.hyperschemaoruri;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;

public class HyperSchemaOrUriJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, HyperSchemaOrUri> {

    @Override
    public HyperSchemaOrUri prototype(Speclike spec) {
        return new HyperSchemaOrUri();
    }

    @Override
    public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, HyperSchemaOrUri domain) throws JerializerException {
        return null;
    }

}
