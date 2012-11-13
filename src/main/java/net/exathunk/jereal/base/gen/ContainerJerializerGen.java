package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.functional.Ref;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * charolastra 11/7/12 5:27 PM
 */
public class ContainerJerializerGen extends JerializerGen {
    public ContainerJerializerGen(Genable genable) {
        super(genable);
    }

    @Override
    public void writeMethods(Stringer sb) {
        sb.append("@Override\n");
        sb.append("public ").append(genable.getKlass().getKlassName()).append(" prototype(Speclike spec) throws JerializerException {\n");
        Stringer sb2 = sb.indent();
        Stringer sb3 = sb2.indent();
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            final KlassTree kt = entry.getValue();
            if (kt.getTemplateArgs().size() > 1) {
                Map<Model, String> modelRets = new TreeMap<Model, String>();
                String[] names = {"First", "Second", "Third"};
                int i = 0;
                for (KlassTree sub : kt.getTemplateArgs()) {
                    final Model foundModel;
                    if (sub.getKlass().equals(new Klass(String.class))) {
                        foundModel = Model.STRING;
                    } else if (sub.getKlass().equals(new Klass(Boolean.class))) {
                        foundModel = Model.BOOLEAN;
                    } else if (sub.getKlass().equals(new Klass(Long.class))) {
                        foundModel = Model.LONG;
                    } else if (sub.getKlass().equals(new Klass(Double.class))) {
                        foundModel = Model.DOUBLE;
                    } else if (sub.getKlass().equals(new Klass(List.class))) {
                        foundModel = Model.ARRAY;
                    }else {
                        foundModel = Model.OBJECT;
                    }
                    modelRets.put(foundModel, ("domain.get"+KlassContext.capitalize(entry.getKey())+"Ref().set"+names[i]+"(new "+sub+"());\n").replace("new Map<", "new TreeMap<"));
                    i += 1;
                }
                sb2.append(genable.getKlass().getKlassName()).append(" domain = new ").append(genable.getKlass().getKlassName()).append("();\n");
                sb2.append("final Model model = spec.getModel();\n");
                sb2.append("switch (model) {\n");
                for (final Model model : Model.values()) {
                    sb3.append("case "+model+":\n");
                    if (modelRets.containsKey(model)) {
                        sb3.indent().append(modelRets.get(model));
                        sb3.indent().append("break;\n");
                    } else {
                        sb3.indent().append("throw new JerializerException(\"No matching model found for \"+spec);\n");
                    }
                }
                sb3.append("default:\n");
                sb3.indent().append("throw new JerializerException(\"No matching model found for \"+spec);\n");
                sb2.append("}\n");
                sb2.append("return domain;\n");
            } else {
                sb2.append("return new ").append(genable.getKlass().getKlassName()).append("();\n");
            }
        }
        sb.append("}\n\n");


        sb.append("@Override\n");
        sb.append("public Pipeable<U> jerialize(Recurser<T, U> recurser, DSL<T, U> dsl, ").append(genable.getKlass().getKlassName()).append(" domain) throws JerializerException {\n");
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            writeDslCommand(sb2, entry.getKey(), entry.getValue());
        }
        sb.append("}\n\n");
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
                sb.append("if (!"+domainDotGetRefCall+".getFirstRef().isEmptyRef())\n");
                writeDslCommandUncontained(sb.indent(), key, first, domainDotGetRefCall + ".getFirstRef()");
                sb.append("else if (!"+domainDotGetRefCall+".getSecondRef().isEmptyRef())\n");
                writeDslCommandUncontained(sb.indent(), key, second, domainDotGetRefCall + ".getSecondRef()");
                sb.append("else throw new JerializerException(\"Nil ref - no return\");\n");
            } else {
                throw new IllegalArgumentException("Unhandled klass (2): "+value);
            }
        } else if (value.getTemplateArgs().size() == 3) {
            if (value.getKlass().equals(new Klass(Ref3.class))) {
                KlassTree first = value.getTemplateArgs().get(0);
                KlassTree second = value.getTemplateArgs().get(1);
                KlassTree third = value.getTemplateArgs().get(2);
                sb.append("if (!"+domainDotGetRefCall+".getFirstRef().isEmptyRef())\n");
                writeDslCommandUncontained(sb.indent(), key, first, domainDotGetRefCall + ".getFirstRef()");
                sb.append("else if (!"+domainDotGetRefCall+".getSecondRef().isEmptyRef())\n");
                writeDslCommandUncontained(sb.indent(), key, second, domainDotGetRefCall + ".getSecondRef()");
                sb.append("else if (!"+domainDotGetRefCall+".getThirdRef().isEmptyRef())\n");
                writeDslCommandUncontained(sb.indent(), key, third, domainDotGetRefCall + ".getThirdRef()");
                sb.append("else throw new JerializerException(\"Nil ref - no return\");\n");
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
                sb.append("return dsl.seeString(").append(domainDotGetRefCall).append(");\n");
            } else if (value.getKlass().equals(new Klass("Double", "java.lang"))) {
                sb.append("return dsl.seeDouble(").append(domainDotGetRefCall).append(");\n");
            } else if (value.getKlass().equals(new Klass("Long", "java.lang"))) {
                sb.append("return dsl.seeLong(").append(domainDotGetRefCall).append(");\n");
            } else if (value.getKlass().equals(new Klass("Boolean", "java.lang"))) {
                sb.append("return dsl.seeBoolean(").append(domainDotGetRefCall).append(");\n");
            } else {
                final String baseClassName = value.getKlass().getKlassName();
                sb.append("return (new "+baseClassName+"Jerializer()).jerialize(recurser, dsl, "+domainDotGetRefCall+".getRef());\n");
            }
        } else if (value.getTemplateArgs().size() == 2 && value.getKlass().equals(new Klass(Map.class))){
            KlassTree k = value.getTemplateArgs().get(1);
            if (k.getKlass().equals(new Klass(Ref.class))) { k = k.getTemplateArgs().get(0); }
            else if (k.getKlass().equals(new Klass(Ref2.class))) throw new NotImplementedException();
            else if (k.getKlass().equals(new Klass(Ref3.class))) throw new NotImplementedException();
            sb.append("return recurser.seeCustomMap(dsl, "+domainDotGetRefCall+", "+k.getKlass()+".class);\n");
        } else {
            throw new IllegalArgumentException("Unhandled klass (?): "+value);
        }
    }
}
