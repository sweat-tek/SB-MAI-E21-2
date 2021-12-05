package org.jhotdraw.undo;

import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;

public class GivenAEllipse extends GivenAFigure {
    @Override
    Figure getFigure() {
        return new SVGEllipseFigure(50, 50, 50, 100);
    }
}
