/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;

/**
 *
 * @author nicol
 */
public class WhenAddingRectangleWithCoordinates extends Stage<WhenAddingRectangleWithCoordinates>{
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    DefaultDrawingEditor editor;
    
    WhenAddingRectangleWithCoordinates addingRectangleToCanvas(){
        SVGRectFigure rectangle = new SVGRectFigure();
        editor.getActiveView().getDrawing().add(rectangle);
        return this;
    }
    
}
