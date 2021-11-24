/*
 * @(#)RedoAction.java  2.0  2006-06-15
 *
 * Copyright (c) 1996-2007 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw.app.action;
import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.beans.*;
import java.util.*;
import org.jhotdraw.util.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;
/**
 * Redoes the last user action.
 * In order to work, this action requires that the View returns a project
 * specific undo action when invoking getAction("redo") on the View.
 *
 *
 * @author Werner Randelshofer
 * @version 2.0 2006-06-15 Reworked.
 * <br>1.0 October 9, 2005 Created.
 */
public class RedoAction extends UndoRedoViewAction {
    public static final String ID = "edit.redo";
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
    
    
    /** Creates a new instance. */
    public RedoAction(Application app) {
        super(app);
        labels.configureAction(this, ID);
    }
    
    @Override
    protected Action getRealUndoRedoAction() {
        return (getActiveView() == null) ? null : getActiveView().getAction(ID);
    }
}
