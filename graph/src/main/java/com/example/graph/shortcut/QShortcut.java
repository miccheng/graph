package com.example.graph.shortcut;

import com.example.graph.client.ActionVisitor;
import com.example.graph.command.QuitCommand;

public class QShortcut extends Shortcut{
    @Override
    public int[] getCoordinates() {
        return new int[0];
    }

    @Override
    public QuitCommand accept(ActionVisitor actionVisitor) {
        return actionVisitor.visit(this);
    }
}
