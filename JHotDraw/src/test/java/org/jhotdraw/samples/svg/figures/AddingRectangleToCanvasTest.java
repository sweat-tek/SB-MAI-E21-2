/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import org.junit.Test;
import com.tngtech.jgiven.junit.ScenarioTest;

/**
 *
 * @author nicol
 */
public class AddingRectangleToCanvasTest extends ScenarioTest<GivenEmptyCanvas, WhenAddingRectangleWithCoordinates, ThenRectangleOnCanvas>{
    
    @Test
    public void addingRectangleToEmptyCanvas(){
        given().anEmptyCanvas();
        when().addingRectangleToCanvas();
        then().rectangleIsOnCanvas();
    }
    
}
