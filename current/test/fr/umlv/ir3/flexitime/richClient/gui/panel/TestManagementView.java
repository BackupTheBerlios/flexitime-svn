/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */



package fr.umlv.ir3.flexitime.richClient.gui.panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.server.DataSimulator;
import fr.umlv.ir3.flexitime.server.DataSimulatorSansRmi;






/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - binou
 */
public class TestManagementView
{

    private void buildUI(Container container) throws FlexiException, RemoteException
    {
        container.setLayout(new BorderLayout());
        //JButton b1 = new JButton("b1");
        
        JButton b3 = new JButton("b3");
        container.add(createPanelForComponent(b3,"Toolbar"), BorderLayout.NORTH);
        JButton b4 = new JButton("b4");
        container.add(createPanelForComponent(b4,"StatusBar"), BorderLayout.SOUTH);
        
        //Creation des objet dans la base
       // DataSimulator.createTrackList();
       // DataSimulator.createDeviceList();
       // DataSimulator.createRoomList();
       // DataSimulator.createTeacherList();
        //FlexiPlanning fe = new FlexiPlanning(new DefaultPlanningModel());
        ManagementView managementView = new ManagementView();
        //ManagementView managementView = new ManagementView(null,null,null);
        //ManagementView managementView = new ManagementView(new ArrayList(),new ArrayList(),new ArrayList());
        container.add(new JScrollPane(createPanelForComponent(managementView.getPanel(),null)), BorderLayout.CENTER);
        
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
     * @throws FlexiException 
     * @throws RemoteException 
     */
    private static void createAndShowGUI() throws FlexiException, RemoteException
    {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("CoordinatesDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setBounds(0,0,800,800);
        frame.setPreferredSize(new Dimension(800,600));
        //Set up the content pane.
        TestManagementView controller = new TestManagementView();
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
                try {
					createAndShowGUI();
				} catch (FlexiException e) {
					System.out.println("Problème Remote :" +e.getMessage());
				}
                catch(RemoteException re)
                {
                  System.out.println("Problème Remote :" +re.getMessage() );
                }
            }
        });
    }
}

