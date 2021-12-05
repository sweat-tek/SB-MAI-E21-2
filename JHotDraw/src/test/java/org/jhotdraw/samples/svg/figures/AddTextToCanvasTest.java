package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.samples.svg.figures.given.GivenEmptyCanvas;
import org.jhotdraw.samples.svg.figures.then.ThenTextIsOnCanvas;
import org.jhotdraw.samples.svg.figures.when.WhenAddingText;
import org.junit.Test;

public class AddTextToCanvasTest extends ScenarioTest<GivenEmptyCanvas, WhenAddingText, ThenTextIsOnCanvas> {

    @Test
    public void addingRectangleToEmptyCanvas(){
        given().anEmptyCanvas();
        when().addingFiguresToCanvas();
        then().figureIsOnCanvas();
    }

}
