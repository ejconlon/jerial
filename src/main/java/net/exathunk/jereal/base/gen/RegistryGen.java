package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Questionable;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.jerializers.RegistryBuilder;
import net.exathunk.jereal.base.jerializers.RegistryFactory;
import net.exathunk.jereal.schema.domain.Schema;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * charolastra 11/8/12 3:18 AM
 */
public class RegistryGen extends Gen {

    private final Set<Klass> genKlasses;

    public RegistryGen(final Klass klass, final Set<Klass> genKlasses) {
        super(new Genable() {
            @Override
            public Klass getKlass() {
                return klass;
            }

            @Override
            public Set<Klass> getImports() {
                Set<Klass> i = new TreeSet<Klass>();
                i.add(new Klass(RegistryBuilder.class));
                i.add(new Klass(RegistryFactory.class));
                i.add(new Klass(PushableContext.class));
                i.add(new Klass(Questionable.class));
                for (Klass x : genKlasses) {
                    i.add(x);
                    i.add(new Klass(x.getKlassName()+"Jerializer", x.getPackageName()));
                }
                return i;
            }

            @Override
            public Map<String, KlassTree> getFields() {
                return null;
            }

            @Override
            public Schema getSchema() {
                return null;  //AUTOGEN
            }
        });
        this.genKlasses = genKlasses;
    }

    @Override
    public String effectiveClassName() {
        return genable.getKlass().getKlassName();
    }

    @Override
    public void writeOpenClass(Stringer sb) {
        sb.append("public class ").append(effectiveClassName()).append("<T extends PushableContext<T, U>, U extends Questionable> extends RegistryBuilder<T, U> {\n\n");
    }

    @Override
    public void writeDeclarations(Stringer sb) {
    }

    @Override
    public void writeConstructor(Stringer sb) {
        sb.append("public ").append(effectiveClassName()).append("() {\n");
        Stringer sb2 = sb.indent();
        for (Klass k : genKlasses) {
            sb2.append("add(").append(k.getKlassName()).append(".class, new ").append(k.getKlassName()).append("Jerializer());\n");
        }
        sb.append("}\n\n");
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
    }
}
