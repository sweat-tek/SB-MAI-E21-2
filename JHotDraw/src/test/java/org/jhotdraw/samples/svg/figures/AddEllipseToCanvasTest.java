package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.samples.svg.figures.given.GivenEmptyCanvas;
import org.jhotdraw.samples.svg.figures.then.ThenEllipseOnCanvas;
import org.jhotdraw.samples.svg.figures.when.WhenAddingEllipses;
import org.junit.Test;

public class AddEllipseToCanvasTest extends ScenarioTest<GivenEmptyCanvas, WhenAddingEllipses, ThenEllipseOnCanvas> {

    @Test
    public void addingRectangleToEmptyCanvas(){
        given().anEmptyCanvas();
        when().addingFiguresToCanvas();
        then().figureIsOnCanvas();
    }

}
