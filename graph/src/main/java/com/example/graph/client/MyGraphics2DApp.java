package com.example.graph.client;

import com.example.graph.command.*;
import com.example.graph.shortcut.*;

public class MyGraphics2DApp {
    public Shortcut shortcut;
    public Command command;

    public PreChecker checker;

    public MyGraphics2DApp(Shortcut shortcut) {
        this.shortcut = shortcut;
        this.checker=new PreChecker();
    }

    public void executeCommand() {
        if (checker.check(shortcut.getCoordinates())) {
            mapShortcut2Command();
            command.execute();
        }
    }

    private void mapShortcut2Command() {
        if (shortcut instanceof CShortcut) {
            this.command = new CanvasCommand(shortcut.getCoordinates());
        } else if (shortcut instanceof LShortcut) {
            this.command = new LineCommand(shortcut.getCoordinates());
        } else if (shortcut instanceof RShortcut) {
            this.command = new RectangleCommand(shortcut.getCoordinates());
        } else if (shortcut instanceof BShortcut) {
            this.command = new BucketFillCommand(shortcut.getCoordinates(), ((BShortcut) shortcut).getFillShape());
        } else if (shortcut instanceof QShortcut) {
            this.command = new QuitCommand();
        } else {
            System.out.println("Unknown operation: don't know what to do, therefore not to do anything");
            return;
        }

    }
}
