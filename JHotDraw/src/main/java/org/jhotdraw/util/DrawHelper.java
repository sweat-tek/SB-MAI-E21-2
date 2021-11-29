package org.jhotdraw.util;

import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.FigureDraw;
import org.jhotdraw.geom.Dimension2DDouble;

import java.awt.*;

import static org.jhotdraw.draw.AttributeKeys.*;
import static org.jhotdraw.draw.AttributeKeys.TEXT_COLOR;

public class DrawHelper {

    public static void draw(Figure figure, FigureDraw drawer, Graphics2D g) {
        if (AttributeKeys.FILL_COLOR.get(figure) != null) {
            g.setColor(AttributeKeys.FILL_COLOR.get(figure));
            drawer.drawFill(g);
        }
        if (STROKE_COLOR.get(figure) != null && STROKE_WIDTH.get(figure) > 0d) {
            g.setStroke(AttributeKeys.getStroke(figure));
            g.setColor(STROKE_COLOR.get(figure));

            drawer.drawStroke(g);
        }
        if (TEXT_COLOR.get(figure) != null) {
            if (TEXT_SHADOW_COLOR.get(figure) != null &&
                    TEXT_SHADOW_OFFSET.get(figure) != null) {
                Dimension2DDouble d = TEXT_SHADOW_OFFSET.get(figure);
                g.translate(d.width, d.height);
                g.setColor(TEXT_SHADOW_COLOR.get(figure));
                drawer.drawText(g);
                g.translate(-d.width,-d.height);
            }
            g.setColor(TEXT_COLOR.get(figure));
            drawer.drawText(g);
        }
    }

}
