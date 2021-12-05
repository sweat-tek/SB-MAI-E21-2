package org.jhotdraw.undo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;

public abstract class GivenAFigure  extends Stage<GivenAFigure> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    GivenAFigure aRectangle() {
        Figure f1 = getFigure();
        editor.getActiveView().getDrawing().add(f1);
        return this;
    }

    abstract Figure getFigure();
}
