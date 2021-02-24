package com.example.graph.command;

import com.example.graph.client.MyCanvas;
import com.example.graph.model.Cross;

public class RectangleCommand extends Command{

    public int x;
    public int y;
    public int width;
    public int height;

    public RectangleCommand(int coordinates[]) {
        this.x = coordinates[0];
        this.y = coordinates[1];
        this.height = coordinates[3] -coordinates[1];
        this.width = coordinates[2]-coordinates[0];
    }

    @Override
    public void execute() {
        drawRectangle();
    }

    private void drawRectangle() {
        canvas= MyCanvas.getInstance();
        draw();
    }

    private void draw() {
        int i, j;
        for (i = y; i <= y + height; i++) {
            for (j = x; j <= x + width; j++) {
                canvas.getGrids()[i][j] = new Cross();
            }
        }
    }
}
