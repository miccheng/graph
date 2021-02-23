package com.example.graph.command;

import com.example.graph.client.MyCanvas;

public abstract class Command {
    public MyCanvas canvas=null;

    public abstract void execute();
}
