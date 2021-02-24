package com.example.graph.client;

import com.example.graph.model.*;
import com.example.graph.shortcut.BShortcut;
import com.example.graph.shortcut.LShortcut;
import com.example.graph.shortcut.RShortcut;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BucketFillClientTest {
    @Autowired
    GridRender render;


    @BeforeClass
    public static void intiCanvas() {
        MyCanvas.initInstance(20, 4);
    }

    @Test
    public void testBucketFill() throws Exception {
        {
            Grid[][] expectedGrids = {
                    {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash() },
                    {new Bar(), new Circle(), new Circle(),new Circle(),new Circle(), new Circle(),new Circle(),new Circle(), new Circle(),new Circle(),new Circle(), new Circle(),new Circle(), new Circle(), new Cross(), new Cross(), new Cross(),new Cross(),new Cross(),new Circle(),new Circle(),new Bar()},
                    {new Bar(),new Cross(), new Cross(),new Cross(),new Cross(), new Cross(),new Cross(),new Circle(),new Circle(),new Circle(),new Circle(),new Circle(),new Circle(),new Circle(),new Cross(),new Cross(),new Cross(), new Cross(),new Cross(),new Circle(),new Circle(), new Bar()},
                    {new Bar(),new Vacant(3,1), new Vacant(3,2),new Vacant(3,3),new Vacant(3,4), new Vacant(3,5),new Cross(),new Circle(), new Circle(),new Circle(),new Circle(),new Circle(),new Circle(),new Circle(),new Cross(),new Cross(), new Cross(), new Cross(),new Cross(),new Circle(), new Circle(),new Bar()},
                    {new Bar(),new Vacant(4,1), new Vacant(4,2),new Vacant(4,3),new Vacant(4,4), new Vacant(4,5),new Cross(), new Circle(), new Circle(),new Circle(), new Circle(), new Circle(),new Circle(),new Circle(), new Circle(),new Circle(), new Circle(),new Circle(), new Circle(),new Circle(), new Circle(), new Bar()},
                    {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash(), new Dash(), new Dash(),new Dash(), new Dash() },
            };
            Grid[][] grids = MyCanvas.getInstance().getGrids();

            RShortcut rShortcut = new RShortcut(14, 1, 18, 3);
            MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
            app.executeCommand();

            LShortcut lShortcut = new LShortcut(1, 2, 6, 2);
            app.shortcut=lShortcut;
            app.executeCommand();

            LShortcut llShortcut = new LShortcut(6, 3, 6, 4);
            app.shortcut=llShortcut;
            app.executeCommand();

            BShortcut bShortcut = new BShortcut(10, 3, Circle.class);
            app.shortcut=bShortcut;
            app.executeCommand();

            Grid[][] result = MyCanvas.getInstance().getGrids();
            String actual = render.displayGrids(result);
            String expected = render.displayGrids(expectedGrids);
            assertEquals(expected, actual);
        }
    }

}
