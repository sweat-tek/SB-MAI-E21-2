/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author benjamin
 */
public class SVGImageFigureTest extends ScenarioTest<GivenACanvas, WhenInsertingImage, ThenImageIsOnCanvas> {
    
    SVGImageFigure testImage1;
    SVGImageFigure testImage2;
    
    public SVGImageFigureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.testImage1 = new SVGImageFigure(200, 200, 200, 200);
        this.testImage2 = new SVGImageFigure(500, 500, 500, 500);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testImage() {
        
        SVGImageFigure cloneImg = testImage1.clone();
        
        assertNotSame(testImage1, cloneImg);
        
        assertEquals(cloneImg.getX(), testImage1.getX(), 0.0);
        assertEquals(cloneImg.getY(), testImage1.getY(), 0.0);
        assertEquals(cloneImg.getHeight(), testImage1.getHeight(), 0.0);
        assertEquals(cloneImg.getWidth(), testImage1.getWidth(), 0.0);
    }
    
    @Test
    public void testImageLoad() throws IOException {
        
        URL url = Thread.currentThread().getContextClassLoader().getResource("coolCat.jpeg");
        
        File file = new File(url.getPath());
        
        testImage2.loadImage(file);
        assertNotNull(testImage2.getBufferedImage());
    }
    
    @Test
    public void acceptanceTest() throws IOException {
        given().aCanvas();
        
        when().insertingAnImage();
        
        then().imageIsOnCanvas();
    }
}
