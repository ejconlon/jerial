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
        objects = new RefImpl<List<Post>>(new ArrayList<Post>(args.length));
        for (final Post x : args) {
            objects.getRef().add(x);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Arr arr = (Arr) o;

        if (objects != null ? !objects.equals(arr.objects) : arr.objects != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return objects != null ? objects.hashCode() : 0;
    }
}
