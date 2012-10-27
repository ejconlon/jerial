package net.exathunk.jereal.base;

/**
 * charolastra 10/27/12 3:36 PM
 */
public interface RegistryFactory {
    JerializerRegistry makeJerializerRegistry();
    DejerializerRegistry makeDejerializerRegistry();
}
