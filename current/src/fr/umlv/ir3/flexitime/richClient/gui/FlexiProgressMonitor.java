/*
 * Created on 1 févr. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class FlexiProgressMonitor //implements ActionListener 
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3977860683100468025L;

    /**
     * Comment for <code>ONE_SECOND</code>
     */
    public final static int ONE_SECOND = 1000;

    private ProgressMonitor progressMonitor;
    private Timer timer;
    private LongTask task;
    private JTextArea taskOutput;
    private String newline = "\n";
    private static JFrame frame;

    /**
     * DOCME
     */
    public FlexiProgressMonitor() {
        //JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        frame = new JFrame("ProgressMonitor");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create and set up the content pane.
        //JComponent newContentPane = new FlexiProgressMonitor();
        //newContentPane.setOpaque(true); //content panes must be opaque
        //frame.setContentPane(newContentPane);


        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(new JLabel("test"));
//        task = new LongTask();
//
//        progressMonitor = new ProgressMonitor(frame, "Chargement des données", "", 0, task.getLengthOfTask());
//        progressMonitor.setProgress(0);
//        progressMonitor.setMillisToDecideToPopup(2 * ONE_SECOND);
//        
//        taskOutput = new JTextArea(5, 20);
//        taskOutput.setMargin(new Insets(5,5,5,5));
//        taskOutput.setEditable(false);
//
//        add(new JScrollPane(taskOutput), BorderLayout.CENTER);
        //setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

//        timer = new Timer(ONE_SECOND, new TimerListener());
    }

    /**
     * The actionPerformed method in this class
     * is called each time the Timer "goes off".
     */
    class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            progressMonitor.setProgress(task.getCurrent());
            String s = task.getMessage();
            if (s != null) {
                progressMonitor.setNote(s);
                taskOutput.append(s + newline);
                taskOutput.setCaretPosition(
                    taskOutput.getDocument().getLength());
            }
            if (progressMonitor.isCanceled() || task.isDone()) {
                progressMonitor.close();
                task.stop();
                Toolkit.getDefaultToolkit().beep();
                timer.stop();
                if (task.isDone()) {
                    taskOutput.append("Task completed." + newline);
                } else {
                    taskOutput.append("Task canceled." + newline);
                }
            }
        }
    }



    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public void run() {
        //Display the window.
        frame.pack();
        frame.setVisible(true);
//        task.go();
//        timer.start();
    }

    
    public void stop()
    {
        frame.dispose();   
    }
}
