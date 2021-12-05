package org.jhotdraw.samples.svg.figures.when;

import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

public class WhenAddingText extends WhenAddingFigures {
    @Override
    Figure getFigure() {
        return new SVGTextFigure("test");
    }
}
