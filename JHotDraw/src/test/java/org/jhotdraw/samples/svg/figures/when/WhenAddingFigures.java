package org.jhotdraw.samples.svg.figures.when;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.Figure;

public abstract class WhenAddingFigures extends Stage<WhenAddingRectangleWithCoordinates> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    DefaultDrawingEditor editor;

    public WhenAddingFigures addingFiguresToCanvas(){
        Figure rectangle = getFigure();
        editor.getActiveView().getDrawing().add(rectangle);
        return this;
    }

    abstract Figure getFigure();

}
