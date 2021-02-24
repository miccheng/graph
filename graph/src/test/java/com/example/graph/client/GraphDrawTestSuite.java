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

    @Before
    public void resetCanvas() {
        MyCanvas.getInstance().resetGrids();
    }

    @Test
    public void testRectangle() {
        RShortcut rShortcut = new RShortcut(1, 1, 2, 2);
        MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
        app.executeCommand();

        Grid[][] result = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(result);
        String expected = "------\n" +
                          "|xx  |\n" +
                          "|xx  |\n" +
                          "|    |\n" +
                          "------\n";
        assertEquals(expected, actual);
    }

    @Test
    public void testVerticalLine() throws Exception {
        LShortcut lShortcut = new LShortcut(3, 1, 3, 2);
        MyGraphics2DApp app = new MyGraphics2DApp(lShortcut);
        app.executeCommand();

        Grid[][] result = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(result);
        String expected = "------\n" +
                          "|  x |\n" +
                          "|  x |\n" +
                          "|    |\n" +
                          "------\n";
        assertEquals(expected, actual);
    }


    @Test
    public void testHorizontalLine() throws Exception {
        LShortcut lShortcut = new LShortcut(3, 3, 4, 3);
        MyGraphics2DApp app = new MyGraphics2DApp(lShortcut);
        app.executeCommand();

        Grid[][] result = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(result);
        String expected = "------\n" +
                          "|    |\n" +
                          "|    |\n" +
                          "|  xx|\n" +
                          "------\n";
        assertEquals(expected, actual);
    }


}
