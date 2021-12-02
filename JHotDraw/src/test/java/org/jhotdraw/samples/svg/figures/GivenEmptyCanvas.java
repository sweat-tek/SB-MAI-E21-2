/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Canvas;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.junit.Test;

/**
 *
 * @author nicol
 */
public class GivenEmptyCanvas extends Stage<GivenEmptyCanvas>{
    
    @ProvidedScenarioState
    DefaultDrawingEditor editor;
    
    GivenEmptyCanvas anEmptyCanvas(){
        DrawingView drawingView = new DefaultDrawingView();
        editor = new DefaultDrawingEditor();
        drawingView.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(drawingView);
        return this;
    }
}
