/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.management;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiMouseListenerFactory;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiSelectionListenerFactory;
import fr.umlv.ir3.flexitime.richClient.gui.actions.management.FlexiTreeNodeListener;
import fr.umlv.ir3.flexitime.richClient.models.management.ResourceTreeModel;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.RootSubjectsGroupTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.teachingStructure.TeachingStructureTreeNode;

/**
 * subjectsGroupView
 * represents the view of a teachingStructure
 * @author Guillaume GUERRIN
 */
public class TeachingStructureView implements FlexiTreeNodeListener
{
	JTree tree;
	TreeModel model;
	//JPanel mainPanel;
	JSplitPane mainPanel;
    JPanel treePanel;
	JPanel viewPanel;
	ITeachingStructure teachingStructure=null;
    ListModel teacherList;
    private static FlexiLanguage language = FlexiLanguage.getInstance();
    
	public TeachingStructureView(TreeModel model,JTree tree,ListModel teacherList)
	{
		this.model=(ResourceTreeModel)model;
		this.tree=tree;
        this.teacherList=teacherList;
		//((FlexiTreeNode)this.tree.getSelectionPath().getLastPathComponent()).addFlexiTreeNodeListener(this);
		create();
	}
	
	private void create()
	{
		//Initialisation des panels
		//mainPanel = new JPanel(new BorderLayout());
        mainPanel = new JSplitPane();
		treePanel = new JPanel(new BorderLayout());
        
		viewPanel = new JPanel(new BorderLayout());
		if(teachingStructure ==null)teachingStructure = ((TeachingStructureTreeNode)tree.getSelectionPath().getLastPathComponent()).getTeachingStructure();
		//Construction du treePanel
		treePanel.setBorder(BorderFactory.createTitledBorder("Liste des Blocs"));
		
		//Tree for SubjectsGroup
        try
        {
        RootTreeNode rootSubjectsGroupTree = new RootSubjectsGroupTreeNode(null,teachingStructure);
        JTree subjectsGroupTree = createJTree(rootSubjectsGroupTree);
        subjectsGroupTree.addMouseListener(FlexiMouseListenerFactory.createSubjectsGroupMouseLister(mainPanel));
        subjectsGroupTree.addTreeSelectionListener(FlexiSelectionListenerFactory.createSubjectsGroupTreeSelectionListener(this.mainPanel,teacherList));
        JScrollPane scrollBloc = new JScrollPane(subjectsGroupTree);
        scrollBloc.setPreferredSize(new Dimension(200,100));
        scrollBloc.setMinimumSize(new Dimension(200,100));
        scrollBloc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        treePanel.add(scrollBloc);
        
        //Construction du ViewPanel
      // CourseView courseView = new CourseView(model,tree);
       // viewPanel = courseView.getPanel();
       // viewPanel.setBorder(BorderFactory.createTitledBorder("Cours"));
        
        //Ajout des panel dans le panel principal
        //mainPanel.add(viewPanel,BorderLayout.CENTER,0 );
       //mainPanel.add(treePanel,BorderLayout.WEST,1);
        mainPanel.add(viewPanel,JSplitPane.RIGHT,0 );
        mainPanel.add(treePanel,JSplitPane.LEFT,1);
        }
        catch(RemoteException e)
        {
            //TODO Probleme
        }
	}
	
	/*public JPanel getPanel()
	{
		return mainPanel;
	}*/
    public JSplitPane getPanel()
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
    
    public void setTeachingStructure(ITeachingStructure teaching)
    {
        this.teachingStructure = teaching;
        create();
    }
	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.gui.actions.FlexiTreeNodeListener#nodeChanged(java.lang.Object)
	 */
	public void nodeChanged(Object obj) {
//		name.setText( (String)obj);
		//okButton.setEnabled( false);
		
	}

}
