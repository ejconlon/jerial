package net.exathunk.jereal.base.gen;

/**
 * charolastra 11/3/12 2:21 PM
 */
public interface GenLike extends GenWritable {

    public String effectiveClassName();

    void writePackage(Stringer sb);

    void writeImports(Stringer sb);

    void writeOpenClass(Stringer sb);

    void writeCloseClass(Stringer sb);

    void writeDeclarations(Stringer sb);

    void writeConstructor(Stringer sb);

    void writeToString(Stringer sb);

    void writeEquals(Stringer sb);

    void writeHashCode(Stringer sb);

    void writeMethods(Stringer sb);

    void writeClass(Stringer sb);
}
