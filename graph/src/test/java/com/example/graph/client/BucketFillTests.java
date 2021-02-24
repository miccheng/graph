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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BucketFillTests {
    @Autowired
    GridRender render;


    @BeforeClass
    public static void intiCanvas() {
        MyCanvas.initInstance(8, 4);
    }

    @Test
    public void testBucketFill() throws Exception {
        Grid[][] expectedGrids = {
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash(), new Dash(), new Dash()},
                {new Bar(), new Vacant(1,1), new Vacant(1,2), new Cross(), new Circle(), new Circle(),new Circle(),new Circle(),new Circle(),new Bar()},
                {new Bar(), new Cross(), new Cross(), new Cross(), new Cross(),new Cross(), new Cross(),new Circle(),new Circle(), new Bar()},
                {new Bar(), new Circle(), new Circle(),new Circle(), new Cross(), new Cross(),new Cross(),new Circle(),new Circle(),new Bar()},
                {new Bar(), new Circle(), new Circle(),new Circle(), new Circle(), new Circle(),new Circle(),new Circle(), new Circle(), new Bar()},
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash(), new Dash()}
        };
        Grid[][] grids = MyCanvas.getInstance().getGrids();

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
        String expected = render.displayGrids(expectedGrids);
        assertEquals(expected, actual);
    }
}
