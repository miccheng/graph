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
        int row=canvas.getGrids().length;
        int column=canvas.getGrids()[0].length;

        System.out.println("BFS traversal...");
        while(!queue.isEmpty()){
            Grid current = queue.remove();
            Vacant vacant = (Vacant) current;
            y = vacant.getColumn();
            x = vacant.getRow();

            try {
                canvas.getGrids()[y][x]=fillShape.newInstance();
            } catch (InstantiationException |IllegalAccessException e) {
                canvas.getGrids()[y][x]=new Circle();
            }

            if(x-1>=0 && canvas.getGrids()[y][x-1] instanceof Vacant && ((Vacant) canvas.getGrids()[y][x-1]).isVisited()==false){
                queue.add(canvas.getGrids()[y][x-1]);//go left
                ((Vacant) canvas.getGrids()[y][x-1]).setVisited(true);
            }
            if(x+1<=column && canvas.getGrids()[y][x+1] instanceof Vacant && ((Vacant) canvas.getGrids()[y][x+1]).isVisited()==false){
                queue.add(canvas.getGrids()[y][x+1]);//go right
                ((Vacant) canvas.getGrids()[y][x+1]).setVisited(true);
            }
            if(y-1>=0 && canvas.getGrids()[y-1][x] instanceof Vacant && ((Vacant) canvas.getGrids()[y-1][x]).isVisited()==false){
                queue.add(canvas.getGrids()[y-1][x]);//go up
                ((Vacant) canvas.getGrids()[y-1][x]).setVisited(true);
            }
            if(y+1>row && canvas.getGrids()[y+1][x] instanceof Vacant && ((Vacant) canvas.getGrids()[y+1][x]).isVisited()==false){
                queue.add(canvas.getGrids()[y+1][x]);//go down
                ((Vacant) canvas.getGrids()[y+1][x]).setVisited(true);
            }
        }
    }
}
