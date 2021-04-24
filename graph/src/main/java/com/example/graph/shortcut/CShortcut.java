package com.example.graph.shortcut;


import com.example.graph.client.ActionVisitor;
import com.example.graph.command.CanvasCommand;

public class CShortcut extends Shortcut{
    public int width;
    public int height;


    @Override
    public int[] getCoordinates() {
        return new int []{width,height};
    }

    @Override
    public CanvasCommand accept(ActionVisitor actionVisitor) {
        return actionVisitor.visit(this);
    }

    public CShortcut(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
