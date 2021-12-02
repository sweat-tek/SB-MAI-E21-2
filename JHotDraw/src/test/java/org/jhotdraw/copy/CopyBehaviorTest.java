package org.jhotdraw.copy;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class CopyBehaviorTest extends ScenarioTest<GivenSelectedFigure, WhenCopying, ThenFigureInClipboard> {

    // Turned off as it fails during the CI pipeline due to the lack of a GUI on the runner
    // @Test
    public void selectingSimpleFiguresAndCopyingThemResultsInJustThoseFiguresInTheClipboard() {
        given().aSelectedFigure();

        when().iCopy();

        then().theSelectedFigureShouldBeInMyClipboard();
    }
}
