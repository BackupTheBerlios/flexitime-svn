/*
 * Created on 12 déc. 2004
 * by Adrien BOUVET
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Enumeration;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.*;
import fr.umlv.ir3.flexitime.richClient.gui.panel.MainView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.ManagementView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.ExploitationView;
import fr.umlv.ir3.flexitime.richClient.gui.views.LoginView;

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
    private static JFrame frame;
    private static LoginView loginView;
    private static JPanel mainPanel;
    private static JLayeredPane centerPanel;
    private static ExploitationView exploitView;
    private static JPanel exploitPanel;
    private static ManagementView mngmtView;
    private static JPanel mngmtPanel;
    private static MainView accueilView;
    private static JScrollPane accueilPanel;
    private JPanel jp_status;
    private JLabel status;
    private static String user;
    private static ButtonGroup butGpExploit;
    private static JButton butLargerGap;
    private static JButton butSmallerGap;
    private static JButton butPrevInterval;
    private static JButton butBack;
    private static JButton butSmallerTimeTable;
    private static JButton butLargerTimeTable;
    private static JButton butNext;
    private static JButton butNextInterval;
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
        frame = new JFrame(language.getText("appliTitle")); //$NON-NLS-1$
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ImageIcon icon = new ImageIcon(getClass().getResource("pictures/FlexiTime_icone32.png"));
        frame.setIconImage(icon.getImage());
        
        //gestion conteneurs
        mainPanel = new JPanel(new BorderLayout());
        frame.setContentPane(mainPanel);
        centerPanel = new JLayeredPane();
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        
        
        //construction des 3 panels principaux
        accueilView = new MainView();
        exploitView = new ExploitationView();
		try {
			mngmtView = new ManagementView();
		} catch (RemoteException e) {
            //TODO pop up
            System.out.println("mngmtView inouvrable");
		}
        accueilPanel = accueilView.getPanel();
        exploitPanel = (JPanel)exploitView.getPanel();
        mngmtPanel   = mngmtView.getPanel(); 
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

        centerPanel.setLayout(new LayoutManager() {
            public void addLayoutComponent(String s, Component c) {
            }
            public void removeLayoutComponent(Component c) {
            }

            public Dimension preferredLayoutSize(Container parent) {
                int w = 0, h = 0;
                int n = parent.getComponentCount();
                for (int i = 0; i < n; i++) {
                    Component c = parent.getComponent(i);
                    System.out.println(c + "\n\t" + c.getPreferredSize());
                    w = Math.max(w, c.getPreferredSize().width);
                    h = Math.max(h, c.getPreferredSize().height);
                }
                System.out.println(w + ", " + h);
                return new Dimension(w, h);
            }

            public Dimension minimumLayoutSize(Container parent) {
                int w = 0, h = 0;
                int n = parent.getComponentCount();
                for (int i = 0; i < n; i++) {
                    Component c = parent.getComponent(i);
                    w = Math.max(w, c.getPreferredSize().width);
                    h = Math.max(h, c.getPreferredSize().height);
                }
                return parent.getMaximumSize();
            }

            public void layoutContainer(Container parent) {
                int n = parent.getComponentCount();
                for (int i = 0; i < n; i++) {
                    Component c = parent.getComponent(i);
                    c.setBounds(0, 0, parent.getWidth(), parent.getHeight());
                }
            }
        });
        centerPanel.add(accueilPanel, JLayeredPane.PALETTE_LAYER);
        centerPanel.add(exploitPanel, JLayeredPane.PALETTE_LAYER);
        centerPanel.add(mngmtPanel, JLayeredPane.PALETTE_LAYER);
        //TODO if(user.getPrefs().getDefaultTrack() != null)
        //{ setExploitMode() Mettre une filière en paramètre ???????
        //}else
        setAccueilMode();
        frame.setVisible(true);
        //TODO frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return 0;
    }

    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param action
     * @return a button
     */
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
        toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.X_AXIS));
        toolBar.putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);
        mainPanel.add(toolBar, BorderLayout.PAGE_START);
        
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

        butGpExploit = new ButtonGroup();
        //gap + petit
        butSmallerGap = createButton(SmallerGapAction.getInstance(exploitView));
        butGpExploit.add(butSmallerGap);
        toolBar.add(butSmallerGap);
        
        //gap + grand
        butLargerGap = createButton(LargerGapAction.getInstance(exploitView));
        butGpExploit.add(butLargerGap);
        toolBar.add(butLargerGap);
        
        //full back
        butPrevInterval = createButton(PreviousIntervalAction.getInstance(exploitView));
        butGpExploit.add(butPrevInterval);
        toolBar.add(butPrevInterval);
        
        //Back
        butBack = createButton(PreviousWeekAction.getInstance(exploitView));
        butGpExploit.add(butBack);
        toolBar.add(butBack);
        
        //plage + petite
        butSmallerTimeTable = createButton((SmallerTimeTableAction.getInstance(exploitView)));
        butGpExploit.add(butSmallerTimeTable);
        toolBar.add(butSmallerTimeTable);
        
        //plage + large
        butLargerTimeTable = createButton((LargerTimeTableAction.getInstance(exploitView)));
        butGpExploit.add(butLargerTimeTable);
        toolBar.add(butLargerTimeTable);
        
        //Forward
        butNext = createButton(NextWeekAction.getInstance(exploitView));
        butGpExploit.add(butNext);
        toolBar.add(butNext);
        
        //full forward
        butNextInterval = createButton(NextIntervalAction.getInstance(exploitView));
        butGpExploit.add(butNextInterval);
        toolBar.add(butNextInterval);
        
        
        toolBar.add(Box.createHorizontalGlue());
        
        
        //date actuelle
        JLabel labDateAct = new JLabel() ;
        Font v = new Font("Arial", Font.BOLD, 12);
        labDateAct.setFont(v);
        String dateActuelle = language.formatLongDate(new Time()) + " | ";
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
            filiereActuelle += "aucune  ";
        labTrackAct.setText(filiereActuelle);
        toolBar.add(labTrackAct);
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
                setAccueilMode();
                user = null;
                //TODO loginView.reset();
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
            }
        };
        menuFichier.add(quit);

        
        //////////
        // Mail //
        //////////
        JMenu menuMail = new JMenu("Mail");
        menuBar.add(menuMail);
        
        Action sendMail = MailAction.getInstance();
        menuMail.add(sendMail);

        JMenu formatedMail = new JMenu("Envoyer Mail pré formaté...");
        menuMail.add(formatedMail);
        
        Action sendPreFormatedClassMail = MailPreFormatedClassAction.getInstance();
        formatedMail.add(sendPreFormatedClassMail);
                
        Action sendPreFormatedTeacherMail = MailPreFormatedTeacherAction.getInstance();
        formatedMail.add(sendPreFormatedTeacherMail);
        
        

        
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
                System.out.println("ouvrir fenetre Aide en ligne...");
            }

        };
        menuAide.add(aideenligne);
        
        // a propos //
        Action apropos = new AbstractAction("A propos...") {

            public void actionPerformed(ActionEvent e)
            {
                setAccueilMode();
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
        
        mainPanel.add(jp_status,BorderLayout.SOUTH);
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
        String login = null;
        String pass;
        boolean test = false;
        
        while(test == false)
        {
            loginView.getFrame().setVisible(true);
            
            login = loginView.getLogin();
            pass = loginView.getPass();
            
            //TODO JG, verifier user / login sur server (bdd flexitime)
            //test fictif...
            if(login.compareTo(pass) == 0)
            {
                System.out.println("Test fictif : login="+login+", pass="+pass + " => OK");
                test = true;
            }
            else
            {
                System.out.println("Test fictif : login="+login+", pass="+pass + " => KO");
            }
        }
        
        return login;
    }
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     */
    private static void enableButGpExploit()
    {
        for (Enumeration e = butGpExploit.getElements() ; e.hasMoreElements() ;) {
            ((JButton)e.nextElement()).setEnabled(true);
        }
    }
    
    /**
     *  
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     */
    private static void disableButGpExploit()
    {
        for (Enumeration e = butGpExploit.getElements() ; e.hasMoreElements() ;) {
            ((JButton)e.nextElement()).setEnabled(false);
        }
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     */
    public static void setExploitMode()
    {
        enableButGpExploit();
        centerPanel.moveToFront(exploitPanel);
        centerPanel.validate();
        centerPanel.repaint();
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     */
    public static void setMngmtMode()
    {
        disableButGpExploit();
        centerPanel.moveToFront(mngmtPanel);
        centerPanel.validate();
        centerPanel.repaint();
    }
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     */
    public static void setAccueilMode()
    {
        disableButGpExploit();
        centerPanel.moveToFront(accueilPanel);
        centerPanel.validate();
        centerPanel.repaint();
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
        // gestion fenetre principale
        try
        {
            //definition d'un look&feel
            //TODO garder celui-ci ?? en trouver un + bleu...
            //lister LF d'un windows et les checker....
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        }
        catch (Exception e)
        {}
        
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
        loginView = new LoginView(frame);
        if( (user = checkLogin()) == null)
        {
            System.out.println("problème lors de l'authentification");
            System.exit(1);
        }
        
        //TODO JG, charger pref user notamment filière par défaut(si pas ds pref->afficher view)
        System.out.println("charge "+ user + " prefs");
        PreferencesImpl prefs = new PreferencesImpl();
        
        Client c = new Client();
        
        
        splash.close();
        c.run();
    }

}
