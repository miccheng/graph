package com.example.leetcode.datastructure;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class BigTable {
    private final List<Map<String, Integer>> table;

    //    Table : [
//    { x : 1, y : 2, z : 3},
//    { x : 1, y : 2, z : 2},
//    {x : 1, y : 2, z : 4 }
//]
//minByColumn(Table, ["x", "y", "z"]) -> return { x : 1, y : 2, z : 2}

    public BigTable(List<Map<String, Integer>> table) {
        this.table = table;
    }

    public Map<String, Integer> getMinRowByCol(String column){
        Collections.sort(table, Comparator.comparingInt(row -> row.get(column)));
        return table.get(0);
    }

    public Map<String, Integer> getMinRowByColComposite(String[] columns) {
        Collections.sort(table, new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> row1, Map<String, Integer> row2) {
                for (String col : columns) {
                    if (row1.get(col) != row2.get(col))
                        continue;
                    else
                        return row1.getOrDefault(col, 0) - row2.getOrDefault(col, 0);
                }
                return 0;//why???
            }
        });

        return table.get(0);
    }
}
