package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Look away!  I don't want to touch this any more than I have to...
 *
 * charolastra 11/6/12 2:09 AM
 */
public class TypeOracleImpl implements TypeOracle {

    private final KlassContext klassContext;

    public TypeOracleImpl(KlassContext klassContext) {
        this.klassContext = klassContext;
    }

    @Override
    public KlassTree makeType(SchemaRef schemaRef) {
        return makeTypeInner(schemaRef, null, null);
    }

    private KlassTree makeTypeInner(SchemaRef schemaRef, SchemaRef itemType, SchemaRef addlPropType) {
        if (schemaRef.hasRight()) {
            final String ts = schemaRef.getRight().getRef();
            if (ts.equals("array")) {
                if (itemType == null) {
                    return new KlassTree(new Klass(Ref.class), new KlassTree(new Klass(List.class), new KlassTree(new Klass(Ref.class), new Klass(JThing.class))));
                } else {
                    return new KlassTree(new Klass(Ref.class), new KlassTree(new Klass(List.class), makeType(itemType)));
                }
            } else if (ts.equals("object")) {
                //if (addlPropType == null) {
                    return new KlassTree(new Klass(Ref.class), new KlassTree(new Klass(Map.class), new KlassTree(new Klass(String.class)), new KlassTree(new Klass(Ref.class), new Klass(JThing.class))));
                //} else {
                //    return new KlassTree(new Klass(Ref.class), new KlassTree(new Klass(Map.class), new KlassTree(new Klass(String.class)), makeType(addlPropType)));
                //}
            } else {
                return klassContext.resolve(ts);
            }
        } else {
            final Schema s = schemaRef.getLeft().getRef();
            if (!s.type_String.isEmptyRef()) {
                final String ts = s.type_String.getRef();
                if (ts.equals("array")) {
                    if (s.items.isEmptyRef()) {
                        return new KlassTree(new Klass(Ref.class), new KlassTree(new Klass(List.class), new KlassTree(new Klass(Ref.class), new Klass(JThing.class))));
                    } else {
                        return new KlassTree(new Klass(Ref.class), new KlassTree(new Klass(List.class), makeType(s.items.getRef())));
                    }
                } else if (ts.equals("object")) {
                    if (s.additionalProperties_SchemaRef.isEmptyRef()) {
                        return new KlassTree(new Klass(Ref.class), new KlassTree(new Klass(Map.class), new KlassTree(new Klass(String.class)), new KlassTree(new Klass(Ref.class), new Klass(JThing.class))));
                    } else {
                        return new KlassTree(new Klass(Ref.class), new KlassTree(new Klass(Map.class), new KlassTree(new Klass(String.class)), makeType(s.additionalProperties_SchemaRef.getRef())));
                    }
                } else {
                    return klassContext.resolve(ts);
                }
            } else if (!s.dollar_ref.isEmptyRef()) {
                final String dr = s.dollar_ref.getRef();
                return klassContext.resolve(dr);
            } else if (!s.type_SchemaRef.isEmptyRef()) {
                final List<SchemaRef> r = s.type_SchemaRef.getRef();
                assert r.size() > 0;
                List<KlassTree> args = new ArrayList<KlassTree>(r.size());
                SchemaRef itref = null;
                if (!s.items.isEmptyRef()) { itref = s.items.getRef(); }
                SchemaRef addlref = null;
                if (!s.additionalProperties_SchemaRef.isEmptyRef()) { addlref = s.additionalProperties_SchemaRef.getRef(); }
                for (SchemaRef r2 : r) {
                    KlassTree child = makeTypeInner(r2, itref, addlref);
                    for (KlassTree grandchild : child.getTemplateArgs()) {
                        args.add(grandchild);
                    }
                }
                return new KlassTree(new Klass("Ref"+r.size(), "net.exathunk.jereal.base.gen"), args);
            } else {
                // empty schema
                return new KlassTree(new Klass(Ref.class), new Klass(JThing.class));
            }
        }
    }
}
