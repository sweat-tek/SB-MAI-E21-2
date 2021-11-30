package org.jhotdraw.copy;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class CopyBehaviorTest extends ScenarioTest<GivenSelectedFigure, WhenCopying, ThenFigureInClipboard> {

    @Test
    public void selectingSimpleFiguresAndCopyingThemResultsInJustThoseFiguresInTheClipboard() {
        given().aSelectedFigure();

        when().iCopy();

        then().theSelectedFigureShouldBeInMyClipboard();
    }
}
