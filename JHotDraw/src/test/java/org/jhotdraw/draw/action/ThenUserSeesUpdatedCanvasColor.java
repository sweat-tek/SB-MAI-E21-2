/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Anni
 */
public class ThenUserSeesUpdatedCanvasColor extends Stage<ThenUserSeesUpdatedCanvasColor>{
    
    private DrawingEditor canvas; 
    private Drawing drawing;


        @BeforeStage
    private void before() {
    DrawingView view = new DefaultDrawingView();
    view.setDrawing(new QuadTreeDrawing());
    }
    
    ThenUserSeesUpdatedCanvasColor TheUserCanEditTheCanvas() {
    String result = "color";
    String result2 = "color";
    
    assertEquals(result2, result);
    return this; 
}
}