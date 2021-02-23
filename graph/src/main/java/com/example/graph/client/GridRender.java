package com.example.graph.client;

import org.springframework.stereotype.Component;
import com.example.graph.model.Grid;
@Component
public class GridRender {

    public String displayGrids(Grid[][] grids) {
        StringBuilder strBuilder= new StringBuilder();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                strBuilder.append(grids[i][j]);
            }
            System.out.println();
            strBuilder.append("\n");
        }
        System.out.println("my stringbuilder"+"\n"+strBuilder.toString());
        return strBuilder.toString();
    }
}
