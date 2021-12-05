package org.jhotdraw.samples.svg;

import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class SVGAttributeKeysTest {

    @Test
    public void canGetFillPaint() {
        SVGRectFigure figure = new SVGRectFigure(20, 10, 10, 10);
        Paint paint = SVGAttributeKeys.getFillPaint(figure);
        Assert.assertEquals(Color.BLACK, paint);
    }

    @Test
    public void canGetStrokePaint() {
        SVGRectFigure figure = new SVGRectFigure();
        Paint paint = SVGAttributeKeys.getStrokePaint(figure);
        Assert.assertNull(paint);
    }
}
