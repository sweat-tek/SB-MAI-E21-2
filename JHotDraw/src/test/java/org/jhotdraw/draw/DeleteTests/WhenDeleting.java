package org.jhotdraw.draw.DeleteTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DeleteEvent;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;

import java.util.HashSet;
import java.util.Set;

public class WhenDeleting extends Stage<WhenDeleting> {

    @ExpectedScenarioState
    private DefaultDrawingView view;

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private DeleteEvent deleteEvent;

    @ProvidedScenarioState
    private Set<Figure> nonselectedFigures;

    @ProvidedScenarioState
    private Set<Figure> selectedFigures;

    @BeforeStage
    public void before() {
        deleteEvent = new DeleteEvent();
        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());

        nonselectedFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());
        nonselectedFigures.removeAll(selectedFigures);
    }

    WhenDeleting deletingFigures() {
        deleteEvent.sendDeleteEvent(view);
        return this;
    }
}
