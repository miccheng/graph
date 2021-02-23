package com.example.graph.command;

import com.example.graph.client.MyCanvas;

public class CanvasCommand extends Command{
public int width;
public int height;

    public CanvasCommand(int coordinates[]) {
        this.width = coordinates[0];
        this.height = coordinates[1];
    }

    @Override
    public void execute() {
        this.canvas=drawCanvas(width,height);
    }

    private MyCanvas drawCanvas(int width, int height) {
        return MyCanvas.initInstance(width,height);
    }
}
