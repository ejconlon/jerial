package net.exathunk.jereal.schema;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/27/12 1:49 PM
 */
public class Meta {
    public enum TYPE {
        STRING, NUMBER, INTEGER, BOOLEAN, OBJECT, ARRAY, NULL, ANY
    }

    public String name;
    public String title;
    public String description;
    public String format;
    public List<TYPE> type = new ArrayList<TYPE>();
    public List<TYPE> itemType = new ArrayList<TYPE>();
    public boolean required;

    @Override
    public String toString() {
        return "Meta{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", type=" + type +
                ", itemType=" + itemType +
                ", required=" + required +
                '}';
    }
}
