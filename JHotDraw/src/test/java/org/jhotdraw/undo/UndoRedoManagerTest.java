/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.swing.Action;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.draw.AttributeKey;
import static org.jhotdraw.draw.AttributeKeys.TRANSFORM;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author William
 */
public class UndoRedoManagerTest extends ScenarioTest<GivenARectangle, WhenUndo, ThenUndo>{
    
    private DrawingEditor editor;
    private UndoRedoManager instance = new UndoRedoManager();
    
    public UndoRedoManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new UndoRedoManager();
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of undo method, of class UndoRedoManager.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        Figure f1 = new SVGRectFigure(100, 100, 100, 100, 5 , 5);
        editor.getActiveView().getDrawing().add(f1);
        Collection<Figure> findFigures = editor.getActiveView()
                .findFigures(new Rectangle(0, 0, 1000, 1000));
        
        //Assures that the figure is on the canvas.
        Assert.assertTrue(findFigures.contains(f1));
        
        //When the undo-method serves as a blackbox which collects data to 
        //eventually call the remove-method on the drawing.
        editor.getActiveView().getDrawing().remove(f1);
        
        findFigures = editor.getActiveView()
                .findFigures(new Rectangle(0, 0, 1000, 1000));
        
        //Checks if the figure has been removed from the canvas.
        Assert.assertTrue(findFigures.isEmpty());
    }
    
    @Test
    public void undoAcceptanceTest(){
        given().aRectangle();
        
        when().i_undo_my_action();
        
        then().the_rectangle_should_be_gone();
    }

    
}
