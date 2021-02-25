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
            String expected = "----------------------\n" +
                    "|oooooooooooooxxxxxoo|\n" +
                    "|xxxxxxoooooooxxxxxoo|\n" +
                    "|     xoooooooxxxxxoo|\n" +
                    "|     xoooooooooooooo|\n" +
                     "----------------------";

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
            assertEquals(expected, actual);
    }

}
