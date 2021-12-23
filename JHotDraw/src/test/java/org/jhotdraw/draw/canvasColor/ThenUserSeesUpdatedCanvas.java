/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.canvasColor;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import java.awt.Rectangle;
import java.util.Collection;
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
public class ThenUserSeesUpdatedCanvas extends Stage<ThenUserSeesUpdatedCanvas>{
    
    private DrawingEditor canvas; 
    private Drawing drawing;
    Collection<Figure> findFigures;


    @BeforeStage
    private void before() {
    findFigures = canvas.getActiveView()
                .findFigures(new Rectangle(0, 0, 1000, 1000));
    }
    
    ThenUserSeesUpdatedCanvas theUserCanEditTheCanvas() { 
    Assert.assertFalse(findFigures.isEmpty());
    return this; 
}
}