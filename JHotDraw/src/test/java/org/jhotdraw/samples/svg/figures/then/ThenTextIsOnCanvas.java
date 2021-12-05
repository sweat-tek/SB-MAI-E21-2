package org.jhotdraw.samples.svg.figures.then;

import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

public class ThenTextIsOnCanvas extends ThenFigureOnCanvas{
    @Override
    boolean onCanvas(DefaultDrawingEditor editor) {
        SVGTextFigure text = (SVGTextFigure) editor.getActiveView().getDrawing().getChild(0);
        return text.getText().equals("test");
    }
}
