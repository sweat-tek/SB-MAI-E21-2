/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.canvasColor;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Rectangle;
import java.util.Collection;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 */
public class CanvasChangeTest extends ScenarioTest<GivenCanvas, WhenCanvasChanges, ThenUserSeesUpdatedCanvas> {

    private DrawingEditor canvas;

    public CanvasChangeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        canvas = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        canvas.setActiveView(view);
    }

    @Test
    public void testCanvasChange() {
        //Creating a figure
        Figure figure = new SVGRectFigure(9,9,9,9);
        //Adding the figure to the canvas
        canvas.getActiveView().getDrawing().add(figure);
        //finding the figures in the canvas
        Collection<Figure> findFigures = canvas.getActiveView().findFigures(new Rectangle(9,9,9,9));
        //Asserting that the figure is found on the canvas
        assertTrue(findFigures.contains(figure));
    }

    @Test
    public void changingCanvasAcceptanceTest() {
        given().drawingTheCanvas();
        when().aUserChangesCanvas();
        then().theUserCanEditTheCanvas();
    }
}
