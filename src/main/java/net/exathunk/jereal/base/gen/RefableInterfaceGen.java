package net.exathunk.jereal.base.gen;

import java.util.Map;
import java.util.Set;

/**
 * charolastra 11/3/12 2:19 PM
 */
public class RefableInterfaceGen extends Gen {

    public RefableInterfaceGen(Genable genable) {
        super(genable);
    }

    private void writeRefableInterfaceFuncs(Stringer sb, String name, KlassTree klassTree) {
        final String capName = name.substring(0, 1).toUpperCase()+name.substring(1);
        sb.append("Ref<").append(klassTree).append("> get").append(capName).append("Ref();\n\n");
    }

    @Override
    public String effectiveClassName() {
        return genable.getKlass().getKlassName()+"Refable";
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
        for (Map.Entry<String, KlassTree> entry : genable.getFields().entrySet()) {
            writeRefableInterfaceFuncs(sb.indent(), entry.getKey(), entry.getValue());
        }
    }
}
