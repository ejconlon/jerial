package net.exathunk.jereal.base.gen;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * charolastra 11/2/12 9:09 PM
 */
public abstract class Gen implements GenLike {

    protected final String packageName;
    protected final String className;
    protected final Set<String> imports;
    protected final Map<String, String> fields;

    public Gen(String packageName, String className, Set<String> imports, Map<String, String> fields) {
        this.packageName = packageName;
        this.className = className;
        this.imports = imports;
        this.fields = fields;
    }

    @Override
    public void writePackage(Stringer sb) {
        sb.append("package ").append(packageName).append(";\n\n");
    }

    @Override
    public void writeImports(Stringer sb) {
        for (String importt : imports) {
            sb.append("import ").append(importt).append(";\n");
        }
        if (!imports.isEmpty()) sb.append("\n");
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
        map.put(packageName+"."+effectiveClassName(), sb.toString());
        return map;
    }
}
