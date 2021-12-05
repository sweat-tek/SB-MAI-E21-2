package org.jhotdraw.samples.svg.figures.then;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGFigure;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThenImageIsOnCanvas extends Stage<ThenImageIsOnCanvas> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private SVGImageFigure imageFigure;

    public ThenImageIsOnCanvas imageIsOnCanvas() {

        assertCanvasContains(imageFigure, editor.getActiveView().getDrawing().getChildren());
        return this;
    }

    private void assertCanvasContains(Figure figure, List<Figure> canvasFigures) {
        assertTrue(figure instanceof SVGFigure);

        for (Figure actualFigure : canvasFigures) {
            System.out.println(actualFigure);
            if (actualFigure == figure) {
                assertEquals(actualFigure, figure);
            }
        }


    }
}
