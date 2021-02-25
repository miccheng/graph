package com.example.graph.client;

import com.example.graph.model.Grid;
import com.example.graph.model.Vacant;
import org.springframework.stereotype.Component;

public class PreChecker {

    public boolean check(int[] coordinates) {
        if (MyCanvas.getInstance() == null) {
            return true;
        }
//        checkTakenOrNot(coordinates);
//        checkWithinCanvas(coordinates);
        return (checkWithinCanvas(coordinates) && checkTakenOrNot(coordinates));
    }


    //check within the canvas or not
    private boolean checkWithinCanvas(int[] coordinates) {
        int rowSize = MyCanvas.getInstance().getGrids().length;
        int columnSize = MyCanvas.getInstance().getGrids()[0].length;
        if (coordinates.length == 2 && coordinates[0] <= columnSize - 1 && coordinates[1] <= rowSize - 1)
            return true;
        if (coordinates.length == 4 && (Math.max(coordinates[0] , coordinates[2])) <= columnSize - 1 && (Math.max(coordinates[1] , coordinates[3])) <= rowSize - 1)
            return true;
        return false;
    }

    //check land on any taken nodes or not
    private boolean checkTakenOrNot(int[] coordinates) {
        Grid[][] grids = MyCanvas.getInstance().getGrids();
        Grid grid = grids[coordinates[1]][coordinates[0]];
        boolean a = grid instanceof Vacant ? true : false;
        if (coordinates.length == 2)
            return a;
        Grid grid2 = grids[coordinates[3]][coordinates[2]];
        boolean b = grid2 instanceof Vacant ? true : false;
        if (a && b)
            return true;
        else
            return false;
    }
}
