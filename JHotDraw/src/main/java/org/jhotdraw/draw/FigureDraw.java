package org.jhotdraw.draw;


import java.awt.*;

public interface FigureDraw {

    /**
     * This method is called by method draw() to draw the fill
     * area of the figure. AttributedFigure configures the Graphics2D
     * object with the FILL_COLOR attribute before calling this method.
     * If the FILL_COLOR attribute is null, this method is not called.
     */
    void drawFill(Graphics2D g);

    /**
     * This method is called by method draw() to draw the lines of the figure
     *. AttributedFigure configures the Graphics2D object with
     * the STROKE_COLOR attribute before calling this method.
     * If the STROKE_COLOR attribute is null, this method is not called.
     */
    /**
     * This method is called by method draw() to draw the text of the figure
     *. AttributedFigure configures the Graphics2D object with
     * the TEXT_COLOR attribute before calling this method.
     * If the TEXT_COLOR attribute is null, this method is not called.
     */
    void drawStroke(Graphics2D g);

    default void drawText(Graphics2D g){}

}
