package net.exathunk.jereal.base.gen;

import java.util.*;

/**
 * charolastra 11/7/12 6:39 PM
 */
public class KlassTree {
    private final Klass klass;
    private final List<KlassTree> templateArgs;

    public KlassTree(Klass klass) {
        this(klass, new ArrayList<KlassTree>());
    }

    public KlassTree(Klass klass, List<KlassTree> templateArgs) {
        this.klass = klass;
        this.templateArgs = templateArgs;
        assert klass != null;
        assert templateArgs != null;
    }

    public KlassTree(Klass klass, KlassTree... templateArgs) {
        this(klass, Arrays.asList(templateArgs));
    }

    public KlassTree(Klass klass, Klass... klasses) {
        this(klass, makeTree(klasses));
    }

    private static List<KlassTree> makeTree(Klass... klasses) {
        List<KlassTree> l = new ArrayList<KlassTree>(klasses.length);
        for (Klass k : klasses) {
            l.add(new KlassTree(k));
        }
        return l;
    }

    public Klass getKlass() {
        return klass;
    }

    public List<KlassTree> getTemplateArgs() {
        return templateArgs;
    }

    public Set<Klass> collectImports() {
        Set<Klass> imports = new TreeSet<Klass>();
        collectImportsInner(imports);
        return imports;
    }

    private void collectImportsInner(Set<Klass> imports) {
        imports.add(klass);
        for (KlassTree t : templateArgs) {
            t.collectImportsInner(imports);
        }
    }

    @Override
    public String toString() {
        if (templateArgs.isEmpty()) return klass.getKlassName();
        StringBuilder sb = new StringBuilder();
        sb.append(klass.getKlassName()).append("<");
        for (KlassTree t : templateArgs) {
            sb.append(t.toString()).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KlassTree)) return false;

        KlassTree klassTree = (KlassTree) o;

        if (!klass.equals(klassTree.klass)) return false;
        if (!templateArgs.equals(klassTree.templateArgs)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = klass.hashCode();
        result = 31 * result + templateArgs.hashCode();
        return result;
    }
}
