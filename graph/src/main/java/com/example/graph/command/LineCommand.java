package com.example.graph.command;

import com.example.graph.client.MyCanvas;
import com.example.graph.model.Cross;

public class LineCommand extends Command{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int length;


    public LineCommand(int coordinates[]) {
        this.x1 = coordinates[0];
        this.y1 = coordinates[1];
        this.x2 = coordinates[3];
        this.y2 = coordinates[4];
        int a=x2-x1;
        int b=y2-y1;
        this.length = (a>b)?a:b;
    }


    @Override
    public void execute() {
        canvas= MyCanvas.getInstance();
        drawLine();
    }

    private void drawLine() {
        int i = y1;
        int j = x1;
        if (x1 == x2) {
            while (i <= y2) {
                canvas.getGrids()[i][j] = new Cross();
            }
        } else {
            while (j <= x2) {
                canvas.getGrids()[i][j] = new Cross();
            }
        }
    }
}
