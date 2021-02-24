package com.example.graph.command;

public class QuitCommand extends Command{
    @Override
    public void execute() {
        System.out.println("goodbye...");
        return;
    }
}
