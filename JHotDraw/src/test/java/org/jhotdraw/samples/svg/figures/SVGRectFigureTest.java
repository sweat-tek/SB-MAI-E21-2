/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.jhotdraw.geom.Dimension2DDouble;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.Assert;
import com.tngtech.jgiven.junit.ScenarioTest;

/**
 *
 * @author nicol
 */
public class SVGRectFigureTest {

    public SVGRectFigure testFigure1, testFigure2;

    public SVGRectFigureTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.testFigure1 = new SVGRectFigure();
        this.testFigure2 = new SVGRectFigure(5.0, 10.0, 5.0, 5.0, 0, 0);
    }

    @After
    public void tearDown() {
    }

    /*
    Test for the setBoundry method of a rectangle, which is used for adjusting the width/height of the figure
     */
    @Test
    public void testSetBoundry() {
        Point2D.Double anchor = new Point2D.Double(5.0, 5.0);
        Point2D.Double lead = new Point2D.Double(10.0, 10.0);
        double expectedWidth = 5.0;
        double expectedHeight = 5.0;

        testFigure1.setBounds(anchor, lead);

        System.out.println("Expected width: " + expectedWidth + " Actual width: " + testFigure1.getWidth() + "\n"
                + "Expected height: " + expectedHeight + " Actual height: " + testFigure1.getHeight());

        Assert.assertTrue(testFigure1.getWidth() == expectedWidth && testFigure1.getHeight() == expectedHeight);
    }

    /*
    Test for the clone method. This duplicates the figure, resulting in two identical figures.
     */
    @Test
    public void testClone() {
        SVGRectFigure clone = testFigure2.clone();
        //Test that the variables refers to different objects
        Assert.assertTrue(clone != testFigure2);
        //Test that the attributes of the objects are identical
        Assert.assertTrue("If true, attributes are identical",
                testFigure2.getX() == clone.getX()
                && testFigure2.getY() == clone.getY()
                && testFigure2.getHeight() == clone.getHeight()
                && testFigure2.getWidth() == clone.getWidth()
        );
    } 
    

}
