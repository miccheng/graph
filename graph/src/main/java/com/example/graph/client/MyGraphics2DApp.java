package com.example.graph.client;

import com.example.graph.command.*;
import com.example.graph.shortcut.*;


public class MyGraphics2DApp {
public Shortcut shortcut;
public Command command;

    public MyGraphics2DApp(Shortcut shortcut) {
        this.shortcut = shortcut;
    }

    public void executeCommand(){
        mapShortcut2Command();
        command.execute();
    }

    private void mapShortcut2Command() {
        if(shortcut instanceof CShortcut) {
            this.command=new CanvasCommand(shortcut.getCoordinates());
        }else if (shortcut instanceof LShortcut){
            this.command=new LineCommand(shortcut.getCoordinates());
        } else if(shortcut instanceof RShortcut){
            this.command=new RectangleCommand(shortcut.getCoordinates());
        }else if(shortcut instanceof BShortcut){
           this.command=new BucketFillCommand(shortcut.getCoordinates(), ((BShortcut) shortcut).getFillShape());
        }
    }
}
