package com.example.graph.shortcut;

import com.example.graph.client.ActionVisitor;
import com.example.graph.command.BucketFillCommand;
import com.example.graph.model.Grid;

public class BShortcut extends Shortcut{
public int x;
public int y;
public Class<? extends Grid> fillShape;

    @Override
    public int[] getCoordinates() {
        return new int[]{x,y};
    }


    @Override
    public BucketFillCommand accept(ActionVisitor actionVisitor) {
        return actionVisitor.visit(this);
    }

    public BShortcut(int x, int y, Class type) {
        this.x = x;
        this.y = y;
        this.fillShape = type;
    }

    public Class<? extends Grid> getFillShape() {
        return fillShape;
    }
}
