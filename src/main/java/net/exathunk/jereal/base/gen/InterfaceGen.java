package net.exathunk.jereal.base.gen;

import java.util.Map;
import java.util.Set;

/**
 * charolastra 11/3/12 2:19 PM
 */
public class InterfaceGen extends Gen {
    public InterfaceGen(Genable genable) {
        super(genable);
    }

    @Override
    public String effectiveClassName() {
        return genable.getClassName()+"Like";
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
        for (Map.Entry<String, String> entry : genable.getFields().entrySet()) {
            writeInterfaceFuncs(sb.indent(), entry.getKey(), entry.getValue());
        }
    }

    private void writeInterfaceFuncs(Stringer sb, String name, String klass) {
        final String capName = name.substring(0, 1).toUpperCase()+name.substring(1);
        sb.append("boolean has").append(capName).append("();\n");
        sb.append(klass).append(" get").append(capName).append("();\n");
        sb.append("void set").append(capName).append("(").append(klass).append(" value);\n\n");
    }
}
