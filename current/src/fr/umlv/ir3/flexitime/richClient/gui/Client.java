/*
 * Created on 12 déc. 2004
 * by Adrien Bouvet
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import com.jgoodies.plaf.HeaderStyle;
import com.jgoodies.plaf.Options;
import com.jgoodies.plaf.plastic.Plastic3DLookAndFeel;

import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.ExploitationAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.ExportAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.GestionAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.HistoryAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.LoginAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.MailAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.NextWeekAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.PreferencesAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.PreviousWeekAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.PrintAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.StatsAction;

/**
 * Client This class build an graphic interface for the user.
 * 
 * @version 0.1
 * @author FlexiTeam - Adrien Bouvet
 */
public class Client
{

    private JFrame frame;
    private JPanel panel;

    /**
     * DOCME
     */
    public Client()
    {
        frame = new JFrame("Flexitime");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        panel = new JPanel(new BorderLayout());
        frame.setContentPane(panel);

        run();

        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * main - DOCME Code This main method instanciates an Client object and call
     * the run() method on it. <code>exemple d'appel de la methode</code>
     * 
     * @param args
     * @author FlexiTeam - Adrien Bouvet
     * @date 14 déc. 2004
     */
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        }
        catch (Exception e)
        {}

        Client c = new Client();
    }

    /**
     * run - DOCME Code This method runs the Client object.
     * <code>exemple d'appel de la methode</code>
     * 
     * @return an int which indicates if the method is well finished.
     * @author FlexiTeam - Adrien Bouvet
     * @date 14 déc. 2004
     */
    int run()
    {
        initMenuBar();
        initToolBar();
        return 0;
    }

    private static JButton createButton(Action action)
    {
        JButton button = new JButton();
        button.setIcon((Icon)action.getValue(Action.SMALL_ICON));
        button.setToolTipText((String)action.getValue(Action.NAME));
        
        return button;
    }
    /**
     * initToolBar - DOCME Code This method creates the client's tool bar.
     * <code>exemple d'appel de la methode</code>
     * 
     * @return an int which indicates if the method is well finished.
     * @author FlexiTeam - Adrien Bouvet
     * @date 14 déc. 2004
     */
    void initToolBar()
    {
        JToolBar tb = new JToolBar();
        tb.putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);
        panel.add(tb, BorderLayout.PAGE_START);
        
        //Imprimer
        tb.add(createButton(PrintAction.getInstance()));
        
        //Export
        tb.add(createButton(ExportAction.getInstance()));
        
        //Mail
        tb.add(createButton(MailAction.getInstance()));
        
        tb.addSeparator();
        
        //Gestion
        tb.add(createButton(GestionAction.getInstance()));
        
        //Exploitation
        tb.add(createButton(ExploitationAction.getInstance()));
        
        //Historique
        tb.add(createButton(HistoryAction.getInstance()));
        
        //Stats
        tb.add(createButton(StatsAction.getInstance()));
        
        tb.addSeparator();
        
        //Back
        tb.add(createButton(PreviousWeekAction.getInstance()));
        
        //Forward
        tb.add(createButton(NextWeekAction.getInstance()));
        
        
        
        

    }

    /**
     * initMenuBar - DOCME Code This method creates the client's menu bar.
     * <code>exemple d'appel de la methode</code>
     * 
     * @author FlexiTeam - Adrien Bouvet
     * @date 14 déc. 2004
     */
    void initMenuBar()
    {
        JMenuBar jmb = new JMenuBar();
        jmb.putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);

        // File//
        JMenu fichier = new JMenu("Fichier");
        jmb.add(fichier);

        Action log = LoginAction.getInstance();
        fichier.add(log);
        fichier.add(new JSeparator());

        Action pref = PreferencesAction.getInstance();
        fichier.add(pref);

        Action print = PrintAction.getInstance();
        fichier.add(print);
        fichier.add(new JSeparator());
        
        Action impor = new AbstractAction("Importer") {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub

            }

        };
        fichier.add(impor);
        
        Action export = ExportAction.getInstance();
        fichier.add(export);
        fichier.add(new JSeparator());
        
        Action quit = new AbstractAction("Quitter") {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub

            }

        };
        fichier.add(quit);

        // Mail//
        JMenu mail = new JMenu("Mail");
        jmb.add(mail);
        
        Action sendView = MailAction.getInstance();
        mail.add(sendView);

        Action sendFormatedMail = new AbstractAction("Envoyer Mail pré formaté") {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub

            }

        };
        mail.add(sendFormatedMail);

        // Affichage//
        JMenu affichage = new JMenu("Affichage");
        jmb.add(affichage);
        
        JMenu mode = new JMenu("Mode");
        affichage.add(mode);
        
        Action gestion = GestionAction.getInstance();
        mode.add(gestion);
        
        Action exploitation = ExploitationAction.getInstance();
        mode.add(exploitation);
        
        Action historique = HistoryAction.getInstance();
        mode.add(historique);
        
        Action stats = StatsAction.getInstance();
        affichage.add(stats);


        // Administration//

        // Aide//
        JMenu aide = new JMenu("Aide");
        jmb.add(aide);
        
        Action aideenligne = new AbstractAction("Aide...") {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub

            }

        };
        aide.add(aideenligne);
        
        Action apropos = new AbstractAction("A propos...") {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub

            }

        };
        aide.add(apropos);

        frame.setJMenuBar(jmb);

    }

    /**
     * initStateBar - DOCME Code This method creates the client's state bar.
     * <code>exemple d'appel de la methode</code>
     * 
     * @author FlexiTeam - Adrien Bouvet
     * @date 14 déc. 2004
     */
    void initStateBar()
    {

    }

    /**
     * Icon Loader
     * @param c class from where to get ressource
     * @param fileName name of ressource
     */
    public static Icon getIcon(Class c, String fileName) {
        URL url = c.getResource(fileName);
        if (url == null)
            return null;
        return new ImageIcon(url);
    }

}
