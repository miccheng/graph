package com.example.graph.client;

import com.example.graph.command.Command;
import com.example.graph.shortcut.Shortcut;

public class MyGraphics2DApp {
    public Shortcut shortcut;
    public Command command;

    public PreChecker checker;

    public MyGraphics2DApp(Shortcut shortcut) {
        this.shortcut = shortcut;
        this.checker = new PreChecker();
    }

    public void executeCommand() {
        if (checker.check(shortcut.getCoordinates())) {
            mapCommand();
            command.execute();
        }
    }


    private void mapCommand() {
        this.command=shortcut.accept(new ActionVisitor());
    }
}
