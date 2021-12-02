package org.jhotdraw.copy;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.*;
import org.junit.Assert;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThenFigureInClipboard extends Stage<ThenFigureInClipboard> {
    @ExpectedScenarioState
    private DrawingEditor editor;

    private Figure copiedFigure;

    @BeforeStage
    private void before() {
        Set<Figure> selectedFigures = editor.getActiveView().getSelectedFigures();

        if (!selectedFigures.isEmpty()) {
            copiedFigure = selectedFigures.iterator().next();
        }
    }

    ThenFigureInClipboard theSelectedFigureShouldBeInMyClipboard() {
        DrawingView drawingView = editor.getActiveView();
        DefaultDrawingView component = (DefaultDrawingView) drawingView.getComponent();
        Toolkit toolkit = component.getToolkit();
        Clipboard systemClipboard = toolkit.getSystemClipboard();

        AssertTransferHandler transferHandler = new AssertTransferHandler();

        Transferable transferable = systemClipboard.getContents(component);

        transferHandler.importData(
                component,
                transferable
        );

        Figure[] importedFigures = transferHandler.transferFigures.toArray(new Figure[0]);
        Assert.assertEquals("Only one figure (of the same class as the figure) should be imported" ,
                1, importedFigures.length);

        Figure importedFigure = importedFigures[0];
        Assert.assertNotSame("Should not be the same instance", copiedFigure, importedFigure);
        Assert.assertTrue("Should be identical (have same values and class)", isEqual(copiedFigure, importedFigure));

        return this;
    }

    /**
     * Used to retrieve the data from the clipboard and read it as an instance of a figure.
     */
    class AssertTransferHandler extends TransferHandler {
        public final HashSet<Figure> transferFigures = new HashSet<>();

        public boolean importData(JComponent comp, Transferable t) {
            final DrawingView view = (DrawingView) comp;
            final Drawing drawing = view.getDrawing();

            boolean returnValue = false;

            List<InputFormat> inputFormats = drawing.getInputFormats();
            for (InputFormat format : inputFormats) {
                DataFlavor[] transferDataFlavors = t.getTransferDataFlavors();
                for (DataFlavor flavor : transferDataFlavors) {

                    if (format.isDataFlavorSupported(flavor)) {

                        LinkedList<Figure> existingFigures = new LinkedList<>(drawing.getChildren());
                        try {
                            format.read(t, drawing, false);
                        } catch (UnsupportedFlavorException | IOException e) {
                            e.printStackTrace();
                        }
                        final LinkedList<Figure> importedFigures = new LinkedList<>(drawing.getChildren());
                        importedFigures.removeAll(existingFigures);

                        if (importedFigures.size() > 0 && importedFigures.get(0).getClass() == copiedFigure.getClass()) {
                            transferFigures.addAll(importedFigures);        // We found a figure!
                        }

                        returnValue = true;
                    }
                }
            }

            return returnValue;
        }
    }

    /**
     * Made as a distinct function because overwriting the equals function alters the behaviour of methods that uses said
     * function.
     *
     * This function should be expanded further to be sure that the objects are identical and nothing has been lost
     * between being copied.
     * @param fig1 First figure to compare.
     * @param fig2 Figure to compare with figure 1.
     * @return True if the figures are identical. Otherwise, false.
     */
    public boolean isEqual(Figure fig1, Figure fig2) {
        if (fig1 == null || fig2 == null) return false;
        if (fig1.getClass() != fig2.getClass()) return false;

        return true;
    }

}
