package com.example.graph.client;

import com.example.graph.model.*;
import com.example.graph.shortcut.BShortcut;
import com.example.graph.shortcut.LShortcut;
import com.example.graph.shortcut.RShortcut;
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
public class BucketFillComprehensiveTest {
    @Autowired
    GridRender render;


    @BeforeClass
    public static void intiCanvas() {
        MyCanvas.initInstance(8, 4);
    }

    @Test
    public void testBucketFill() throws Exception {
        String expected = "----------\n"+
                "|  xooooo|\n" +
                "|xxxxxxoo|\n" +
                "|oooxxxoo|\n" +
                "|oooooooo|\n" +
                "----------" ;

        RShortcut rShortcut = new RShortcut(4, 2, 6, 3);
        MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
        app.executeCommand();

        LShortcut lShortcut = new LShortcut(3, 1, 3, 2);
        app.shortcut=lShortcut;
        app.executeCommand();

        LShortcut llShortcut = new LShortcut(1, 2, 2, 2);
        app.shortcut=llShortcut;
        app.executeCommand();

        BShortcut bShortcut = new BShortcut(2, 3, Circle.class);
        app.shortcut=bShortcut;
        app.executeCommand();

        Grid[][] result = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(result);
        assertEquals(expected, actual);
    }
}
