package org.jhotdraw.undo;

import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

/**
 * @author William
 */
public class GivenARectangle extends GivenAFigure {

    @Override
    Figure getFigure() {
        return new SVGRectFigure(10, 10, 10, 10, 10, 10);
    }
}
