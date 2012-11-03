package net.exathunk.jereal.schema.jerializers;

import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.jerializers.Jerializer;
import net.exathunk.jereal.base.jerializers.JerializerException;
import net.exathunk.jereal.base.jerializers.Recurser;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;

/**
 * charolastra 10/31/12 3:20 AM
 */
public class SchemaRefJerializer<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, SchemaRef> {
    @Override
    public SchemaRef prototype(Speclike spec) throws JerializerException {
        if (Model.OBJECT.equals(spec.getModel())) return SchemaRef.makeSchema(new Schema());
        else if (Model.STRING.equals(spec.getModel())) return SchemaRef.makeRef("#");
        else throw new JerializerException("Unexpected model: "+spec.getModel());
    }

    @Override
    public Pipeable<U> jerialize(final Recurser<T, U> recurser, final DSL<T, U> dsl, final SchemaRef schemaRef) throws JerializerException {
        return new Pipeable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                final Pipeable<U> pipe;
                boolean isLeft = schemaRef.hasLeft();
                if (!isLeft && !ref.isEmptyRef()) {
                    final Speclike spec = ref.getRef().makeSpec();
                    isLeft = Model.OBJECT.equals(spec.getModel());
                }
                if (isLeft) {
                    if (!schemaRef.hasLeft()) schemaRef.setLeft(new RefImpl<Schema>(new Schema()));
                    pipe = (new SchemaJerializer<T, U>()).jerialize(recurser, dsl, schemaRef.getLeft().getRef());
                } else {
                    if (!schemaRef.hasRight()) schemaRef.setRight(new RefImpl("#"));
                    pipe = dsl.seeString(schemaRef.getRight());
                }
                pipe.pipe(ref);
            }
        };
    }
}
