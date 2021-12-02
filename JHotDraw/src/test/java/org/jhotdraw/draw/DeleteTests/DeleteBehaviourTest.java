package org.jhotdraw.draw.DeleteTests;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class DeleteBehaviourTest extends ScenarioTest<GivenFigures, WhenDeleting, ThenFiguresDeleted> {

    @Test
    public void selectingSimpleFiguresAndDeletingThemResultsInJustThoseFiguresBeingDeleted() {
        given().someSelectedBezierFigures()
                .and().someUnselectedBezierFigures();

        when().deletingFigures();

        then().onlySelectedFiguresAreDeleted();
    }

    @Test
    public void selectingGroupFiguresAndDeletingThemResultsInJustThoseFiguresBeingDeleted() {
        given().aSelectedGroupFigure()
                .and().aSelectedGroupFigure();

        when().deletingFigures();

        then().onlySelectedFiguresAreDeleted();
    }

    @Test
    public void selectingAllSimpleFiguresInTheDrawingAndDeletingThemResultsInAllFiguresBeingDeleted() {
        given().someSelectedBezierFigures();

        when().deletingFigures();

        then().noFiguresLeftInTheView();
    }
}
