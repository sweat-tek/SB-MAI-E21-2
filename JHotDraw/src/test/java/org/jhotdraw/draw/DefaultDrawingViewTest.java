/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.Set;
import javax.swing.JComponent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anni
 */
public class DefaultDrawingViewTest {
    
    public DefaultDrawingViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of repaintHandles method, of class DefaultDrawingView.
     */
    @Test
    public void testRepaintHandles() {
    }

    /**
     * Test of createEventHandler method, of class DefaultDrawingView.
     */
    @Test
    public void testCreateEventHandler() {
    }

    /**
     * Test of getDrawing method, of class DefaultDrawingView.
     */
    @Test
    public void testGetDrawing() {
    }

    /**
     * Test of getToolTipText method, of class DefaultDrawingView.
     */
    @Test
    public void testGetToolTipText() {
    }

    /**
     * Test of setEmptyDrawingMessage method, of class DefaultDrawingView.
     */
    @Test
    public void testSetEmptyDrawingMessage() {
    }

    /**
     * Test of getEmptyDrawingMessage method, of class DefaultDrawingView.
     */
    @Test
    public void testGetEmptyDrawingMessage() {
    }

    /**
     * Test of paintComponent method, of class DefaultDrawingView.
     */
    @Test
    public void testPaintComponent() {
         System.out.println("Speed");
         //drawDrawing(g);
         assertEquals(this, this);
    }

    /**
     * Test of printComponent method, of class DefaultDrawingView.
     */
    @Test
    public void testPrintComponent() {
         System.out.println("Quality");
    }

    /**
     * Test of setRenderingHint method, of class DefaultDrawingView.
     */
    @Test
    public void testSetRenderingHint() {
        System.out.println("Test shared");
    }

    /**
     * Test of drawBackground method, of class DefaultDrawingView.
     */
    @Test
    public void testDrawBackground() {
    }

    /**
     * Test of drawConstrainer method, of class DefaultDrawingView.
     */
    @Test
    public void testDrawConstrainer() {
    }

    /**
     * Test of drawDrawing method, of class DefaultDrawingView.
     */
    @Test
    public void testDrawDrawing() {
    }

    /**
     * Test of drawHandles method, of class DefaultDrawingView.
     */
    @Test
    public void testDrawHandles() {
    }

    /**
     * Test of drawTool method, of class DefaultDrawingView.
     */
    @Test
    public void testDrawTool() {
    }

    /**
     * Test of setDrawing method, of class DefaultDrawingView.
     */
    @Test
    public void testSetDrawing() {
    }

    /**
     * Test of repaintDrawingArea method, of class DefaultDrawingView.
     */
    @Test
    public void testRepaintDrawingArea() {
    }

    /**
     * Test of invalidate method, of class DefaultDrawingView.
     */
    @Test
    public void testInvalidate() {
    }

    /**
     * Test of addToSelection method, of class DefaultDrawingView.
     */
    @Test
    public void testAddToSelection_Figure() {
    }

    /**
     * Test of addToSelection method, of class DefaultDrawingView.
     */
    @Test
    public void testAddToSelection_Collection() {
    }

    /**
     * Test of removeFromSelection method, of class DefaultDrawingView.
     */
    @Test
    public void testRemoveFromSelection() {
    }

    /**
     * Test of toggleSelection method, of class DefaultDrawingView.
     */
    @Test
    public void testToggleSelection() {
    }

    /**
     * Test of setEnabled method, of class DefaultDrawingView.
     */
    @Test
    public void testSetEnabled() {
       
    }

    /**
     * Test of selectAll method, of class DefaultDrawingView.
     */
    @Test
    public void testSelectAll() {
    }

    /**
     * Test of clearSelection method, of class DefaultDrawingView.
     */
    @Test
    public void testClearSelection() {
    }

    /**
     * Test of isFigureSelected method, of class DefaultDrawingView.
     */
    @Test
    public void testIsFigureSelected() {
    }

    /**
     * Test of getSelectedFigures method, of class DefaultDrawingView.
     */
    @Test
    public void testGetSelectedFigures() {
    }

    /**
     * Test of getSelectionCount method, of class DefaultDrawingView.
     */
    @Test
    public void testGetSelectionCount() {
    }

    /**
     * Test of findHandle method, of class DefaultDrawingView.
     */
    @Test
    public void testFindHandle() {
    }

    /**
     * Test of getCompatibleHandles method, of class DefaultDrawingView.
     */
    @Test
    public void testGetCompatibleHandles() {
    }

    /**
     * Test of findFigure method, of class DefaultDrawingView.
     */
    @Test
    public void testFindFigure() {
    }

    /**
     * Test of findFigures method, of class DefaultDrawingView.
     */
    @Test
    public void testFindFigures() {
    }

    /**
     * Test of findFiguresWithin method, of class DefaultDrawingView.
     */
    @Test
    public void testFindFiguresWithin() {
    }

    /**
     * Test of addFigureSelectionListener method, of class DefaultDrawingView.
     */
    @Test
    public void testAddFigureSelectionListener() {
    }

    /**
     * Test of removeFigureSelectionListener method, of class DefaultDrawingView.
     */
    @Test
    public void testRemoveFigureSelectionListener() {
    }

    /**
     * Test of fireSelectionChanged method, of class DefaultDrawingView.
     */
    @Test
    public void testFireSelectionChanged() {
    }

    /**
     * Test of invalidateDimension method, of class DefaultDrawingView.
     */
    @Test
    public void testInvalidateDimension() {
    }

    /**
     * Test of getConstrainer method, of class DefaultDrawingView.
     */
    @Test
    public void testGetConstrainer() {
    }

    /**
     * Test of getPreferredSize method, of class DefaultDrawingView.
     */
    @Test
    public void testGetPreferredSize() {
    }

    /**
     * Test of getDrawingArea method, of class DefaultDrawingView.
     */
    @Test
    public void testGetDrawingArea() {
    }

    /**
     * Test of setBounds method, of class DefaultDrawingView.
     */
    @Test
    public void testSetBounds() {
         }

    /**
     * Test of drawingToView method, of class DefaultDrawingView.
     */
    @Test
    public void testDrawingToView_Point2DDouble() {
    }

    /**
     * Test of viewToDrawing method, of class DefaultDrawingView.
     */
    @Test
    public void testViewToDrawing_Point() {
    }

    /**
     * Test of drawingToView method, of class DefaultDrawingView.
     */
    @Test
    public void testDrawingToView_Rectangle2DDouble() {
    }

    /**
     * Test of viewToDrawing method, of class DefaultDrawingView.
     */
    @Test
    public void testViewToDrawing_Rectangle() {
    }

    /**
     * Test of getComponent method, of class DefaultDrawingView.
     */
    @Test
    public void testGetComponent() {
    }

    /**
     * Test of getScaleFactor method, of class DefaultDrawingView.
     */
    @Test
    public void testGetScaleFactor() {
    }

    /**
     * Test of setScaleFactor method, of class DefaultDrawingView.
     */
    @Test
    public void testSetScaleFactor() {
    }

    /**
     * Test of fireViewTransformChanged method, of class DefaultDrawingView.
     */
    @Test
    public void testFireViewTransformChanged() {
    }

    /**
     * Test of setHandleDetailLevel method, of class DefaultDrawingView.
     */
    @Test
    public void testSetHandleDetailLevel() {
    }

    /**
     * Test of getHandleDetailLevel method, of class DefaultDrawingView.
     */
    @Test
    public void testGetHandleDetailLevel() {
    }

    /**
     * Test of getDrawingToViewTransform method, of class DefaultDrawingView.
     */
    @Test
    public void testGetDrawingToViewTransform() {
    }

    /**
     * Test of delete method, of class DefaultDrawingView.
     */
    @Test
    public void testDelete() {
    }

    /**
     * Test of duplicate method, of class DefaultDrawingView.
     */
    @Test
    public void testDuplicate() {
    }

    /**
     * Test of removeNotify method, of class DefaultDrawingView.
     */
    @Test
    public void testRemoveNotify() {
    }

    /**
     * Test of addNotify method, of class DefaultDrawingView.
     */
    @Test
    public void testAddNotify() {
    }

    /**
     * Test of setVisibleConstrainer method, of class DefaultDrawingView.
     */
    @Test
    public void testSetVisibleConstrainer() {
    }

    /**
     * Test of getVisibleConstrainer method, of class DefaultDrawingView.
     */
    @Test
    public void testGetVisibleConstrainer() {
    }

    /**
     * Test of setInvisibleConstrainer method, of class DefaultDrawingView.
     */
    @Test
    public void testSetInvisibleConstrainer() {
    }

    /**
     * Test of getInvisibleConstrainer method, of class DefaultDrawingView.
     */
    @Test
    public void testGetInvisibleConstrainer() {
    }

    /**
     * Test of setConstrainerVisible method, of class DefaultDrawingView.
     */
    @Test
    public void testSetConstrainerVisible() {
    }

    /**
     * Test of isConstrainerVisible method, of class DefaultDrawingView.
     */
    @Test
    public void testIsConstrainerVisible() {
    }

    /**
     * Test of getBackgroundPaint method, of class DefaultDrawingView.
     */
    @Test
    public void testGetBackgroundPaint() {
    }

    /**
     * Test of getEditor method, of class DefaultDrawingView.
     */
    @Test
    public void testGetEditor() {
    }

    /**
     * Test of setActiveHandle method, of class DefaultDrawingView.
     */
    @Test
    public void testSetActiveHandle() {
    }

    /**
     * Test of getActiveHandle method, of class DefaultDrawingView.
     */
    @Test
    public void testGetActiveHandle() {
    }
    
}
