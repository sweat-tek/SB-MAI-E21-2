package org.jhotdraw.samples.svg.figures.then;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.junit.Assert;

public abstract class ThenFigureOnCanvas extends Stage<ThenFigureOnCanvas> {

    @ProvidedScenarioState
    @ExpectedScenarioState
    DefaultDrawingEditor editor;

    public ThenFigureOnCanvas figureIsOnCanvas() {
        boolean onCanvas = onCanvas(editor);
        Assert.assertTrue(onCanvas);
        return this;
    }

    abstract boolean onCanvas(DefaultDrawingEditor editor);
}