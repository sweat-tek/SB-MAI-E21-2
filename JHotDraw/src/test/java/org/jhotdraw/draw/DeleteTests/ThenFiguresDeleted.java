package org.jhotdraw.draw.DeleteTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ThenFiguresDeleted extends Stage<ThenFiguresDeleted> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private DefaultDrawingView view;

    @ExpectedScenarioState
    private Set<Figure> selectedFigures;

    @ExpectedScenarioState
    private Set<Figure> nonselectedFigures;

    ThenFiguresDeleted noFiguresLeftInTheView() {
        // Assert that there are 0 figures in the drawing since they should be deleted
        assertEquals(0, view.getDrawing().getChildCount());

        return this;
    }

    ThenFiguresDeleted onlySelectedFiguresAreDeleted() {
        //The originally non selected figures are the only figures in the view
        Set<Figure> expectedSelection = new HashSet<>(nonselectedFigures);

        assertFigureContains(editor.getActiveView().getDrawing(), expectedSelection);

        return this;
    }

    private void assertFigureContains(Figure group, Set<Figure> children) {
        assertTrue(group instanceof CompositeFigure);
        CompositeFigure composite = (CompositeFigure) group;
        assertEquals(children.size(), composite.getChildCount());

        for (Figure child : children) {
            assertTrue(composite.contains(child));
        }
    }
}
