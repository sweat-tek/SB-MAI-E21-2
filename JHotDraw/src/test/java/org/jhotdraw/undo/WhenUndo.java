/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Rectangle;
import java.util.Collection;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;

/**
 *
 * @author William
 */
public class WhenUndo extends Stage<WhenUndo>{
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    private Figure f1;
    
    @BeforeStage
    public void before(){
        Collection<Figure> findFigures = editor.getActiveView()
                .findFigures(new Rectangle(0, 0, 1000, 1000));
        f1 = findFigures.iterator().next();
    }
    
    WhenUndo i_undo_my_action() {
        editor.getActiveView().getDrawing().remove(f1);
        return this;
    }
    
}
