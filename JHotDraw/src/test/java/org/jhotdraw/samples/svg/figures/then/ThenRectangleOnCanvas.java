package org.jhotdraw.samples.svg.figures.then;

import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

/**
 * @author nicol
 */
public class ThenRectangleOnCanvas extends ThenFigureOnCanvas {

    @Override
    boolean onCanvas(DefaultDrawingEditor editor) {
        return editor.getActiveView().getDrawing().getChild(0) instanceof SVGRectFigure;
    }
}
