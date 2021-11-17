package org.jhotdraw.draw;

import org.junit.*;
import static org.junit.Assert.*;

public class DeleteEventTest {

    private DefaultDrawingView defaultDrawingView;
    private DrawingEditor editor;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp(){
        editor = new DefaultDrawingEditor();
        defaultDrawingView = new DefaultDrawingView();
        defaultDrawingView.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(defaultDrawingView);
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @After
    public void tearDown() {

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

        // Assert that we have selected 3 figures
        assertEquals(3, editor.getActiveView().getDrawing().getChildCount());

        DeleteEvent deleteEvent = new DeleteEvent();
        deleteEvent.sendDeleteEvent(defaultDrawingView);

        // Assert that after deleteEvent that the figures have been deleted
        assertEquals(0, editor.getActiveView().getDrawing().getChildCount());
    }
}
