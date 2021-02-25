package com.example.graph.command;

import com.example.graph.client.MyCanvas;
import com.example.graph.model.Circle;
import com.example.graph.model.Grid;
import com.example.graph.model.Vacant;

import java.util.LinkedList;
import java.util.Queue;

public class BucketFillCommand extends Command{
    public int x;
    public int y;
    public Class<? extends Grid> fillShape;

    public BucketFillCommand(int [] coordinates, Class<? extends Grid> fillShape) {
        this.x = coordinates[0];
        this.y = coordinates[1];
        this.fillShape = fillShape;
    }

    @Override
    public void execute() {
        bucketFill();
    }

    private void bucketFill() {
        canvas= MyCanvas.getInstance();
        if(canvas.getGrids()[y][x] instanceof Vacant ==false)
            return;
        floodFill(fillShape);
    }

    private void floodFill(Class<? extends Grid> fillShape) {
        Queue<Grid> queue = new LinkedList<>();
        queue.add(canvas.getGrids()[y][x]);
        int row = canvas.getGrids().length;
        int column = canvas.getGrids()[0].length;

        System.out.println("BFS traversal...");
        while (!queue.isEmpty()) {
            Grid current = queue.remove();
            Vacant vacant = (Vacant) current;
            y = vacant.getRow();
            x = vacant.getColumn();

            try {
                canvas.getGrids()[y][x] = fillShape.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                canvas.getGrids()[y][x] = new Circle();
            }
            //go left
            Grid left = canvas.getGrids()[y][x - 1];
            if (x - 1 >= 0 && left instanceof Vacant && ((Vacant) left).isVisited() == false) {
                queue.add(left);
                ((Vacant) left).setVisited(true);
            }
            //go right
            Grid right = canvas.getGrids()[y][x + 1];
            if (x + 1 <= column && right instanceof Vacant && ((Vacant) right).isVisited() == false) {
                queue.add(right);
                ((Vacant) right).setVisited(true);
            }
            //go up
            Grid up = canvas.getGrids()[y - 1][x];
            if (y - 1 >= 0 && up instanceof Vacant && ((Vacant) up).isVisited() == false) {
                queue.add(up);
                ((Vacant) up).setVisited(true);
            }
            //go down
            Grid down = canvas.getGrids()[y + 1][x];
            if (y + 1 <= row && down instanceof Vacant && ((Vacant) down).isVisited() == false) {
                queue.add(down);
                ((Vacant) down).setVisited(true);
            }
        }
    }
}
