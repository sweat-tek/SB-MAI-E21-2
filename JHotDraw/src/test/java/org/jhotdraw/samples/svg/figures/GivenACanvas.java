package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.action.*;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.io.File;
import java.net.URL;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

class GivenACanvas extends Stage<GivenACanvas> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
      
    }

    GivenACanvas aCanvas() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
        return this;
    }
}
