/*
 * Created on 21 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation;

import java.awt.BorderLayout;
<<<<<<< .mine
import java.rmi.RemoteException;
import java.util.ArrayList;
=======
>>>>>>> .r452
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningHebdoModelAdapter;
import fr.umlv.ir3.flexitime.common.gui.models.RessourcePlanningModel;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.richClient.gui.panel.FlexiBar;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.menu.JCourseList;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.menu.JRoomList;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.menu.JTeacherList;
import fr.umlv.ir3.flexitime.richClient.models.exploitation.course.CourseListModel;
import fr.umlv.ir3.flexitime.richClient.models.exploitation.room.RoomListModel;
import fr.umlv.ir3.flexitime.richClient.models.exploitation.teacher.TeacherListModel;



/**
 * Redefine a Panel to contain a planning of ressources
 * 
 * @version 1.0
 * 
 * @author FlexiTeam - binou
 */
public class RessourcePlanning extends JPanel
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256437006270477877L;
    /**
     * The current planning is "trimestriel"
     */
    public static final int MODE_TRIM = 1;
    /**
     * The current planning is "hebdomadaire"
     */
    public static final int MODE_HEBDO = 2;
    /**
     * The current planning is for severals ressources
     */
    public static final int MODE_MULTI = 3;
    
    private static FlexiLanguage language;
    static
    {
        language = FlexiLanguage.getInstance();
    }
    
    private int mode = 0;
    
    private JRessourcePlanning planningTrim = null;
    private JRessourcePlanningHebdo planningHebdo = null;
    private JRessourcesPlanning planningMulti = null;
    
    private Object ressource;
    private Gap initialGap;
    private FlexiBar bar;
    
    private JList teacherList;
    private JList roomList;
    
    //********************
    // Debugging
    //******************
    
    
    private JList tsList;
    
    
    /**
     * Creates a RessourcePlanning 
     * 
     */
    public RessourcePlanning()
    {
        super(new BorderLayout());
        
        //TODO lire la config ici
        this.initialGap = new Gap(2005,1,3,0,1,2005,2,6,23,59);
        this.ressource = null;
        this.setAutoscrolls(true);
        
    }
    
    /** 
     * Sets the ressource used to create a planning<br>
     * It could be just one ressouce, or a <code>List</code> of ressources<br>
     * If it's a <code>List</code> of ressources, the planning won't be the same<br>
     *
     * @param _ressource the ressource or a List of ressources to display 
     * 
     * @see IResource
     * 
     */
    public void setRessource(Object _ressource)
    {
        if(_ressource == null)
            return;
        this.ressource = _ressource;
        
        //Si on etait en mode trim ou hebdo, on recupere la cr�neau visualis� pr�c�demment
        if(mode != 0)
            if(mode == RessourcePlanning.MODE_TRIM)
                this.initialGap = planningTrim.getModel().getCurrentGap();
            else if(mode == RessourcePlanning.MODE_HEBDO)
                this.initialGap = planningHebdo.getModel().getCurrentGap();
        
        cleanPanel();
        
        System.out.println(this.initialGap.getStartDate().getStrDate());
        System.out.println(this.initialGap.getEndDate().getStrDate());
        System.out.println(Time.getGapWeek(this.initialGap.getStartDate(), this.initialGap.getEndDate()));
        
        if(ressource instanceof List)
            this.mode = RessourcePlanning.MODE_MULTI;
        else if(Time.getGapWeek(this.initialGap.getStartDate(), this.initialGap.getEndDate())+1 > 1)
            this.mode = RessourcePlanning.MODE_TRIM;
        else
            this.mode = RessourcePlanning.MODE_HEBDO;
        
        createPlanning();
    }

    
    /** 
     * Returns the type of the planning currently used<br>
     * 
     * @return the mode of the planning currently used
     * 
     * @see RessourcePlanning defines the static values
     */
    public int getMode()
    {
        return mode;
    }
    
    private void createPlanning()
    {
        if(this.ressource instanceof IResource)
        {
            if(this.mode == RessourcePlanning.MODE_TRIM)
            {
                //System.out.println("Affichage Trim"); //$NON-NLS-1$
                this.mode = RessourcePlanning.MODE_TRIM;
                planningTrim = new JRessourcePlanning(new RessourcePlanningModel((IResource)this.ressource, this.initialGap));
                JScrollPane pane = new JScrollPane(createPanelForComponent(planningTrim,language.getText("exploitEDTTitle")));
                pane.setAutoscrolls(true);
                this.add(pane , BorderLayout.CENTER); //$NON-NLS-1$
                if(this.ressource instanceof IGroup)
                    createRightFlexiBar();
            }
            else
            {
                //System.out.println("Affichage hebdo"); //$NON-NLS-1$
                this.mode = RessourcePlanning.MODE_HEBDO;
                planningHebdo = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter((IResource)this.ressource, this.initialGap));
                this.add(new JScrollPane(createPanelForComponent(planningHebdo,language.getText("exploitEDTTitle"))), BorderLayout.CENTER); //$NON-NLS-1$
                if(this.ressource instanceof IGroup)
                    createRightFlexiBar();
            }
        }
        else if(this.ressource instanceof List)
        {
            System.out.println("Affichage multiple"); //$NON-NLS-1$
        }
    }
    


    
    public final void switchToHebdo(int weekNumber)
    {
        this.mode = RessourcePlanning.MODE_HEBDO;

        //On op�re la d�cr�mentation pour passer � 1 semaine
        this.initialGap = this.planningTrim.getModel().getCurrentGap();
        int nbWeeks = this.planningTrim.getModel().getNbWeeks();
        this.initialGap.getStartDate().addWeek(weekNumber);
        System.out.println("ajout de " + weekNumber + " weeks");
        this.initialGap.getEndDate().addWeek(  -(nbWeeks-weekNumber-1)   );
        System.out.println("retrait de " + -(nbWeeks-weekNumber-1) + " weeks");

        this.cleanPanel();
        if(this.ressource instanceof IGroup)
            this.createRightFlexiBar();

        this.planningHebdo = new JRessourcePlanningHebdo(new RessourcePlanningHebdoModelAdapter((IResource)this.ressource, this.initialGap));
        this.add(new JScrollPane(createPanelForComponent(planningHebdo,language.getText("exploitEDTTitle"))), BorderLayout.CENTER); //$NON-NLS-1$
    }

    private void switchToTrim()
    {
        this.mode = RessourcePlanning.MODE_TRIM;
        
        //On op�re la d�cr�mentation pour passer � 1 semaine
        this.initialGap = this.planningHebdo.getModel().getCurrentGap();
        this.initialGap.getEndDate().addWeek(1);
        
        this.cleanPanel();
        if(this.ressource instanceof IGroup)
            this.createRightFlexiBar();
        
        this.planningTrim = new JRessourcePlanning(new RessourcePlanningModel((IResource)this.ressource, this.initialGap));
        this.add(new JScrollPane(createPanelForComponent(planningTrim,language.getText("exploitEDTTitle"))), BorderLayout.CENTER); //$NON-NLS-1$
        
    }
    
    private void cleanPanel()
    {
        this.planningHebdo = null;
        this.planningTrim = null;
        this.planningMulti = null;
        this.removeAll();
        this.revalidate();
    }
    

    
    private void createRightFlexiBar()
    {
        if(bar == null)
//        {
//            DefaultMutableTreeNode rootNode3 = new DefaultMutableTreeNode("Structure d'enseignement"); //$NON-NLS-1$
//            DefaultMutableTreeNode subGroup1 = new DefaultMutableTreeNode("General"); //$NON-NLS-1$
//            DefaultMutableTreeNode subGroup2 = new DefaultMutableTreeNode("Rezo"); //$NON-NLS-1$
//            rootNode3.add(subGroup1);
//            rootNode3.add(subGroup2);
//            DefaultMutableTreeNode sub1 = new DefaultMutableTreeNode("J2EE"); //$NON-NLS-1$
//            DefaultMutableTreeNode sub2 = new DefaultMutableTreeNode("GL"); //$NON-NLS-1$
//            DefaultMutableTreeNode sub3 = new DefaultMutableTreeNode("pwet pwet"); //$NON-NLS-1$
//            subGroup1.add(sub1);
//            subGroup1.add(sub2);
//            subGroup1.add(sub3);
//            DefaultMutableTreeNode sub4 = new DefaultMutableTreeNode("Expos� ReZo"); //$NON-NLS-1$
//            DefaultMutableTreeNode sub5 = new DefaultMutableTreeNode("Mod�lisation des ReZo"); //$NON-NLS-1$
//            subGroup2.add(sub4);
//            subGroup2.add(sub5);
//            DefaultTreeModel model3 = new DefaultTreeModel(rootNode3);
//            tsTree = new JTree(model3);
//            tsTree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
            
//            DefaultListModel listModel = new DefaultListModel();
//            listModel.addElement("Midonnet"); //$NON-NLS-1$
//            listModel.addElement("Revuz"); //$NON-NLS-1$
//            listModel.addElement("Cervelle ... aie"); //$NON-NLS-1$
//            teacherList = new JList(listModel);
//            teacherList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//            
//            try {
//				teacherList = new JTeacherList(new TeacherListModel(RemoteDataManager.getManager().getTeachers()));
//				//roomList = new JRoomList(new RoomListModel(RemoteDataManager.getManager().getRooms()));
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            tsList = new JCourseList(new CourseListModel( ((IGroup)ressource).getParentClass().getTeachingStructure() ));
//            
            bar = new FlexiBar();
//            bar.add(language.getText("courses"), tsList); //$NON-NLS-1$
//            bar.add(language.getText("teachers"), teacherList); //$NON-NLS-1$
//            bar.add(language.getText("rooms"), roomList); //$NON-NLS-1$
//        }
//        else
//        {
//            System.out.println("regenere la bar");
//            ((CourseListModel)tsList.getModel()).setTeachingStructure(  ((IGroup)ressource).getParentClass().getTeachingStructure()   );
//        }
        
        this.add(new JScrollPane(createPanelForComponent(bar,language.getText("exploitEDTBarTitle"))), BorderLayout.EAST); //$NON-NLS-1$
    }
    

    
   

    
    private static JPanel createPanelForComponent(JComponent comp, String title)
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(comp, BorderLayout.CENTER);
        if (title != null)
        {
            panel.setBorder(BorderFactory.createTitledBorder(title));
        }
        return panel;
    }
    
    
    
    
    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the previous Gap of week
     */
    public void fullStepBack()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                //System.out.println("fullStepBack() en mode Hebdo"); //$NON-NLS-1$
                planningHebdo.fullStepBack();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_TRIM :
                //System.out.println("fullStepBack() en mode Trim"); //$NON-NLS-1$
                planningTrim.fullStepBack();
                break;
        }
        
    }
    
    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the same gap but one week earlier
     */
    public void stepBack()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                //System.out.println("stepBack() en mode Hebdo"); //$NON-NLS-1$
                planningHebdo.stepBack();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_TRIM :
                //System.out.println("stepBack() en mode Trim"); //$NON-NLS-1$
                planningTrim.stepBack();
                break;
        }
    }
    
    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the the same gap without the ending week
     */
    public void decrease()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode hebdo !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_TRIM :
                if(planningTrim.getModel().getNbWeeks() == 2)
                    this.switchToHebdo(0);
                else
                    planningTrim.decrease();
                break;
                    
        }
    }
    

    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the the same gap with another week added
     */
    public void increase()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                this.switchToTrim();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_TRIM :
                //System.out.println("increase() en mode Trim"); //$NON-NLS-1$
                planningTrim.increase();
                break;
        }
    }

    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the same gap but one week later
     */
    public void stepOver()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                //System.out.println("stepOver() en mode Hebdo"); //$NON-NLS-1$
                planningHebdo.stepOver();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_TRIM :
                //System.out.println("stepOver() en mode Trim"); //$NON-NLS-1$
                planningTrim.stepOver();
                break;
        }
    }
    
    /** 
     * Change the range of week currently used for the planning<br>
     * the result will be the next Gap of week
     */
    public void fullStepOver()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                //System.out.println("fullStepOver() en mode Hebdo"); //$NON-NLS-1$
                planningHebdo.fullStepOver();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_TRIM :
                //System.out.println("fullStepOver() en mode Trim"); //$NON-NLS-1$
                planningTrim.fullStepOver();
                break;
        }
    }
    
    /** 
     * Decrease the size of gap's time
     */
    public void lessGapTime()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                //System.out.println("lessGapTime() en mode Hebdo"); //$NON-NLS-1$
                planningHebdo.lessGapTime();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_TRIM :
                //System.out.println("fullStepOver() en mode Trim"); //$NON-NLS-1$
                planningTrim.lessGapTime();
                break;
        }
    }
    
    /** 
     * Increase the size of gap's time
     */
    public void moreGapTime()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                //System.out.println("moreGapTime() en mode Hebdo"); //$NON-NLS-1$
                planningHebdo.moreGapTime();
                break;
            case RessourcePlanning.MODE_MULTI :
                System.err.println("On ne doit pas pouvoir lancer cette action en mode multi !!!"); //$NON-NLS-1$
                break;
            case RessourcePlanning.MODE_TRIM :
                //System.out.println("fullStepOver() en mode Trim"); //$NON-NLS-1$
                planningTrim.moreGapTime();
                break;
        }
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see (si n�cessaire)
     */
    public JComponent getPrintableComponent()
    {
        switch(mode)
        {
            case RessourcePlanning.MODE_HEBDO :
                return planningHebdo;
            case RessourcePlanning.MODE_MULTI :
                ;//return planningMulti;
                break;
            case RessourcePlanning.MODE_TRIM :
                return planningTrim;
        }
        return null;
    }
    

}

