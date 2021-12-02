package org.jhotdraw.copy;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.jhotdraw.samples.svg.io.ImageMapOutputFormat;
import org.jhotdraw.samples.svg.io.SVGOutputFormat;
import org.jhotdraw.samples.svg.io.SVGZInputFormat;
import org.jhotdraw.samples.svg.io.SVGZOutputFormat;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class GivenSelectedFigure extends Stage<GivenSelectedFigure> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        QuadTreeDrawing drawing = new QuadTreeDrawing();
        setupUpInputFormats(drawing);
        setupUpOutputFormats(drawing);
        view.setDrawing(drawing);
        editor.setActiveView(view);
    }

    GivenSelectedFigure aSelectedFigure() {
        Figure f1 = new SVGEllipseFigure(0,0,100,100);
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);
        return this;
    }

    void setupUpOutputFormats(Drawing drawing) {
        LinkedList<OutputFormat> outputFormats = new LinkedList<>();
        outputFormats.add(new SVGOutputFormat());
        outputFormats.add(new SVGZOutputFormat());
        outputFormats.add(new ImageOutputFormat());
        outputFormats.add(new ImageOutputFormat("JPG", "Joint Photographics Experts Group (JPEG)", "jpg", BufferedImage.TYPE_INT_RGB));
        outputFormats.add(new ImageOutputFormat("BMP", "Windows Bitmap (BMP)", "bmp", BufferedImage.TYPE_BYTE_INDEXED));
        outputFormats.add(new ImageMapOutputFormat());
        drawing.setOutputFormats(outputFormats);
    }

    void setupUpInputFormats(Drawing drawing) {
        LinkedList<InputFormat> inputFormats = new LinkedList<>();
        inputFormats.add(new SVGZInputFormat());
        inputFormats.add(new ImageInputFormat(new SVGImageFigure()));
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "JPG", "Joint Photographics Experts Group (JPEG)", "jpg", BufferedImage.TYPE_INT_RGB));
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "GIF", "Graphics Interchange Format (GIF)", "gif", BufferedImage.TYPE_INT_ARGB));
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "PNG", "Portable Network Graphics (PNG)", "png", BufferedImage.TYPE_INT_ARGB));
        inputFormats.add(new PictImageInputFormat(new SVGImageFigure()));
        inputFormats.add(new TextInputFormat(new SVGTextFigure()));
        drawing.setInputFormats(inputFormats);
    }
}
