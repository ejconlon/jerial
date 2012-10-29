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

    public Reference<D> getLeftReference() {
        final EitherRef<D, E> thiz = this;
        return new Reference<D>() {
            final EitherRef<D, E> thizAgain = thiz;

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
            final EitherRef<D, E> thizAgain = thiz;

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
