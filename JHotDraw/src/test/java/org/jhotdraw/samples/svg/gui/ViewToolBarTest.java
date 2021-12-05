package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.draw.DefaultDrawingView;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class ViewToolBarTest {

    @Test
    public void validateCreatingOfAlignGrid(){
        ViewToolBar viewToolBar = new ViewToolBar();
        DefaultDrawingView view = new DefaultDrawingView();
        viewToolBar.setView(view);
        JComponent disclosedComponent = viewToolBar.createDisclosedComponent(1);

        for (Component component: disclosedComponent.getComponents()) {
            if(component.getName().equals("alignGrid")){
               Assert.assertTrue(true);
               return;
              }
        }
        Assert.fail();
    }

}
