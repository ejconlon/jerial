package net.exathunk.jereal.example;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * charolastra 10/23/12 9:44 PM
 */
public class Arr {
    public final Ref<List<Post>> objects;

    public Arr(Post... args) {
        if (args.length == 0) {
            objects = new RefImpl<List<Post>>();
        } else {
            objects = new RefImpl<List<Post>>(new ArrayList<Post>(args.length));
            for (final Post x : args) {
                objects.getRef().add(x);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Arr arr = (Arr) o;

        if (objects.isEmptyRef()) {
            return arr.objects.isEmptyRef();
        } else if (arr.objects.isEmptyRef()) {
            return false;
        } else {
            if (objects.getRef().size() != arr.objects.getRef().size()) {
                return false;
            } else {
                for (int i = 0; i < objects.getRef().size(); ++i) {
                    if (!objects.getRef().get(i).equals(arr.objects.getRef().get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    @Override
    public int hashCode() {
        return objects != null ? objects.hashCode() : 0;
    }
}
