package org.jhotdraw.util;

import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.FigureDraw;
import org.jhotdraw.geom.Dimension2DDouble;

import java.awt.*;

import static org.jhotdraw.draw.AttributeKeys.*;

public class DrawHelper {

    public static void draw(Figure figure, FigureDraw drawer, Graphics2D g) {
        if (AttributeKeys.FILL_COLOR.get(figure) != null) {
            g.setColor(AttributeKeys.FILL_COLOR.get(figure));
            drawer.drawFill(g);
        }

        Color strokeColor = STROKE_COLOR.get(figure);
        if (strokeColor != null && STROKE_WIDTH.get(figure) > 0d) {
            g.setStroke(AttributeKeys.getStroke(figure));
            g.setColor(strokeColor);
            drawer.drawStroke(g);
        }

        Color textColor = TEXT_COLOR.get(figure);
        if (textColor == null) return;

        Color textShadowColor = TEXT_SHADOW_COLOR.get(figure);
        AttributeKey<Dimension2DDouble> textShadowOffset = TEXT_SHADOW_OFFSET;

        if (textShadowColor != null && textShadowOffset.get(figure) != null) {
            Dimension2DDouble d = textShadowOffset.get(figure);
            g.translate(d.width, d.height);
            g.setColor(textShadowColor);
            drawer.drawText(g);
            g.translate(-d.width, -d.height);
        }

        g.setColor(textColor);
        drawer.drawText(g);
    }

}
