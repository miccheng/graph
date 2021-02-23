package com.example.graph.model;

public class Vacant extends Grid{
    private int row;
    private int column;
    private boolean visited;

    public Vacant(int row, int column) {
        sketch=" ";
        this.row=row;
        this.column=column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
