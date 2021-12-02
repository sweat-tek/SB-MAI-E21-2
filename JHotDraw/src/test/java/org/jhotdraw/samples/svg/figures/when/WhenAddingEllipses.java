package org.jhotdraw.samples.svg.figures.when;

import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;

public class WhenAddingEllipses extends WhenAddingFigures {
    @Override
    Figure getFigure() {
        return new SVGEllipseFigure(50, 50, 100, 50);
    }
}
