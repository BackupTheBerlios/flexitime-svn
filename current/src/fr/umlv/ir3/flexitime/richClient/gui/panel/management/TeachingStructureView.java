/*
 * Created on 22 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiMouseListenerFactory;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiSelectionListenerFactory;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.RootSubjectsGroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.track.TeachingStructureTreeNode;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TeachingStructureView implements FlexiTreeNodeListener
{
	JTree tree;
	TreeModel model;
	JPanel mainPanel;
	JPanel treePanel;
	JPanel viewPanel;
	ITeachingStructure teachingStructure;
	
	public TeachingStructureView(TreeModel model,JTree tree)
	{
		this.model=(ResourceTreeModel)model;
		this.tree=tree;
		//((FlexiTreeNode)this.tree.getSelectionPath().getLastPathComponent()).addFlexiTreeNodeListener(this);
		create();
	}
	
	private void create()
	{
		//Initialisation des panels
		mainPanel = new JPanel(new BorderLayout());
		treePanel = new JPanel(new BorderLayout());
		viewPanel = new JPanel(new BorderLayout());
		teachingStructure = ((TeachingStructureTreeNode)tree.getSelectionPath().getLastPathComponent()).getTeachingStructure();
		//Construction du treePanel
		treePanel.setBorder(BorderFactory.createTitledBorder("Liste des Blocs"));
		
		//Tree for SubjectsGroup
        try
        {
        RootTreeNode rootSubjectsGroupTree = new RootSubjectsGroupTreeNode(null,teachingStructure);
        JTree subjectsGroupTree = createJTree(rootSubjectsGroupTree);
        subjectsGroupTree.addMouseListener(FlexiMouseListenerFactory.createSubjectsGroupMouseLister());
        subjectsGroupTree.addTreeSelectionListener(FlexiSelectionListenerFactory.createSubjectsGroupTreeSelectionListener(this.mainPanel));
        JScrollPane scrollBloc = new JScrollPane(subjectsGroupTree);
        scrollBloc.setPreferredSize(new Dimension(200,100));
        scrollBloc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        treePanel.add(scrollBloc);
        
        //Construction du ViewPanel
      // CourseView courseView = new CourseView(model,tree);
       // viewPanel = courseView.getPanel();
       // viewPanel.setBorder(BorderFactory.createTitledBorder("Cours"));
        
        //Ajout des panel dans le panel principal
        mainPanel.add(viewPanel,BorderLayout.CENTER,0 );
        mainPanel.add(treePanel,BorderLayout.WEST,1);
        }
        catch(RemoteException e)
        {
            //TODO Probleme
        }
	}
	
	public JPanel getPanel()
	{
		return mainPanel;
	}
	
    public JTree createJTree(RootTreeNode rootTree)
    {
    	final ResourceTreeModel model = new ResourceTreeModel(rootTree);
    	rootTree.setModel(model);
        final JTree tmpTree = new JTree(model);
        tmpTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tmpTree.setRootVisible(false);
        tmpTree.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tmpTree.setAutoscrolls(true);
        
        tmpTree.setEditable(true);

        tmpTree.getCellEditor().addCellEditorListener(new CellEditorListener()
		{
			public void editingCanceled(ChangeEvent e) 
			{
				if(((String)tmpTree.getCellEditor().getCellEditorValue()).compareTo("")!= 0)
					model.valueForPathChanged(tmpTree.getSelectionPath(),tmpTree.getCellEditor().getCellEditorValue() );
			}
			public void editingStopped(ChangeEvent e) {}
		});
        return tmpTree;
    }
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.gui.actions.FlexiTreeNodeListener#nodeChanged(java.lang.Object)
	 */
	public void nodeChanged(Object obj) {
//		name.setText( (String)obj);
		//okButton.setEnabled( false);
		
	}

}
