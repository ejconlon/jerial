package net.exathunk.jereal.base.gen;

import java.util.Map;
import java.util.Set;

/**
 * charolastra 11/3/12 2:19 PM
 */
public class RefableInterfaceGen extends Gen {

    public RefableInterfaceGen(String packageName, String className, Set<String> imports, Map<String, String> fields) {
        super(packageName, className, imports, fields);
    }

    private void writeRefableInterfaceFuncs(Stringer sb, String name, String klass) {
        final String capName = name.substring(0, 1).toUpperCase()+name.substring(1);
        sb.append("Ref<").append(klass).append("> get").append(capName).append("Ref();\n\n");
    }

    @Override
    public String effectiveClassName() {
        return className+"Refable";
    }

    @Override
    public void writeOpenClass(Stringer sb) {
        sb.append("public interface ").append(effectiveClassName()).append(" {\n\n");
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
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            writeRefableInterfaceFuncs(sb.indent(), entry.getKey(), entry.getValue());
        }
    }
}
