/*
 * Created on 12 déc. 2004
 * by Adrien Bouvet
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import com.jgoodies.plaf.HeaderStyle;
import com.jgoodies.plaf.Options;
import com.jgoodies.plaf.plastic.Plastic3DLookAndFeel;

import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.ExploitationAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.ExportAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.GestionAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.HistoryAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.LargerTimeTableAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.LogoutAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.MailAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.NextWeekAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.PreferencesAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.PreviousWeekAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.PrintAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.SmallerTimeTableAction;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.StatsAction;
import fr.umlv.ir3.flexitime.richClient.gui.views.IPServerView;

/**
 * Client This class build an graphic interface for the user.
 * 
 * @version 0.1
 * @author FlexiTeam - Adrien Bouvet
 */
public class Client
{
    // ====== //
    // Champs //
    // ====== //
    private JFrame frame;
    private JPanel panel;
    private JPanel jp_status;
    private JLabel status;
    private static FlexiLanguage language;
    static
    {
        language = FlexiLanguage.getInstance();
    }

    
    // ============ //
    // Constructeur //
    // ============ //
    /**
     * DOCME
     */
    public Client()
    {
        frame = new JFrame(language.getText("appliTitle"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        panel = new JPanel(new BorderLayout());
        frame.setContentPane(panel);
    }

    
    // ======== //
    // Méthodes //
    // ======== //
    /**
     * run - DOCME Code This method runs the Client object.
     * <code>exemple d'appel de la methode</code>
     * 
     * @return an int which indicates if the method is well finished.
     */
    int run()
    {
        initMenuBar();
        initToolBar();
        initStateBar();
        frame.setVisible(true);
        //TODO frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return 0;
    }

    private static JButton createButton(Action action)
    {
        JButton button = new JButton();
        button.setIcon((Icon)action.getValue(Action.SMALL_ICON));
        button.setToolTipText((String)action.getValue(Action.NAME));
        button.addActionListener(action);
        
        return button;
    }
    /**
     * initToolBar - DOCME Code This method creates the client's tool bar.
     * <code>exemple d'appel de la methode</code>
     * 
     */
    void initToolBar()
    {
        JToolBar toolBar = new JToolBar();
        toolBar.putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);
        panel.add(toolBar, BorderLayout.PAGE_START);
        
        //Imprimer
        toolBar.add(createButton(PrintAction.getInstance()));
      
        //Export
        toolBar.add(createButton(ExportAction.getInstance()));
        
        //Mail
        toolBar.add(createButton(MailAction.getInstance()));
        
        toolBar.addSeparator();
        
        //Gestion
        toolBar.add(createButton(GestionAction.getInstance()));
        
        //Exploitation
        toolBar.add(createButton(ExploitationAction.getInstance()));
        
        //Historique
        toolBar.add(createButton(HistoryAction.getInstance()));
        
        //Stats
        toolBar.add(createButton(StatsAction.getInstance()));
        
        toolBar.addSeparator();
        
        //plage + large
        toolBar.add(createButton((LargerTimeTableAction.getInstance())));
        
        //plage + petite
        toolBar.add(createButton((SmallerTimeTableAction.getInstance())));
        
        //Back
        toolBar.add(createButton(PreviousWeekAction.getInstance()));
        
        //Forward
        toolBar.add(createButton(NextWeekAction.getInstance()));
        
        
        
        toolBar.addSeparator();
        toolBar.addSeparator();
        toolBar.addSeparator();
        toolBar.addSeparator();
        
        
        //date actuelle
        JLabel labDateAct = new JLabel() ;
        Font v = new Font("Arial", Font.BOLD, 12);
        labDateAct.setFont(v);
        int jSemaine, jMois, mois, annee ;
        Calendar now = Calendar.getInstance() ;
        String dateActuelle ="";
        jSemaine = now.get(Calendar.DAY_OF_WEEK);
        jMois = now.get(Calendar.DAY_OF_MONTH);
        mois = now.get(Calendar.MONTH);
        annee = now.get(Calendar.YEAR);
        dateActuelle += jourSemaine(jSemaine);
        dateActuelle += ", "+ Integer.toString(jMois) + " " ;
        dateActuelle += moisDeLannee(mois);
        dateActuelle += " "+ Integer.toString(annee) + " | ";
        labDateAct.setText(dateActuelle);
        toolBar.add(labDateAct);
        
        //filière actuelle
        JLabel labTrackAct = new JLabel();
        labTrackAct.setFont(v);
        String filiereActuelle = language.getText("track") + " : ";
        /*TODO if( (String s = UserImpl.getTrack()) != null)
        {
            filiereActuelle += s;
        }
        else*/
            filiereActuelle += "aucune";
        labTrackAct.setText(filiereActuelle);
        toolBar.add(labTrackAct);
    }

    
     
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param j an integer representing the actual day.
     * @return the french translation for the actual day.
     * 
     */
    private String jourSemaine(int j)
    {
        switch(j)
        {
            case 1 :
                return "Dimanche" ;
            case 2 :
                return "Lundi" ;
            case 3 :
                return "Mardi" ;
            case 4 :
                return "Mercredi" ;
            case 5 :
                return "Jeudi" ;
            case 6 :
                return "Vendredi" ;
            case 7 :
                return "Samedi" ;
        }
        return "inconnu";
    }
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param j an integer representing the actual month.
     * @return the french translation for the actual month.
     * 
     */
    private String moisDeLannee(int j)
    {
        switch(j)
            {
            case 0 :
                return "Janvier" ;
            case 1 :
                return "Février" ;
            case 2 :
                return "Mars" ;
            case 3 :
                return "Avril" ;
            case 4 :
                return "Mai" ;
            case 5 :
                return "Juin" ;
            case 6 :
                return "Juillet" ;
            case 7 :
                return "Août" ;
            case 8 :
                return "Septembre" ;
            case 9 :
                return "Octobre" ;
            case 10 :
                return "Novembre" ;
            case 11 :
                return "Décembre" ;
            }
        return "inconnu";
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
        JMenuBar menuBar = new JMenuBar();
        menuBar.putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);

        //////////
        // File //
        //////////
        JMenu menuFichier = new JMenu("Fichier");
        menuBar.add(menuFichier);

        Action pref = PreferencesAction.getInstance();
        menuFichier.add(pref);

        Action print = PrintAction.getInstance();
        menuFichier.add(print);
        menuFichier.add(new JSeparator());
        
        Action impor = new AbstractAction("Importer") {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub

            }

        };
        menuFichier.add(impor);
        
        Action export = ExportAction.getInstance();
        menuFichier.add(export);
        menuFichier.add(new JSeparator());
        
        Action log = LogoutAction.getInstance();
        menuFichier.add(log);
        
        Action quit = new AbstractAction("Quitter") {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub

            }

        };
        menuFichier.add(quit);

        
        //////////
        // Mail //
        //////////
        JMenu menuMail = new JMenu("Mail");
        menuBar.add(menuMail);
        
        Action sendView = MailAction.getInstance();
        menuMail.add(sendView);

        Action sendFormatedMail = new AbstractAction("Envoyer Mail pré formaté") {

            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                //ouvrir vue mail
            }

        };
        menuMail.add(sendFormatedMail);

        
        ///////////////
        // Affichage //
        ///////////////
        JMenu menuAffichage = new JMenu("Affichage");
        menuBar.add(menuAffichage);
        
        JMenu mode = new JMenu("Mode");
        menuAffichage.add(mode);
        
        Action gestion = GestionAction.getInstance();
        mode.add(gestion);
        
        Action exploitation = ExploitationAction.getInstance();
        mode.add(exploitation);
        
        Action historique = HistoryAction.getInstance();
        mode.add(historique);
        
        Action stats = StatsAction.getInstance();
        menuAffichage.add(stats);

        
        
        ///////////////////
        // Administration//
        ///////////////////

        // Aide en ligne //
        JMenu menuAide = new JMenu("Aide");
        menuBar.add(menuAide);
        
        Action aideenligne = new AbstractAction("Aide...") {

            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                //ouvre la fenetre aide en ligne
            }

        };
        menuAide.add(aideenligne);
        
        // a propos //
        Action apropos = new AbstractAction("A propos...") {

            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                //ouvre la fenetre a propos
            }

        };
        menuAide.add(apropos);

        frame.setJMenuBar(menuBar);
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
        jp_status = new JPanel();
        jp_status.setLayout(new BorderLayout());
        status = new JLabel("Prêt");
        jp_status.add(status, BorderLayout.CENTER);
        jp_status.setBorder(new BevelBorder(BevelBorder.LOWERED));
        
        frame.getContentPane().add(jp_status,BorderLayout.SOUTH);
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param etat the new state to print in the status bar.
     * 
     */
    public void setStatus(String etat)
    {
        JLabel lab = new JLabel(etat);
        this.status = lab;
        //TODO faire un refresh du panel ??
    }

    /**
     * DOCME Icon Loader
     * @param c class from where to get ressource
     * @param fileName name of ressource
     * @return an icon.
     */
    public static Icon getIcon(Class c, String fileName) {
        URL url = c.getResource(fileName);
        if (url == null)
            return null;
        return new ImageIcon(url);
    }
    
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return an int indicating if the method is well finished.
     * 
     */
    public static int initConf()
    {
        //1/ check si existance fichier conf en local
        //2/ si oui try contact @server
            //si ok, continuer traitement
            //si ko, 3/
        //3/ si non ouvrir vue demande @server puis retour en 2/
        
        
        int res = 1;
        File f = new File("Prefs.xml");
        //si le fichier Prefs.xml existe deja on utilise l'ip du server inclue
        if(f.canRead()) 
        {
            //System.out.println("fichier présent");
            BufferedReader br = null;
            String ligne;

            try {
                br = new BufferedReader(new FileReader(f));
            }
            catch(FileNotFoundException exc) {
                //TODO lancer exception : illisible, puis aller en 3/
                System.out.println("Erreur d'ouverture");
            }
            try {
                ligne = br.readLine();
				res = testIPServer(ligne);
                br.close();
            }
            catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            while(res!=0) {
                String line = IPServerView.printView();
                res = testIPServer(line);
            }

        }
        //sinon on demande l'ip du server
        else
        {
            //System.out.println("fichier NON présent");
            while(res!=0)
            {
                String line = IPServerView.printView();
                res = testIPServer(line);
            }
        }
        
        System.out.println("Le serveur est up");
        
        //TODO recup fichier de conf du server, créer méthode on it....
 
        return 0;
    }
    
    
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param ip
     * @return an int representing if the server is up or down.
     */
    private static int testIPServer(String ip)
    {
        //TODO appel méthode "hello" du server
        return 0;
    }
    
  
    // ==== //
    // Main //
    // ==== //
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
        
        initConf();
        
        try
        {
            //definition d'un look&feel
            //TODO garder celui-ci ??
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        }
        catch (Exception e)
        {}

        Client c = new Client();
        c.run();
    }

}
