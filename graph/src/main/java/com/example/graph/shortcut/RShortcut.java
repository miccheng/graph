package com.example.graph.shortcut;

import com.example.graph.client.ActionVisitor;
import com.example.graph.command.Command;

public class RShortcut extends Shortcut{
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public RShortcut(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    @Override
    public int[] getCoordinates() {
        return new int[]{x1,y1,x2,y2};
    }

    @Override
    public Command accept(ActionVisitor actionVisitor) {
        return actionVisitor.visit(this);
    }
}
