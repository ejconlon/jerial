package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;

/**
 * charolastra 11/7/12 5:27 PM
 */
public class JerializerGen extends Gen {
    public JerializerGen(Genable genable) {
        super(genable);
    }

    @Override
    public String effectiveClassName() {
        return genable.getKlass().getKlassName()+"Jerializer";
    }

    @Override
    public void writeOpenClass(Stringer sb) {
        sb.append("public class ").append(effectiveClassName()).append("<T extends PushableContext<T, U>, U extends Questionable> implements Jerializer<T, U, ").append(genable.getKlass().getKlassName()).append("> {\n\n");
    }

    @Override
    public void writeDeclarations(Stringer sb) {
    }

    @Override
    public void writeConstructor(Stringer sb) {
    }

    @Override
    public void writeToString(Stringer sb) {
    }

    @Override
    public void writeEquals(Stringer sb) {
    }

    @Override
    public void writeHashCode(Stringer sb) {
    }

    @Override
    public void writeMethods(Stringer sb) {
        sb.append("@Override\n");
        sb.append("public ").append(genable.getKlass().getKlassName()).append(" prototype(Speclike spec) {\n");
        sb.indent().append("return new ").append(genable.getKlass().getKlassName()).append("();\n");
        sb.append("}\n\n");


        sb.append("@Override\n");
        sb.append("public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, ").append(genable.getKlass().getKlassName()).append(" domain) throws JerializerException {\n");
        Stringer sb2 = sb.indent();
        sb2.append("ObjectDSL<T, U> objectDSL = dsl.seeObject();\n");
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            writeDslCommand(sb2, entry.getKey(), entry.getValue());
        }
        sb2.append("return objectDSL;\n");
        sb.append("}\n\n");
    }

    protected void writeDslCommand(Stringer sb, String key, KlassTree value) {
        writeDslCommand(sb, key, value, "domain");
    }

    protected void writeDslCommand(Stringer sb, String key, KlassTree value, String domainDotGetRefCall) {
        domainDotGetRefCall += ".get"+KlassContext.capitalize(key)+"Ref()";
        if (value.getTemplateArgs().isEmpty()) {
            throw new IllegalArgumentException("Unhandled klass (0): "+value);
        } else if (value.getTemplateArgs().size() == 1) {
            if (value.getKlass().equals(new Klass(Ref.class))) {
                KlassTree inner = value.getTemplateArgs().get(0);
                writeDslCommandUncontained(sb, key, inner, domainDotGetRefCall);
            } else {
                throw new IllegalArgumentException("Unhandled klass (1): "+value);
            }
        } else if (value.getTemplateArgs().size() == 2) {
            if (value.getKlass().equals(new Klass(Ref2.class))) {
                KlassTree first = value.getTemplateArgs().get(0);
                KlassTree second = value.getTemplateArgs().get(1);
                writeDslCommandUncontained(sb, key, first, domainDotGetRefCall + ".getFirstRef()");
                writeDslCommandUncontained(sb, key, second, domainDotGetRefCall + ".getSecondRef()");
            } else {
                throw new IllegalArgumentException("Unhandled klass (2): "+value);
            }
        } else if (value.getTemplateArgs().size() == 3) {
            if (value.getKlass().equals(new Klass(Ref3.class))) {
                KlassTree first = value.getTemplateArgs().get(0);
                KlassTree second = value.getTemplateArgs().get(1);
                KlassTree third = value.getTemplateArgs().get(2);
                writeDslCommandUncontained(sb, key, first, domainDotGetRefCall + ".getFirstRef()");
                writeDslCommandUncontained(sb, key, second, domainDotGetRefCall + ".getSecondRef()");
                writeDslCommandUncontained(sb, key, third, domainDotGetRefCall + ".getThirdRef()");
            } else {
                throw new IllegalArgumentException("Unhandled klass (3): "+value);
            }
        } else {
            throw new IllegalArgumentException("Unhandled klass (?): "+value);
        }
    }

    protected void writeDslCommandUncontained(Stringer sb, String key, KlassTree value, String domainDotGetRefCall) {
        if (value.getTemplateArgs().isEmpty()) {
            // Non-templated class: simple
            if (value.getKlass().equals(new Klass("String", "java.lang"))) {
                sb.append("objectDSL.seeString(\"").append(key).append("\", ").append(domainDotGetRefCall).append(");\n");
            } else if (value.getKlass().equals(new Klass("Double", "java.lang"))) {
                sb.append("objectDSL.seeDouble(\"").append(key).append("\", ").append(domainDotGetRefCall).append(");\n");
            } else if (value.getKlass().equals(new Klass("Long", "java.lang"))) {
                sb.append("objectDSL.seeLong(\"").append(key).append("\", ").append(domainDotGetRefCall).append(");\n");
            } else if (value.getKlass().equals(new Klass("Boolean", "java.lang"))) {
                sb.append("objectDSL.seeBoolean(\"").append(key).append("\", ").append(domainDotGetRefCall).append(");\n");
            } else if (value.getKlass().equals(new Klass(JThing.class))) {
                sb.append("objectDSL.seeCustom(\"").append(key).append("\", new RefImpl(recurser.seeThing(dsl, ").append(domainDotGetRefCall).append(")));\n");
            } else {
                sb.append("objectDSL.seeCustom(\"").append(key).append("\", new RefImpl(recurser.seeCustom(dsl, ").append(domainDotGetRefCall).append(", ").append(value.getKlass().getKlassName()+".class").append(")));\n");
            }
        } else if (value.getTemplateArgs().size() == 1) {
            if (value.getKlass().equals(new Klass(List.class))) {
                assert value.getTemplateArgs().size() == 1;
                KlassTree inner = value.getTemplateArgs().get(0);
                final String arity = (inner.getTemplateArgs().size() == 1) ? "" : ""+inner.getTemplateArgs().size();
                sb.append("objectDSL.seeList(\"").append(key).append("\", new RefImpl(recurser.seeCustomRefList").append(arity).append("(dsl, ").append(domainDotGetRefCall).append(", ");
                for (KlassTree k : inner.getTemplateArgs()) {
                    sb.cont().append(k.getKlass().getKlassName()+".class, ");
                }
                sb.cont().deleteCharAt(sb.cont().length()-1);
                sb.cont().deleteCharAt(sb.cont().length()-1);
                sb.cont().append(")));\n");
            } else {
                throw new IllegalArgumentException("Unhandled klass (1): "+value);
            }
        } else if (value.getTemplateArgs().size() == 2 && value.getKlass().equals(new Klass(Map.class))) {
            KlassTree k = value.getTemplateArgs().get(1);
            if (k.getKlass().equals(new Klass(Ref.class))) { k = k.getTemplateArgs().get(0); }
            else if (k.getKlass().equals(new Klass(Ref2.class))) throw new NotImplementedException();
            else if (k.getKlass().equals(new Klass(Ref3.class))) throw new NotImplementedException();
            sb.append("objectDSL.seeCustom(\""+key+"\", new RefImpl(recurser.seeCustomMap(dsl, "+domainDotGetRefCall+", "+k.getKlass()+".class)));\n");
        } else {
            throw new IllegalArgumentException("Unhandled klass (?): "+value);
        }
    }
}
