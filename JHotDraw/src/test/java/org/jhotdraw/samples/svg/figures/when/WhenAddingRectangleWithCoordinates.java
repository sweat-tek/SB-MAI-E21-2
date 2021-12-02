package org.jhotdraw.samples.svg.figures.when;

import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

/**
 * @author nicol
 */
public class WhenAddingRectangleWithCoordinates extends WhenAddingFigures {

    @Override
    Figure getFigure() {
        return new SVGRectFigure();
    }

}
