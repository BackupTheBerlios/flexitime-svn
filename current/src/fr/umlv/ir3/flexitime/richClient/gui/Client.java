/*
 * Created on 12 déc. 2004
 * by Adrien BOUVET
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import com.jgoodies.plaf.HeaderStyle;
import com.jgoodies.plaf.Options;
import com.jgoodies.plaf.plastic.Plastic3DLookAndFeel;

import fr.umlv.ir3.flexitime.common.data.admin.impl.PreferencesImpl;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
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
import fr.umlv.ir3.flexitime.richClient.gui.panel.MainView;
import fr.umlv.ir3.flexitime.richClient.gui.views.IPServerView;
import fr.umlv.ir3.flexitime.richClient.gui.views.LoginView;
import fr.umlv.ir3.flexitime.server.core.admin.UserManager;

/**
 * Client This class build an graphic interface for the user.
 * 
 * @version 0.1
 * @author FlexiTeam - Adrien BOUVET
 */
public class Client
{
    // ====== //
    // Champs //
    // ====== //
    private JFrame frame;
    private static LoginView loginView;
    private JPanel panel;
    private JPanel jp_status;
    private JLabel status;
    private static String user;
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
        ImageIcon icon = new ImageIcon(getClass().getResource("FlexiTime_icone32.png"));
        frame.setIconImage(icon.getImage());
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
        MainView mainPanel = new MainView();
        frame.add(mainPanel.getPanel());
        frame.setVisible(true);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        
        //plage + large  !!!modif constructeur by Binou, ExploitationView needed !!!
        //toolBar.add(createButton((LargerTimeTableAction.getInstance())));
        
        //plage + petite
        //toolBar.add(createButton((SmallerTimeTableAction.getInstance())));
        
        //Back
        //toolBar.add(createButton(PreviousWeekAction.getInstance()));
        
        //Forward
        //toolBar.add(createButton(NextWeekAction.getInstance()));
        
        
        
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
        // Fichier
        JMenu menuFichier = new JMenu("Fichier");
        menuBar.add(menuFichier);

        //Preferences
        Action pref = PreferencesAction.getInstance();
        menuFichier.add(pref);

        //Print
        Action print = PrintAction.getInstance();
        menuFichier.add(print);
        
        menuFichier.add(new JSeparator());
        
        //Import
        Action impor = new AbstractAction("Importer") {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub

            }

        };
        menuFichier.add(impor);
        
        //Export
        Action export = ExportAction.getInstance();
        menuFichier.add(export);
        
        menuFichier.add(new JSeparator());
        
        //Logout
        Action logout = new AbstractAction("Logout") {
        public void actionPerformed(ActionEvent e)
        {
            int res = JOptionPane.showConfirmDialog(null,"Souhaitez-vous réellement vous délogger?","Se désauthentifier",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(res == JOptionPane.YES_OPTION)
            {
                //TODO fermer panel exploit et/ou mngmt
                user = null;
                loginView.setLogin("");
                loginView.setRepack(); //TODO ne marche pas ....
                if( (user = checkLogin()) == null)
                {
                    System.out.println("problème lors de l'authentification");
                    System.exit(1);
                }
                
                //TODO JG, charger pref user notamment filière par défaut(si pas ds pref->afficher view)
                System.out.println("apres logout : charge "+ user + " prefs");
            }
            else
            {}
        }
        };
        menuFichier.add(logout);
        
        //Quitter
        Action quit = new AbstractAction("Quitter") {

            public void actionPerformed(ActionEvent e)
            {
                int res = JOptionPane.showConfirmDialog(null,"Souhaitez-vous quitter FlexiTime?","Quitter l'application",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(res == JOptionPane.YES_OPTION)
                {
                    //System.out.println("YES quit");
                    //TODO Est-ce propre de quitter de cette facon ?
                    System.exit(0);                
                }
                else
                {
                    //System.out.println("NO quit");   
                }
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
        
        Action aideenligne = new AbstractAction("Aide en ligne...") {

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
        File f = new File("Conf.xml");
        //si le fichier Conf.xml existe deja on utilise l'ip du server inclue
        if(f.canRead()) 
        {
            System.out.println("fichier conf présent");
            BufferedReader br = null;
            String ligne;

            try {
                br = new BufferedReader(new FileReader(f));
            }
            catch(FileNotFoundException exc) {
                System.out.println("Fichier conf illisible");
                enterIPServer();
                return 0;
            }
            try {
                ligne = br.readLine();
				res = testIPServer(ligne);
                br.close();
            }
            catch (IOException e) {}
            if(res != 0) enterIPServer();
        }
        
        //sinon on demande l'ip du server
        else
        {
            System.out.println("fichier conf NON présent");
            enterIPServer();
        }
        
        System.out.println("Le serveur est up");
        return 0;
    }
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     */
    private static void enterIPServer()
    {
        int res = 1;
        String serverIP = " ";
        while(res!=0)
        {
            serverIP = JOptionPane.showInputDialog("Le serveur ne répond pas ou est mal configuré !\nEntrez l'adresse IP du serveur");
            res = testIPServer(serverIP);
        }
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
        RemoteDataManager.setIpServer(ip);
        if(RemoteDataManager.getManager()==null)
            return -1;
        return 0;
    }
    
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param loginFrame
     * @return the name of the user logged in.
     * 
     */
    private static String checkLogin()
    {
        String login = "";
        char[] pass;
        while(login.compareTo("") == 0)
        {
            loginView.getFrame().setVisible(true);
            
            //System.out.println("new login="+loginView.getLogin());
            

            //tant que l'utilisateur n'a pas rentré de login
            while( (login=loginView.getLogin()) == "" ) {}
            pass = loginView.getPass();
            
            //TODO verifier user / login sur server (bdd flexitime)
            //test fictif...
            String password = new String(pass);
            System.out.println("login="+login+", pass="+password);
            if(login.compareTo(password) == 0)
            {
                System.out.println("ok");
                loginView.getFrame().dispose();
            }
            else
            {
                login = "";
                loginView.setLogin("");
                //message erreur avec Continuer ou Arreter ?
                System.out.println("ko");
            }
        }
        return login;
    }
    
    
  
    // ==== //
    // Main //
    // ==== //
    /**
     * main - DOCME Code This main method instanciates an Client object and call
     * the run() method on it. <code>exemple d'appel de la methode</code>
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // Splash image
        FlexiSplash splash = new FlexiSplash();
        splash.setVisible(true);
        
        // gestion contact du serveur
        if( initConf() != 0 )
        {
            System.out.println("serveur injoignable");
            System.exit(1);
        }
        
        //gestion login
        loginView = new LoginView();
        if( (user = checkLogin()) == null)
        {
            System.out.println("problème lors de l'authentification");
            System.exit(1);
        }
        
        //TODO JG, charger pref user notamment filière par défaut(si pas ds pref->afficher view)
        System.out.println("charge "+ user + " prefs");
        PreferencesImpl prefs = new PreferencesImpl();
        
        // gestion fenetre principale
        try
        {
            //definition d'un look&feel
            //TODO garder celui-ci ?? en trouver un + bleu...
            //lister LF d'un windows et les checker....
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
            //System.out.println(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {}
        
        Client c = new Client();
        
        
        splash.close();
        c.run();
    }

}
