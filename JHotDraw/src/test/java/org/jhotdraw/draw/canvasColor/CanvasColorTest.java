/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.canvasColor;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 */
public class CanvasColorTest extends ScenarioTest<GivenCanvas, WhenCanvasChangeColor, ThenUserSeesUpdatedCanvasColor> {
    
        @Test
        public void changingCanvasColor() {
        given().drawingTheCanvas();
        when().AUserChangesCanvasColor();
        then().TheUserCanEditTheCanvas();
    }
}
