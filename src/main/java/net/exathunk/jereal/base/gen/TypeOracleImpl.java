package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;
import java.util.List;

/**
 * Look away!  I don't want to touch this any more than I have to...
 *
 * charolastra 11/6/12 2:09 AM
 */
public class TypeOracleImpl implements TypeOracle {

    @Override
    public String makeType(String selfType, SchemaRef schemaRef, SchemaRef itemType, SchemaRef addlPropType) {
        if (schemaRef.hasRight()) {
            final String ts = schemaRef.getRight().getRef();
            String ret = ts.equals("#") ? selfType : Util.xform(ts);
            if (ret.equals("Array")) {
                if (itemType == null) {
                    return "List<JThing>";
                } else {
                    return "List<"+makeType(selfType, itemType, null, null)+">";
                }
            } else if (ret.equals("Object")) {
                if (addlPropType == null) {
                    return "JThing";
                } else {
                    return makeType(selfType, addlPropType, null, null);
                }
            } else {
                return ret;
            }
        } else {
            final Schema s = schemaRef.getLeft().getRef();
            if (!s.type_String.isEmptyRef()) {
                final String ts = s.type_String.getRef();
                String ret = ts.equals("#") ? selfType : Util.xform(ts);
                if (ret.equals("Array")) {
                    if (!s.items.isEmptyRef())
                        return "List<"+makeType(selfType, s.items.getRef(), null, null)+">";
                    else
                        return "List<JThing>";
                } else if (ret.equals("Object")) {
                    if (!s.additionalProperties_SchemaRef.isEmptyRef()) {
                        return makeType(selfType, s.additionalProperties_SchemaRef.getRef(), null, null);
                    } else {
                        return "JThing";
                    }
                } else {
                    return ret;
                }
            } else if (!s.dollar_ref.isEmptyRef()) {
                final String dr = s.dollar_ref.getRef();
                return Util.xform(dr);
            } else if (!s.type_SchemaRef.isEmptyRef()) {
                final List<SchemaRef> r = s.type_SchemaRef.getRef();
                assert r.size() > 0;
                StringBuilder sb = new StringBuilder("Any"+r.size()+"<");
                SchemaRef itref = null;
                if (!s.items.isEmptyRef()) { itref = s.items.getRef(); }
                SchemaRef addlref = null;
                if (!s.additionalProperties_SchemaRef.isEmptyRef()) { addlref = s.additionalProperties_SchemaRef.getRef(); }
                for (SchemaRef r2 : r) {
                    sb.append(makeType(selfType, r2, itref, addlref)).append(',');
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append(">");
                return sb.toString();
            } else {
                // empty schema
                return "JThing";
            }
        }
    }
}
