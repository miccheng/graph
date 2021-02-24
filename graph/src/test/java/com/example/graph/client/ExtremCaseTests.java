package com.example.graph.client;

import com.example.graph.shortcut.QShortcut;
import com.example.graph.shortcut.RShortcut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtremCaseTests {

    //1. when it draws, it is out of canvas

    //2. when it draws, it hits the landmine

    //3.error in input args

    
    //4. Quit
    @Test
    public void testQuit(){
        QShortcut qShortcut = new QShortcut();
        MyGraphics2DApp app = new MyGraphics2DApp(qShortcut);
        app.executeCommand();
    }
}
