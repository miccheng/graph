package com.example.graph.client;

import com.example.graph.model.*;
import com.example.graph.shortcut.CShortcut;
import com.example.graph.shortcut.LShortcut;
import com.example.graph.shortcut.RShortcut;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GraphDrawTestSuite {
    /**these tests are supposed to be run together
     * Order: Lexicography order.
     * In this case, execution order will be DrawHorizontalLine, Draw Rectangle and then Draw Vertical line.
     * */

    @Autowired
    GridRender render;


    @BeforeClass
    public static void intiCanvas() {
        MyCanvas.initInstance(4, 3);
    }

    @Test
    public void testRectangle() {
        Grid[][] expectedGrids = {
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash()},
                {new Bar(), new Cross(), new Cross(), new Vacant(1, 3), new Vacant(1, 4), new Bar()},
                {new Bar(), new Cross(), new Cross(), new Vacant(2, 3), new Vacant(2, 4), new Bar()},
                {new Bar(), new Vacant(3, 1), new Vacant(3, 2), new Cross(), new Cross(), new Bar()},
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash()}
        };
        Grid[][] grids = MyCanvas.getInstance().getGrids();

        RShortcut rShortcut = new RShortcut(1, 1, 2, 2);
        MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
        app.executeCommand();

        Grid[][] result = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(result);
        String expected = render.displayGrids(expectedGrids);
        assertEquals(expected, actual);
    }

    @Test
    public void testVerticalLine() throws Exception {
        Grid[][] expectedGrids = {
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash()},
                {new Bar(), new Cross(), new Cross(), new Cross(), new Vacant(1, 4), new Bar()},
                {new Bar(), new Cross(), new Cross(), new Cross(), new Vacant(2, 4), new Bar()},
                {new Bar(), new Vacant(3, 1), new Vacant(3, 2), new Cross(), new Cross(), new Bar()},
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash()}
        };
        Grid[][] grids = MyCanvas.getInstance().getGrids();

        LShortcut lShortcut = new LShortcut(3, 1, 3, 2);
        MyGraphics2DApp app = new MyGraphics2DApp(lShortcut);
        app.executeCommand();

        Grid[][] result = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(result);
        String expected = render.displayGrids(expectedGrids);
        assertEquals(expected, actual);
    }


    @Test
    public void testHorizontalLine() throws Exception {
        Grid[][] expectedGrids = {
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash()},
                {new Bar(), new Vacant(1,1), new Vacant(1,2), new Vacant(1,3), new Vacant(1, 4), new Bar()},
                {new Bar(), new Vacant(2,1), new Vacant(2,2), new Vacant(2,3), new Vacant(2, 4), new Bar()},
                {new Bar(), new Vacant(3, 1), new Vacant(3, 2), new Cross(), new Cross(), new Bar()},
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash()}
        };
        Grid[][] grids = MyCanvas.getInstance().getGrids();

        LShortcut lShortcut = new LShortcut(3, 3, 4, 3);
        MyGraphics2DApp app = new MyGraphics2DApp(lShortcut);
        app.executeCommand();

        Grid[][] result = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(result);
        String expected = render.displayGrids(expectedGrids);
        assertEquals(expected, actual);
    }


}
