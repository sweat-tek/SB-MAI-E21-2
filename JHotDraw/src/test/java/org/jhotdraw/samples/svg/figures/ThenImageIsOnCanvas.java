package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.action.*;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class ThenImageIsOnCanvas extends Stage<ThenImageIsOnCanvas> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private SVGImageFigure imageFigure;

    ThenImageIsOnCanvas imageIsOnCanvas() {
        
        assertCanvasContains(imageFigure, editor.getActiveView().getDrawing().getChildren());
        return this;
    }

    private void assertCanvasContains(Figure figure, List<Figure> canvasFigures) {
        assertTrue(figure instanceof SVGFigure);
        
        for (Figure actualFigure : canvasFigures) {
            System.out.println(actualFigure);
            if (actualFigure == figure) {
                assertEquals(actualFigure,figure);
            }
        }
        
        
    }
}
