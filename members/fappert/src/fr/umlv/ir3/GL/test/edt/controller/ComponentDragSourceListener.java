/*
 * Created on 17 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt.controller;

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - binou
 */
 public final class ComponentDragSourceListener implements DragSourceListener {
	public void dragDropEnd(DragSourceDropEvent dsde) {
	}
	public void dragEnter(DragSourceDragEvent dsde)  {
		int action = dsde.getDropAction();
		if (action == DnDConstants.ACTION_MOVE) {
			dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
		} 
		else {
			dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
		}
	}
	public void dragOver(DragSourceDragEvent dsde) {
		int action = dsde.getDropAction();
		if (action == DnDConstants.ACTION_MOVE) {
			dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
		} 
		else {
			dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
		}
	}
	public void dropActionChanged(DragSourceDragEvent dsde)  {
		int action = dsde.getDropAction();
		if (action == DnDConstants.ACTION_MOVE) {
			dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
		} 
		else {
			dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
		}
	}
	public void dragExit(DragSourceEvent dse) {
	    
	   dse.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
	}	
}

