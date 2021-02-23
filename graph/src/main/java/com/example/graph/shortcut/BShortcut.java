package com.example.graph.shortcut;

import com.example.graph.model.Grid;

public class BShortcut implements Shortcut{
public int x;
public int y;
public Class<? extends Grid> fillShape;

    @Override
    public int[] getCoordinates() {
        return new int[]{x,y};
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
