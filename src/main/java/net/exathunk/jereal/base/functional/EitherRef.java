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

    public Reference<D> getLeftReference() {
        final EitherRef<D, E> thiz = this;
        return new Reference<D>() {
            @Override
            public D getReference() {
                return thiz.getLeft();
            }

            @Override
            public void setReference(D reference) {
                thiz.setLeft(reference);
            }
        };
    }

    public Reference<E> getRightReference() {
        final EitherRef<D, E> thiz = this;
        return new Reference<E>() {
            @Override
            public E getReference() {
                return thiz.getRight();
            }

            @Override
            public void setReference(E reference) {
                thiz.setRight(reference);
            }
        };
    }
}
