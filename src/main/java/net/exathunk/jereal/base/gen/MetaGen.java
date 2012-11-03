package net.exathunk.jereal.base.gen;

import java.util.*;

/**
 * charolastra 11/3/12 2:30 PM
 */
public class MetaGen implements GenWritable {

    private final List<GenWritable> writables;

    public MetaGen(List<GenWritable> writables) {
        this.writables = writables;
    }

    public static GenWritable makeDefault(String packageName, String className, Set<String> imports, Map<String, String> fields) {
        List<GenWritable> writables = new ArrayList<GenWritable>();
        writables.add(new ClassGen(packageName, className, imports, fields));
        writables.add(new InterfaceGen(packageName, className, imports, fields));
        writables.add(new RefableInterfaceGen(packageName, className, imports, fields));
        return new MetaGen(writables);
    }

    @Override
    public Map<String, String> makeClassToTextMap() {
        Map<String, String> map = new TreeMap<String, String>();
        for (GenWritable writable : writables) {
            Map<String, String> subMap = writable.makeClassToTextMap();
            for (Map.Entry<String, String> entry : subMap.entrySet()) {
                 map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }
}
