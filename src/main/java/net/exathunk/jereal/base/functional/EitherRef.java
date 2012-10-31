package net.exathunk.jereal.base.functional;

/**
 * Mutable either.
 *
 * charolastra 10/29/12 4:05 PM
 */
public class EitherRef<D, E> extends Either<D, E> {
    protected EitherRef(D d, E e) {
        super(d, e);
    }

    public static <D, E> EitherRef<D, E> makeLeftRef(D d) {
        return new EitherRef<D, E>(d, null);
    }

    public static <D, E> EitherRef<D, E> makeRightRef(E e) {
        return new EitherRef<D, E>(null, e);
    }

    public Ref<D> getLeftReference() {
        final EitherRef<D, E> thiz = this;
        return new Ref<D>() {
            @Override
            public D getRef() {
                return thiz.getLeft();
            }

            @Override
            public void setRef(D value) {
                thiz.setLeft(value);
            }

            @Override
            public boolean isEmptyRef() {
                return !thiz.hasLeft();
            }
        };
    }

    public Ref<E> getRightReference() {
        final EitherRef<D, E> thiz = this;
        return new Ref<E>() {
            @Override
            public E getRef() {
                return thiz.getRight();
            }

            @Override
            public void setRef(E value) {
                thiz.setRight(value);
            }

            @Override
            public boolean isEmptyRef() {
                return !thiz.hasRight();
            }
        };
    }
}
