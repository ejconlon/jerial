package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.Schema;
import net.exathunk.jereal.schema.domain.SchemaRef;
import java.util.List;

/**
 * charolastra 11/6/12 2:09 AM
 */
public class TypeOracleImpl implements TypeOracle {

    @Override
    public String makeType(String selfType, SchemaRef schemaRef, SchemaRef itemType) {
        if (schemaRef.hasRight()) {
            final String ts = schemaRef.getRight().getRef();
            String ret = ts.equals("#") ? selfType : Util.xform(ts);
            if (ret.equals("Array")) {
                if (itemType == null) {
                    return "List<JThing>";
                } else {
                    return "List<"+makeType(selfType, itemType, null)+">";
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
                        return "List<"+makeType(selfType, s.items.getRef(), null)+">";
                    else
                        return "List<JThing>";
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
                for (SchemaRef r2 : r) {
                    sb.append(makeType(selfType, r2, itref)).append(',');
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
