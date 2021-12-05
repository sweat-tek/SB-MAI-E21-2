/*
 * @(#)CanvasToolBar.java  1.0  2008-05-18
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and
 * contributors of the JHotDraw project ("the copyright holders").
 * You may not use, copy or modify this software, except in
 * accordance with the license agreement you entered into with
 * the copyright holders. For details see accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;

import java.beans.PropertyChangeEvent;
import javax.swing.border.*;

import org.jhotdraw.util.*;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.prefs.Preferences;
import javax.swing.*;

import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.GridConstrainer;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.gui.JLifeFormattedTextField;
import org.jhotdraw.gui.plaf.palette.*;
import org.jhotdraw.text.JavaNumberFormatter;

/**
 * ViewToolBar.
 * <p>
 * Note: you must explicitly set the view before createDisclosedComponents is
 * called for the first time.
 *
 * @author Werner Randelshofer
 * @version 1.0 2008-05-18 Created.
 */
public class ViewToolBar extends AbstractToolBar {

    private DrawingView view;

    /**     * Creates new instance.*/
    public ViewToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
        setDisclosureStateCount(3);
    }

    public void setView(DrawingView view) {
        this.view = view;
        prefs = Preferences.userNodeForPackage(getClass());
        GridConstrainer constrainer = (GridConstrainer) view.getVisibleConstrainer();
        constrainer.setHeight(prefs.getDouble("view.gridSize", 8d));
        constrainer.setWidth(prefs.getDouble("view.gridSize", 8d));
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.VIEW_PALETTE)
    protected JComponent createDisclosedComponent(int state) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.removeAll();
        panel.setBorder(new EmptyBorder(5, 5, 5, 8));
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);

        switch (state) {
            case 1: {
                // Toggle Grid Button
                AbstractButton toggleGridButton = createButton(ButtonFactory.createToggleGridButton(view), labels, "alignGrid", null);
                GridBagConstraints toggleGrid = createGridBagConstraints(1, 0, GridBagConstraints.NONE);
                toggleGrid.insets = new Insets(0, 0, 0, 0);
                panel.add(toggleGridButton, toggleGrid);

                // Zoom button
                AbstractButton zoomButton = createButton(ButtonFactory.createZoomButton(view), labels, "view.zoomFactor", "100 %");
                GridBagConstraints zoomGrid = createGridBagConstraints(1, 1, GridBagConstraints.HORIZONTAL, 1, 1);
                zoomGrid.gridwidth = GridBagConstraints.REMAINDER;
                zoomGrid.insets = new Insets(3, 0, 0, 0);

                zoomButton.setPreferredSize(new Dimension(zoomButton.getPreferredSize().width, toggleGridButton.getPreferredSize().height));
                panel.add(zoomButton, zoomGrid);
            }
            break;
            case 2: {

                // Grid size field and toggle grid button
                JLifeFormattedTextField gridSizeField = gridSize(labels);
                GridBagConstraints gridSize = createGridBagConstraints(0, 0, GridBagConstraints.NONE);
                gridSize.insets = new Insets(0, 0, 0, 0);
                panel.add(gridSizeField, gridSize);

                AbstractButton toggleGridButton = createButton(ButtonFactory.createToggleGridButton(view), labels, "alignGrid", null);
                GridBagConstraints toggleGrid = createGridBagConstraints(1, 0, GridBagConstraints.NONE);
                toggleGrid.insets = new Insets(0, 0, 0, 0);
                panel.add(toggleGridButton, toggleGrid);

                // Zoom factor field and zoom button
                JLifeFormattedTextField scaleFactorField = scaleField(labels);
                view.addPropertyChangeListener(evt -> {
                    if (evt.getPropertyName().equals(DrawingView.SCALE_FACTOR_PROPERTY)) {
                        if (evt.getNewValue() != null) {
                            scaleFactorField.setValue(evt.getNewValue());
                        }
                    }
                });
                GridBagConstraints scaleFactorGrid = createGridBagConstraints(0, 1, GridBagConstraints.NONE);
                scaleFactorGrid.insets = new Insets(3, 0, 0, 0);
                panel.add(scaleFactorField, scaleFactorGrid);

                AbstractButton zoomButton = createButton(ButtonFactory.createZoomButton(view), labels, "view.zoomFactor", "100 %");
                GridBagConstraints zoomGrid = createGridBagConstraints(1, 1, GridBagConstraints.HORIZONTAL, 0, 1);
                zoomGrid.gridwidth = GridBagConstraints.REMAINDER;
                zoomGrid.insets = new Insets(3, 0, 0, 0);
                zoomButton.setPreferredSize(new Dimension(zoomButton.getPreferredSize().width, scaleFactorField.getPreferredSize().height));
                panel.add(zoomButton, zoomGrid);
            }
            break;
        }
        return panel;
    }

    @Override
    protected String getID() {
        return "view";
    }

    private GridBagConstraints createGridBagConstraints(int gridX, int gridY, int fill) {
        return createGridBagConstraints(gridX, gridY, fill, 0, 0);
    }

    private GridBagConstraints createGridBagConstraints(int gridX, int gridY, int fill, int weightX, int weightY) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = fill;
        gbc.weightx = weightX;
        gbc.weighty = weightY;
        return gbc;
    }

    private AbstractButton createButton(AbstractButton button, ResourceBundleUtil labels, String id) {
        return createButton(button, labels, id, null);
    }

    private AbstractButton createButton(AbstractButton button, ResourceBundleUtil labels, String id, String text) {
        button.setUI((PaletteButtonUI) PaletteButtonUI.createUI(button));
        labels.configureToolBarButton(button, id);
        if (text != null) {
            button.setText(text);
        }
        return button;
    }

    private JLifeFormattedTextField gridSize(ResourceBundleUtil labels) {
        JLifeFormattedTextField gridSizeField = new JLifeFormattedTextField();
        gridSizeField.setColumns(3);
        gridSizeField.setToolTipText(labels.getString("view.gridSize.toolTipText"));
        gridSizeField.setHorizontalAlignment(JLifeFormattedTextField.RIGHT);
        gridSizeField.putClientProperty("Palette.Component.segmentPosition", "first");
        gridSizeField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(gridSizeField));
        gridSizeField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 1000d, 1d, true, false));
        gridSizeField.setHorizontalAlignment(JTextField.LEADING);
        final GridConstrainer constrainer = (GridConstrainer) view.getVisibleConstrainer();
        gridSizeField.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("value")) {
                    if (evt.getNewValue() != null) {
                        constrainer.setWidth((Double) evt.getNewValue());
                        constrainer.setHeight((Double) evt.getNewValue());
                        prefs = Preferences.userNodeForPackage(getClass());
                        prefs.putDouble("view.gridSize", (Double) evt.getNewValue());
                        view.getComponent().repaint();
                    }
                }
            }
        });
        gridSizeField.setValue(constrainer.getHeight());
        return gridSizeField;
    }

    private JLifeFormattedTextField scaleField(ResourceBundleUtil labels) {
        final JLifeFormattedTextField scaleFactorField = new JLifeFormattedTextField();
        scaleFactorField.setColumns(3);
        scaleFactorField.setToolTipText(labels.getString("view.zoomFactor.toolTipText"));
        scaleFactorField.setHorizontalAlignment(JLifeFormattedTextField.RIGHT);
        scaleFactorField.putClientProperty("Palette.Component.segmentPosition", "first");
        scaleFactorField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(scaleFactorField));
        scaleFactorField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0.01d, 50d, 100d, true, false));
        scaleFactorField.setHorizontalAlignment(JTextField.LEADING);
        scaleFactorField.setValue(view.getScaleFactor());
        scaleFactorField.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("value")) {
                if (evt.getNewValue() != null) {
                    view.setScaleFactor((Double) evt.getNewValue());
                }
            }
        });
        return scaleFactorField;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
