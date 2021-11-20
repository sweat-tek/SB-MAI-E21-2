package org.jhotdraw.draw;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.util.List;

public class DeleteEvent {

    @FeatureEntryPoint(JHotDrawFeatures.BASIC_EDITING)
    public void sendDeleteEvent(DefaultDrawingView defaultDrawingView){
        final List<Figure> deletedFigures = defaultDrawingView.getDrawing().sort(defaultDrawingView.getSelectedFigures());

        // Abort, if not all of the selected figures may be removed from the
        // drawing
        for (Figure f : deletedFigures) {
            if (!f.isRemovable()) {
                defaultDrawingView.getToolkit().beep();
                return;
            }
        }

        // Get z-indices of deleted figures
        final int[] deletedFigureIndices = new int[deletedFigures.size()];
        for (int i = 0; i < deletedFigureIndices.length; i++) {
            deletedFigureIndices[i] = defaultDrawingView.getDrawing().indexOf(deletedFigures.get(i));
        }

        defaultDrawingView.clearSelection();
        defaultDrawingView.getDrawing().removeAll(deletedFigures);

        defaultDrawingView.getDrawing().fireUndoableEditHappened(new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                return labels.getString("edit.delete.text");
            }

            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                defaultDrawingView.clearSelection();

                Drawing d = defaultDrawingView.getDrawing();
                for (int i = 0; i <
                        deletedFigureIndices.length; i++) {
                    d.add(deletedFigureIndices[i], deletedFigures.get(i));
                }

                defaultDrawingView.addToSelection(deletedFigures);
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                for (int i = 0; i <
                        deletedFigureIndices.length; i++) {
                    defaultDrawingView.getDrawing().remove(deletedFigures.get(i));
                }

            }
        });
    }
}
