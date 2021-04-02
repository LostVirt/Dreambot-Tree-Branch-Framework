package org.dreambot.framework;


import org.dreambot.api.script.AbstractScript;

public abstract class Leaf<T extends AbstractScript> {
    public abstract boolean isValid(T context);

    public abstract int onLoop(T context);
}
