package org.jhotdraw.samples.svg.figures.then;

import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;

public class ThenEllipseOnCanvas extends ThenFigureOnCanvas {

    @Override
    boolean onCanvas(DefaultDrawingEditor editor) {
        return editor
                .getActiveView()
                .getDrawing()
                .getChildren()
                .stream()
                .anyMatch(figure -> figure instanceof SVGEllipseFigure);
    }
}
