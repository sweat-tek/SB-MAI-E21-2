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
import org.junit.Assert;

/**
 *
 * @author William
 */
public class ThenUndo extends Stage<ThenUndo>{
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    Collection<Figure> findFigures;
    
    @BeforeStage
    public void before(){
        findFigures = editor.getActiveView()
                .findFigures(new Rectangle(0, 0, 1000, 1000));
    }
    
    ThenUndo the_rectangle_should_be_gone(){
        Assert.assertTrue(findFigures.isEmpty());
        return this;
    }
    
    
    
}
