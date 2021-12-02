package org.jhotdraw.copy;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.app.action.CopyAction;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;

public class WhenCopying extends Stage<WhenCopying> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    private CopyAction copyAction;

    @BeforeStage
    public void before() {
        copyAction = new CopyAction();
    }

    WhenCopying iCopy() {
        DrawingView drawingView = editor.getActiveView();
        copyAction.copy(drawingView.getComponent());
        return this;
    }

}
