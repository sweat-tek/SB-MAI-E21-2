package org.jhotdraw.draw.DeleteTests;

import org.jhotdraw.draw.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DeleteEventTest {

    private DefaultDrawingView defaultDrawingView;
    private DrawingEditor editor;

    @Before
    public void setUp(){
        editor = new DefaultDrawingEditor();
        defaultDrawingView = new DefaultDrawingView();
        defaultDrawingView.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(defaultDrawingView);
    }

    private void selectFigures() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().addToSelection(f2);
        editor.getActiveView().addToSelection(f3);
    }

    @Test
    public void sendDeleteEventShouldDeleteFigures(){
        selectFigures();

        // Assert that we have 3 figures in the drawing
        assertEquals(3, editor.getActiveView().getDrawing().getChildCount());

        DeleteEvent deleteEvent = new DeleteEvent();
        deleteEvent.sendDeleteEvent(defaultDrawingView);

        // Assert that after deleteEvent that the figures have been deleted
        assertEquals(0, editor.getActiveView().getDrawing().getChildCount());
    }
}
