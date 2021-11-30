/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 *
 * @author nicol
 */
public class ThenRectangleOnCanvas extends Stage<ThenRectangleOnCanvas>{
    
    @ProvidedScenarioState
    @ExpectedScenarioState
    DefaultDrawingEditor editor;
    
    ThenRectangleOnCanvas rectangleIsOnCanvas(){
        Assert.assertTrue(editor.getActiveView().getDrawing().getChild(0) instanceof SVGRectFigure);
        return this;
    }
    
}
