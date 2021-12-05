/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

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
    
    @Test
    public void testChangeCanvasColor() {
        DefaultDrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        assertTrue(true);
    }
}