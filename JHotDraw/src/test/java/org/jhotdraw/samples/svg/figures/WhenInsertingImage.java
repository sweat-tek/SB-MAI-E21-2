package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.action.*;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;

public class WhenInsertingImage extends Stage<WhenInsertingImage> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @ProvidedScenarioState
    private SVGImageFigure imageFigure;

    
    
    @BeforeStage
    public void before() {
        
    }

    WhenInsertingImage insertingAnImage() throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("coolCat.jpeg");
        File image = new File(url.getPath());
        imageFigure = new SVGImageFigure(0,0,0,0);
        imageFigure.loadImage(image);
        
        editor.getActiveView().getDrawing().add(imageFigure);
        
        
        return this;
    }
}
