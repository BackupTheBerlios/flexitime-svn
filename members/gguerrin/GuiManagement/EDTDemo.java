/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList; 

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import fr.umlv.ir3.GL.test.flexibar.MyOutlookBar;
import fr.umlv.ir3.GL.test.flexibar.TestOutlookBar;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.general.impl.ClassImpl;
import fr.umlv.ir3.flexitime.common.data.general.impl.TrackImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.richClient.gui.panel.management.DevicesView;



/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * @author FlexiTeam - binou
 */
public class EDTDemo
{

    private void buildUI(Container container)
    {
        container.setLayout(new BorderLayout());
        //JButton b1 = new JButton("b1");
        //Construction des Track
        ITrack track1 = new TrackImpl("IR");
        ITrack track2 = new TrackImpl("MF");
        ITrack track3 = new TrackImpl("EI");
        //Construction des class
        IClass class1 = new ClassImpl("IR1");
        IClass class2 = new ClassImpl("IR2");
        IClass class3 = new ClassImpl("IR3");
        IClass class4 = new ClassImpl("MF1");
        //Construction des groupes
        IGroup group1 = new GroupImpl("group1");
        IGroup group2 = new GroupImpl("group2");
        
        //Initialisation des class
        class1.addGroup(group1);
        class1.addGroup(group2);
        class2.addGroup(group1);
        class2.addGroup(group2);
        class3.addGroup(group1);
        class3.addGroup(group2);
        class4.addGroup(group1);
        //Initialisaion des track
        track1.addClass(class1);
        track1.addClass(class2);
        track1.addClass(class3);
        track2.addClass(class1);
        track2.addClass(class2);
        track2.addClass(class3);
        track3.addClass(class4);
        List lstTrack = new ArrayList();
        lstTrack.add(track1);
        lstTrack.add(track2);
        lstTrack.add(track3);
       MyOutlookBar fb1 = new MyOutlookBar(lstTrack);
       container.add(createPanelForComponent(fb1.getPanel(),"Visualiser..."), BorderLayout.WEST);
        //TestOutlookBar fb1 = new TestOutlookBar();
       //container.add(createPanelForComponent(fb1,"Visualiser..."), BorderLayout.WEST);
        //TestOutlookBar fb2 = new TestOutlookBar();
       // container.add(createPanelForComponent(fb2,"Ajouter..."), BorderLayout.EAST);
        JButton b3 = new JButton("b3");
        container.add(createPanelForComponent(b3,"Toolbar"), BorderLayout.NORTH);
        JButton b4 = new JButton("b4");
        container.add(createPanelForComponent(b4,"StatusBar"), BorderLayout.SOUTH);
        
        //FlexiPlanning fe = new FlexiPlanning(new DefaultPlanningModel());
        DevicesView deviceView = new DevicesView();
        container.add(new JScrollPane(createPanelForComponent(deviceView,"Matériel")), BorderLayout.CENTER);
        
    }
    
    public JPanel createPanelForComponent(JComponent comp, String title)
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
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI()
    {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("CoordinatesDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setBounds(0,0,800,800);
        frame.setPreferredSize(new Dimension(800,600));
        //Set up the content pane.
        EDTDemo controller = new EDTDemo();
        controller.buildUI(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}

