package net.exathunk.jereal.base.gen;

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
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            sb2.append("// dsl.addSomething(domain.get").append(KlassContext.capitalize(entry.getKey())).append("Ref());\n");
        }
        sb2.append("return null;\n");
        sb.append("}\n\n");
    }
}
