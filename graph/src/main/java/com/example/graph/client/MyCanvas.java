package com.example.graph.client;


import com.example.graph.model.Bar;
import com.example.graph.model.Dash;
import com.example.graph.model.Grid;
import com.example.graph.model.Vacant;

public class MyCanvas {
    private static Grid[][] grids;

    private static MyCanvas INSTANCE;

    private MyCanvas() {
    }

    public static MyCanvas getInstance(){
        return INSTANCE;
    }


    public static MyCanvas initInstance(int width, int height) {
        if (INSTANCE ==null){
            INSTANCE=new MyCanvas();
            setUpGrids(height,width);
        }
        return INSTANCE;
    }

    private static void setUpGrids(int n, int m) {
        INSTANCE.grids = new Grid[n + 2][m + 2];
        int i, j;
        for (i = 0; i <= n + 1; i++) {
            for (j = 0; j <= m + 1; j++) {
                if (i == 0 || i == n + 1)
                    grids[i][j] = new Dash();
                else if ((i != 0 && i != n + 1) && (j == 0 || j == m + 1))
                    grids[i][j] = new Bar();
                else
                    grids[i][j] = new Vacant(i, j);
            }
        }
    }

    public Grid[][] getGrids(){
        return grids;
    }
}
