package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.schema.domain.SchemaRef;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * charolastra 11/3/12 2:18 PM
 */
public class ClassGen extends Gen {
    public ClassGen(Genable genable) {
        super(genable);
    }

    @Override
    public String effectiveClassName() {
        return genable.getKlass().getKlassName();
    }

    @Override
    public void writeOpenClass(Stringer sb) {
        sb.append("public class ").append(effectiveClassName()).append(" implements ").append(genable.getKlass().getKlassName()).append("Like, ").append(genable.getKlass().getKlassName()).append("Refable {\n\n");
    }

    @Override
    public void writeDeclarations(Stringer sb) {
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            sb.append("private final ").append(entry.getValue()).append(" ").append(entry.getKey()).append(";\n");
        }
        sb.cont().append("\n");
    }

    @Override
    public void writeConstructor(Stringer sb) {
        sb.append("public ").append(genable.getKlass().getKlassName()).append("() {\n");
        Stringer sb2 = sb.indent();
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            if (entry.getValue().getKlass().equals(new Klass(Ref.class))) {
                sb2.append(entry.getKey()).append(" = new RefImpl<").append(entry.getValue().getTemplateArgs().get(0)).append(">();\n");
            } else {
                sb2.append(entry.getKey()).append(" = new ").append(entry.getValue()).append("();\n");
            }
        }
        sb.append("}\n\n");
    }

    @Override
    public void writeToString(Stringer sb) {
        sb.append("@Override\n");
        sb.append("public String toString() {\n");
        Stringer sb2 = sb.indent();
        sb2.append("StringBuilder sb = new StringBuilder(\"").append(genable.getKlass().getKlassName()).append("{ \");\n");
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            sb2.append("if (!").append(entry.getKey()).append(".isEmptyRef()) sb.append(\"");
            sb2.cont().append(entry.getKey()).append("='\")").append(".append(").append(entry.getKey()).append(").append(\"', \");\n");
        }
        sb2.append("return sb.append(\"}\").toString();\n");
        sb.append("}\n\n");
    }

    @Override
    public void writeEquals(Stringer sb) {
        sb.append("@Override\n");
        sb.append("public boolean equals(Object o) {\n");
        Stringer sb2 = sb.indent();
        sb2.append("if (this == o) return true;\n");
        sb2.append("if (o instanceof ").append(genable.getKlass().getKlassName()).append("Refable) {\n");
        sb2.indent().append(genable.getKlass().getKlassName()).append("Refable other = (").append(genable.getKlass().getKlassName()).append("Refable) o;\n");
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            writeEqualsInner(sb2.indent(), entry.getKey());
        }
        sb2.indent().append("return true;\n");
        sb2.append("} else {\n");
        sb2.indent().append("return false;\n");
        sb2.append("}\n");
        sb.append("}\n\n");
    }

    private void writeEqualsInner(Stringer sb, String key) {
        final String capKey = key.substring(0, 1).toUpperCase()+key.substring(1);
        final String getCall = "get"+capKey+"Ref()";
        sb.append("if (!" + getCall + ".equals(other." + getCall + ")) return false;\n");
    }

    @Override
    public void writeHashCode(Stringer sb) {
        sb.append("@Override\n");
        sb.append("public int hashCode() {\n");
        Stringer sb2 = sb.indent();
        sb2.append("int result = 0;\n");
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            sb2.append("result = 31 * result + ").append(entry.getKey()).append(".hashCode();\n");
        }
        sb2.append("return result;\n");
        sb.append("}\n\n");
    }

    @Override
    public void writeMethods(Stringer sb) {
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            writeMethodsForField(sb, entry.getKey(), entry.getValue());
        }
    }


    private void writeMethodsForField(Stringer sb, String name, KlassTree klassTree) {
        final String capName = name.substring(0, 1).toUpperCase()+name.substring(1);
        sb.append("@Override\n");
        sb.append("public boolean has").append(capName).append("() {\n");
        sb.indent().append("return !"+name+".isEmptyRef();\n");
        sb.append("}\n");
        if (klassTree.getKlass().equals(new Klass(Ref.class))) {
            sb.append("@Override\n");
            sb.append("public ").append(klassTree.getTemplateArgs().get(0)).append(" get").append(capName).append("() {\n");
            sb.indent().append("return "+name+".getRef();\n");
            sb.append("}\n");
            sb.append("@Override\n");
            sb.append("public void set").append(capName).append("(").append(klassTree.getTemplateArgs().get(0)).append(" value) {\n");
            sb.indent().append(name+".setRef(value);\n");
            sb.append("}\n");
        } // TODO ref2 and ref3
        sb.append("@Override\n");
        sb.append("public ").append(klassTree).append(" get").append(capName).append("Ref() {\n");
        sb.indent().append("return ").append(name).append(";\n");
        sb.append("}\n\n");
    }
}
