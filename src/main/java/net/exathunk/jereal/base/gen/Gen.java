package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.schema.domain.SchemaRef;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * charolastra 11/2/12 9:09 PM
 */
public abstract class Gen implements GenLike {

    protected final Genable genable;

    public Gen(Genable genable) {
        this.genable = genable;
    }

    @Override
    public void writePackage(Stringer sb) {
        sb.append("package ").append(genable.getKlass().getPackageName()).append(";\n\n");
    }

    @Override
    public void writeImports(Stringer sb) {
        for (Klass importt : genable.getImports()) {
            sb.append("import ").append(importt).append(";\n");
        }
        if (!genable.getImports().isEmpty()) sb.append("\n");
    }

    @Override
    public void writeCloseClass(Stringer sb) {
        sb.append("}\n");
    }

    @Override
    public void writeClass(Stringer sb) {
        writePackage(sb);

        writeImports(sb);

        writeOpenClass(sb);

        writeDeclarations(sb.indent());

        writeConstructor(sb.indent());

        writeMethods(sb.indent());

        writeToString(sb.indent());

        writeEquals(sb.indent());

        writeHashCode(sb.indent());

        writeCloseClass(sb);
    }

    @Override
    public Map<String, String> makeClassToTextMap() {
        Map<String, String> map = new TreeMap<String, String>();
        Stringer sb = new Stringer();
        writeClass(sb);
        map.put(genable.getKlass().getPackageName()+"."+effectiveClassName(), sb.toString());
        return map;
    }
}
