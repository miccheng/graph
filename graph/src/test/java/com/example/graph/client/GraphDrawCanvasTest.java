package com.example.graph.client;

import com.example.graph.model.Bar;
import com.example.graph.model.Dash;
import com.example.graph.model.Grid;
import com.example.graph.model.Vacant;
import com.example.graph.shortcut.CShortcut;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class GraphDrawCanvasTest {

    @Autowired
    GridRender render;

    @Test
    public void testCanvas() {
        Grid[][] expectedGrids = {
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash()},
                {new Bar(), new Vacant(1, 1), new Vacant(1, 2), new Vacant(1, 3), new Vacant(1, 4), new Vacant(1, 5), new Bar()},
                {new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash(), new Dash()}
        };
        CShortcut cShortcut = new CShortcut(5, 1);
        MyGraphics2DApp graphics2DApp = new MyGraphics2DApp(cShortcut);
        graphics2DApp.executeCommand();

        Grid[][] grids = MyCanvas.getInstance().getGrids();

        String actual = render.displayGrids(grids);
        String expected = render.displayGrids(expectedGrids);
        assertEquals(expected, actual);
    }

}
