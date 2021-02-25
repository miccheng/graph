package com.example.graph.client;

import com.example.graph.model.Circle;
import com.example.graph.model.Grid;
import com.example.graph.shortcut.BShortcut;
import com.example.graph.shortcut.LShortcut;
import com.example.graph.shortcut.QShortcut;
import com.example.graph.shortcut.RShortcut;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExtremeCaseTest {

    @Autowired
    GridRender render;


    @Before
    public void intiCanvas() {
        MyCanvas.initInstance(5,2);
    }

    //1. Quit program
    @Test
    public void test1Quit(){
        String expected = "-------\n" +
                "|     |\n" +
                "|     |\n" +
                "-------" ;

        QShortcut qShortcut = new QShortcut();
        MyGraphics2DApp app = new MyGraphics2DApp(qShortcut);
        app.executeCommand();

        Grid[][] gridsAfter = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(gridsAfter);
        assertEquals(expected,actual);
    }

    //2. when the coordinates are completely out of canvas. Expected nothing done on the canvas
    @Test
    public void test2OutOfCanvas(){
        String expected = "-------\n" +
                "|     |\n" +
                "|     |\n" +
                "-------" ;

        RShortcut rShortcut = new RShortcut(6,3,7,4);
        MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
        app.executeCommand();

        Grid[][] gridsAfter = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(gridsAfter);
        assertEquals(expected,actual);
    }

    //3. when it tries to draw, it overlaps the drawn area completely. Expect to draw nothing
    @Test
    public void test3GridTakenCompletely() throws Exception {
        String expected = "-------\n" +
                "| xx  |\n" +
                "| xx  |\n" +
                "-------" ;

        RShortcut rShortcut = new RShortcut(2,1,3,2);
        MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
        app.executeCommand();

        LShortcut lShortcut = new LShortcut(2,1,3,1);
        app.shortcut=lShortcut;
        app.executeCommand();

        LShortcut l2Shortcut = new LShortcut(2,1,2,3);
        app.shortcut=l2Shortcut;
        app.executeCommand();

        Grid[][] gridsAfter = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(gridsAfter);
        assertEquals(expected,actual);
    }

    //4.when it tries to draw, it (Line) overlaps the drawn area partially. It still draws
    @Test
    public void test4GridTakenPartiallyL() throws Exception {
        String expected = "-------\n" +
                "|xxxx |\n" +
                "| xx  |\n" +
                "-------" ;

        RShortcut rShortcut = new RShortcut(2,1,3,2);
        MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
        app.executeCommand();

        LShortcut lShortcut = new LShortcut(1,1,4,1);
        app.shortcut=lShortcut;
        app.executeCommand();


        Grid[][] gridsAfter = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(gridsAfter);
        assertEquals(expected,actual);
    }

    //5. when it tries to draw, it(Rectangle) overlaps the drawn area partially. It still draws
    @Test
    public void test5GridTakenPartiallyR() throws Exception {
        String expected = "-------\n" +
                "|xxxx |\n" +
                "|xxxx |\n" +
                "-------" ;

        RShortcut rShortcut = new RShortcut(2,1,3,2);
        MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
        app.executeCommand();

        RShortcut rrShortcut = new RShortcut(1,1,4,2);
        app.shortcut=rrShortcut;
        app.executeCommand();


        Grid[][] gridsAfter = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(gridsAfter);
        assertEquals(expected,actual);
    }

    //6. when it tries to bucket fill, the seed falls on drawn area. Expect to do nothing on bucket fill command.
    @Test
    public void test6BucketFillOverlapR() throws Exception {
        String expected = "-------\n" +
                "| xx  |\n" +
                "| xx  |\n" +
                "-------" ;

        RShortcut rShortcut = new RShortcut(2,1,3,2);
        MyGraphics2DApp app = new MyGraphics2DApp(rShortcut);
        app.executeCommand();

        BShortcut bShortcut = new BShortcut(2,1, Circle.class);
        app.shortcut=bShortcut;
        app.executeCommand();


        Grid[][] gridsAfter = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(gridsAfter);
        assertEquals(expected,actual);
    }

    @Test
    public void test7BucketFillOverlapL() throws Exception {
        String expected = "-------\n" +
                "| xxx |\n" +
                "|     |\n" +
                "-------" ;

        LShortcut lShortcut = new LShortcut(2,1,4,1);
        MyGraphics2DApp app = new MyGraphics2DApp(lShortcut);
        app.executeCommand();

        BShortcut bShortcut = new BShortcut(3,1, Circle.class);
        app.shortcut=bShortcut;
        app.executeCommand();


        Grid[][] gridsAfter = MyCanvas.getInstance().getGrids();
        String actual = render.displayGrids(gridsAfter);
        assertEquals(expected,actual);
    }


    @After
    public void resetCanvas() {
        MyCanvas.getInstance().resetGrids();
    }

}
