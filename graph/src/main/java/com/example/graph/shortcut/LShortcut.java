package com.example.graph.shortcut;

import com.example.graph.client.ActionVisitor;
import com.example.graph.command.Command;
import com.example.graph.command.LineCommand;

public class LShortcut extends Shortcut{
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public LShortcut(int x1, int y1, int x2, int y2) throws Exception {
        if((x1==x2&&y1!=y2) || (x1!=x2&&y1==y2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            return;
        }
        throw new Exception("can't create the line you want");
    }

    @Override
    public int[] getCoordinates() {
        return new int[]{x1,y1,x2,y2};
    }

    @Override
    public LineCommand accept(ActionVisitor actionVisitor) {
        return actionVisitor.visit(this);
    }
}
