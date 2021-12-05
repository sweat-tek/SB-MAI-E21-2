/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.canvasColor;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;

/**
 *
 */
public class GivenCanvas extends Stage<GivenCanvas> {
            @ProvidedScenarioState
    private DrawingEditor canvas;
    
            @BeforeStage
    private void before() {
    canvas = new DefaultDrawingEditor();
    DrawingView view = new DefaultDrawingView();
    view.setDrawing(new QuadTreeDrawing());
    canvas.setActiveView(view);
    }
    
    GivenCanvas Drawing_View() {
        canvas.getActiveView();
        return this;
} 
}