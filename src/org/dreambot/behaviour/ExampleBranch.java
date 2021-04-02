package org.dreambot.behaviour;

import org.dreambot.Main;
import org.dreambot.framework.Branch;

public class ExampleBranch extends Branch<Main> {
    @Override
    public boolean isValid(Main context) {
        return true;
    }
}
