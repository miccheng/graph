package com.example.graph.client;


import com.example.graph.command.*;
import com.example.graph.command.*;
import com.example.graph.shortcut.*;

public class ActionVisitor {

    public BucketFillCommand visit(BShortcut shortcut) {
        return new BucketFillCommand(shortcut.getCoordinates(), ((BShortcut) shortcut).getFillShape());
    }

    public CanvasCommand visit(CShortcut shortcut) {
        return new CanvasCommand(shortcut.getCoordinates());
    }

    public LineCommand visit(LShortcut shortcut) {
        return new LineCommand(shortcut.getCoordinates());
    }

    public RectangleCommand visit(RShortcut shortcut) {
        return new RectangleCommand(shortcut.getCoordinates());
    }

    public QuitCommand visit(QShortcut shortcut) {
        return new QuitCommand();
    }

}
