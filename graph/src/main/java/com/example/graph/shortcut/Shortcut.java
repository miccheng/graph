package com.example.graph.shortcut;

import com.example.graph.client.ActionVisitor;
import com.example.graph.command.Command;

public abstract class Shortcut {
    public abstract int[] getCoordinates();

    public abstract Command accept(ActionVisitor av);

}
