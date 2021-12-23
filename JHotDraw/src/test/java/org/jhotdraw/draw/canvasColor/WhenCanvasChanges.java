/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.canvasColor;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Rectangle;
import java.util.Collection;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class WhenCanvasChanges extends Stage<WhenCanvasChanges> {
    
    @ProvidedScenarioState
    private DrawingEditor canvas; 
    private Drawing drawing;
    
    private Figure figure = new SVGRectFigure(9,9,9,9);
    
    @BeforeStage
    public void before() {
    }

    WhenCanvasChanges aUserChangesCanvas() {
    canvas.getActiveView().getDrawing().add(figure);
        return this;
}    
}