package net.exathunk.jereal.genschema.links;

import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.hyperschema.*;

public interface LinksRefable {

        Ref<String> getEnctypeRef();

        Ref<String> getHrefRef();

        Ref<String> getMethodRef();

        Ref<Map<String,Ref<HyperSchemaContainer>>> getPropertiesRef();

        Ref<String> getRelRef();

        Ref<HyperSchemaContainer> getTargetSchemaRef();

}
