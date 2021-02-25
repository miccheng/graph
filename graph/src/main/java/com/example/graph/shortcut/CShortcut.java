package com.example.graph.shortcut;


public class CShortcut implements Shortcut{
    public int width;
    public int height;


    @Override
    public int[] getCoordinates() {
        return new int []{width,height};
    }

    public CShortcut(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
