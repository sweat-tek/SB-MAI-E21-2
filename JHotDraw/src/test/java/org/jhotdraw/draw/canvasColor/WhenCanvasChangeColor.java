/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.canvasColor;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Color;
import java.awt.Graphics2D;
import static org.jhotdraw.draw.AttributeKeys.CANVAS_FILL_COLOR;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class WhenCanvasChangeColor extends Stage<WhenCanvasChangeColor> {
        @ProvidedScenarioState
    private DrawingEditor canvas; 
    private Drawing drawing;
        
            @BeforeStage
    private void before() {
    canvas = new DefaultDrawingEditor();
    DrawingView view = new DefaultDrawingView();
    view.setDrawing(new QuadTreeDrawing());
    canvas.setActiveView(view);
    }

    public Drawing getDrawing() {
        return drawing;
    }
        
    WhenCanvasChangeColor aUserChangesCanvasColor() {
    Color canvasColor;
    //canvasColor = CANVAS_FILL_COLOR.get(drawing);
        return this;
}    
}