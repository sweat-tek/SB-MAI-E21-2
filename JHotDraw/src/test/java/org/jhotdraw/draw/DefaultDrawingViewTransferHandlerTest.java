package org.jhotdraw.draw;

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

    @Before
    public void setUp() {
        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    @Test
    public void createTransferable() {
        DefaultDrawingViewTransferHandler transferHandler = new DefaultDrawingViewTransferHandler();

        // Add figure to drawing and select it
        Figure f1 = new BezierFigure();
        view.getDrawing().add(f1);
        view.addToSelection(f1);

        Set<Figure> selectedFigures = view.getSelectedFigures();

        // Should be null if it does not have output formats
        List<OutputFormat> outputFormats1 = view.getDrawing().getOutputFormats();
        Assert.assertTrue("Drawing should have no output formats", outputFormats1.isEmpty());
        Transferable transferable = transferHandler.createTransferable(view, selectedFigures);
        Assert.assertNull("Transferable should be null it it doest not have output formats", transferable);

        setupUpOutputFormats(view.getDrawing());

        // Should return null if there is no elements in the drawing
        HashSet<Figure> emptySet = new HashSet<>();
        transferable = transferHandler.createTransferable(view, emptySet);
        Assert.assertNull("Transferable should be null if there is no elements selected", transferable);

        // Should NOT be null if it does have output formats
        List<OutputFormat> outputFormats2 = view.getDrawing().getOutputFormats();
        Assert.assertFalse("Drawing should have output formats", outputFormats2.isEmpty());
        transferable = transferHandler.createTransferable(view, selectedFigures);
        Assert.assertNotNull("Transferable should NOT be null if it has output formats",
                transferable);

        // Transferable should not have duplicate data flavors
        DataFlavor[] transferDataFlavors = transferable.getTransferDataFlavors();
        HashSet<DataFlavor>dataFlavorSet = new HashSet<>(Arrays.asList(transferDataFlavors));
        Assert.assertEquals("Transferable should not contain duplicate data flavors", dataFlavorSet.size(), transferDataFlavors.length);
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