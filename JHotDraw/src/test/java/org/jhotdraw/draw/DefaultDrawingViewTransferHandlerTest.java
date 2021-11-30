package org.jhotdraw.draw;

import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
import org.jhotdraw.samples.svg.io.ImageMapOutputFormat;
import org.jhotdraw.samples.svg.io.SVGOutputFormat;
import org.jhotdraw.samples.svg.io.SVGZOutputFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.util.*;

public class DefaultDrawingViewTransferHandlerTest {

    private DefaultDrawingEditor editor;
    private DrawingView view;
    private DefaultDrawingViewTransferHandler transferHandler;

    @Before
    public void setUp() {
        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
        transferHandler = new DefaultDrawingViewTransferHandler();
    }

    @Test
    public void createTransferable() {

        // Add figure to drawing and select it
        Figure f1 = new SVGEllipseFigure();
        view.getDrawing().add(f1);
        view.addToSelection(f1);

        Set<Figure> selectedFigures = view.getSelectedFigures();

        // Should be null if it does not have output formats
        view.getDrawing().setOutputFormats(Collections.emptyList());    // Remove any output formats
        Transferable transferable = transferHandler.createTransferable(view, selectedFigures);
        Assert.assertNull("Transferable should be null it it doest not have output formats", transferable);

        // Should NOT be null if it does have output formats
        setupUpOutputFormats(view.getDrawing());    // Now fill it with output formats
        transferable = transferHandler.createTransferable(view, selectedFigures);
        Assert.assertNotNull("Transferable should NOT be null if it has output formats",
                transferable);

        // Should return null if there is no elements in the drawing
        transferable = transferHandler.createTransferable(view, Collections.emptySet());
        Assert.assertNull("Transferable should be null if there is no elements selected", transferable);

        transferable = transferHandler.createTransferable(view, selectedFigures);   // Get a transferable

        // Transferable should not have duplicate data flavors
        DataFlavor[] transferDataFlavors = transferable.getTransferDataFlavors();
        HashSet<DataFlavor> noDuplicates = new HashSet<>(Arrays.asList(transferDataFlavors));   // Remove duplicates if any
        Assert.assertEquals("Transferable should not contain duplicate data flavors", noDuplicates.size(), transferDataFlavors.length);
    }

    void setupUpOutputFormats(Drawing drawing) {
        LinkedList<OutputFormat> outputFormats = new LinkedList<OutputFormat>();
        outputFormats.add(new SVGOutputFormat());
        outputFormats.add(new SVGZOutputFormat());
        outputFormats.add(new ImageOutputFormat());
        outputFormats.add(new ImageOutputFormat("JPG", "Joint Photographics Experts Group (JPEG)", "jpg", BufferedImage.TYPE_INT_RGB));
        outputFormats.add(new ImageOutputFormat("BMP", "Windows Bitmap (BMP)", "bmp", BufferedImage.TYPE_BYTE_INDEXED));
        outputFormats.add(new ImageMapOutputFormat());
        drawing.setOutputFormats(outputFormats);
    }
}