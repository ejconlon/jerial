package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.SchemaRef;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * charolastra 11/3/12 2:18 PM
 */
public class ContainerGen extends Gen {

    private static Map<String, String> makeContainerFields(String className) {
        Map<String, String> m = new TreeMap<String, String>();
        m.put("links", "GeneratedLinksContainer");
        m.put("objectValue", className);
        m.put("arrayValue", "List<JThing>");
        m.put("stringValue", "String");
        m.put("longValue", "Long");
        m.put("doubleValue", "Double");
        m.put("booleanValue", "Boolean");
        return m;
    }

    public ContainerGen(Genable genable) {
        super(genable);
    }

    @Override
    public String effectiveClassName() {
        return genable.getClassName()+"Container";
    }

    @Override
    public void writeOpenClass(Stringer sb) {
        sb.append("public class ").append(effectiveClassName()).append(" {\n\n");
    }

    @Override
    public void writeDeclarations(Stringer sb) {
        for (Map.Entry<String, String> entry : genable.getFields().entrySet()) {
            sb.append("private final Ref<").append(entry.getValue()).append("> ").append(entry.getKey()).append(";\n");
        }
        sb.cont().append("\n");
    }

    @Override
    public void writeConstructor(Stringer sb) {
        sb.append("public ").append(effectiveClassName()).append("() {\n");
        Stringer sb2 = sb.indent();
        for (Map.Entry<String, String> entry : genable.getFields().entrySet()) {
            sb2.append(entry.getKey()).append(" = new RefImpl<").append(entry.getValue()).append(">();\n");
        }
        sb.append("}\n\n");
    }

    @Override
    public void writeToString(Stringer sb) {
        sb.append("@Override\n");
        sb.append("public String toString() {\n");
        Stringer sb2 = sb.indent();
        sb2.append("StringBuilder sb = new StringBuilder(\"").append(effectiveClassName()).append("{ \");\n");
        for (Map.Entry<String, String> entry : genable.getFields().entrySet()) {
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
        sb2.append("if (o instanceof ").append(effectiveClassName()).append(") {\n");
        sb2.indent().append(effectiveClassName()).append(" other = (").append(effectiveClassName()).append(") o;\n");
        for (Map.Entry<String, String> entry : genable.getFields().entrySet()) {
            writeEqualsInner1(sb2.indent(), entry.getKey());
        }
        sb2.indent().append("return true;\n");
        sb2.append("} else {\n");
        sb2.indent().append("return false;\n");
        sb2.append("}\n");
        sb.append("}\n\n");
    }

    private void writeEqualsInner1(Stringer sb, String key) {
        final String capKey = key.substring(0, 1).toUpperCase()+key.substring(1);
        final String hasCall = "has"+capKey+"()";
        final String getCall = "get"+capKey+"()";
        sb.append("if ("+hasCall+") {\n");
        sb.indent().append("if (!other."+hasCall+") return false;\n");
        sb.indent().append("else if (!"+getCall+".equals(other."+getCall+")) return false;\n");
        sb.append("} else if (other."+hasCall+") return false;\n");
    }

    @Override
    public void writeHashCode(Stringer sb) {
        sb.append("@Override\n");
        sb.append("public int hashCode() {\n");
        Stringer sb2 = sb.indent();
        sb2.append("int result = 0;\n");
        for (Map.Entry<String, String> entry : genable.getFields().entrySet()) {
            sb2.append("result = 31 * result + ").append(entry.getKey()).append(".hashCode();\n");
        }
        sb2.append("return result;\n");
        sb.append("}\n\n");
    }

    @Override
    public void writeMethods(Stringer sb) {
        for (Map.Entry<String, String> entry : genable.getFields().entrySet()) {
            writeMethodsForField(sb, entry.getKey(), entry.getValue());
        }
    }

    private void writeMethodsForField(Stringer sb, String name, String klass) {
        final String capName = name.substring(0, 1).toUpperCase()+name.substring(1);
        //sb.append("@Override\n");
        sb.append("public boolean has").append(capName).append("() {\n");
        sb.indent().append("return !"+name+".isEmptyRef();\n");
        sb.append("}\n");
        //sb.append("@Override\n");
        sb.append("public ").append(klass).append(" get").append(capName).append("() {\n");
        sb.indent().append("return "+name+".getRef();\n");
        sb.append("}\n");
        //sb.append("@Override\n");
        sb.append("public void set").append(capName).append("(").append(klass).append(" value) {\n");
        sb.indent().append(name+".setRef(value);\n");
        sb.append("}\n");
        //sb.append("@Override\n");
        sb.append("public Ref<").append(klass).append("> get").append(capName).append("Ref() {\n");
        sb.indent().append("return ").append(name).append(";\n");
        sb.append("}\n\n");
    }

}
