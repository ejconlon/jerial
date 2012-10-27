package net.exathunk.jereal.base;

import net.exathunk.jereal.base.visitors.Jerial;

/**
 * For parity?
 *
 * charolastra 10/27/12 3:31 PM
 */
public class JerialDejerializer implements Dejerializer<Jerial> {
    @Override
    public Jerial dejerialize(DejerializerRegistry registry, Jerial jerial) throws JerializerException {
        return jerial;
    }
}
