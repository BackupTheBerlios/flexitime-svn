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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import org.jgroups.SetStateEvent;

import com.jgoodies.plaf.HeaderStyle;
import com.jgoodies.plaf.Options;
import com.jgoodies.plaf.plastic.Plastic3DLookAndFeel;

import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.common.rmi.admin.IUserListener;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.richClient.gui.actions.bar.*;
import fr.umlv.ir3.flexitime.richClient.gui.panel.MainPanel;
import fr.umlv.ir3.flexitime.richClient.gui.panel.ManagementView;
import fr.umlv.ir3.flexitime.richClient.gui.panel.exploitation.ExploitationView;
import fr.umlv.ir3.flexitime.richClient.gui.views.LoginView;
import fr.umlv.ir3.flexitime.richClient.gui.views.UsersManagementView;

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
    private static JSplitPane mngmtPanel;
    private static MainPanel accueilView;
    private static JScrollPane accueilPanel;
    private JPanel jp_status;
    private static JLabel status;
    private static ButtonGroup butGpExploit;
    private static JButton butLargerGap;
    private static JButton butSmallerGap;
    private static JButton butPrevInterval;
    private static JButton butBack;
    private static JButton butSmallerTimeTable;
    private static JButton butLargerTimeTable;
    private static JButton butNext;
    private static JButton butNextInterval;
    private static JLabel labTrackAct;
    private static IUser iUser;
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
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 600);
        
        ImageIcon icon = new ImageIcon(getClass().getResource(language.getText("flexIcone32"))); //$NON-NLS-1$
        frame.setIconImage(icon.getImage());
        
        //gestion conteneurs
        mainPanel = new JPanel(new BorderLayout());
        frame.setContentPane(mainPanel);
        centerPanel = new JLayeredPane();
        mainPanel.add(centerPanel, BorderLayout.CENTER);
       
        accueilView = new MainPanel();
        accueilPanel = accueilView.getPanel();
        
        //initialisation des barres
        initMenuBar();
        initToolBar();
        initStateBar();
        
        frame.setVisible(true);
        setStatus("Chargement");
        
        frame.addWindowListener(new WindowListener(){
            public void windowActivated(WindowEvent arg0){}
            public void windowClosed(WindowEvent arg0){}
            public void windowClosing(WindowEvent arg0)
            {
                int res = JOptionPane.showConfirmDialog(null,language.getText("msg7"),language.getText("exit"),JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);  //$NON-NLS-1$//$NON-NLS-2$
                if(res == JOptionPane.YES_OPTION)
                {
                    try {
                        RemoteDataManager.getUserManager().disconnect(iUser);
                    }
                    catch (RemoteException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.exit(0);                
                }
            }
            public void windowDeactivated(WindowEvent arg0){}
            public void windowDeiconified(WindowEvent arg0) {}
            public void windowIconified(WindowEvent arg0){}
            public void windowOpened(WindowEvent arg0){}
        });
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
                    System.out.println(c + "\n\t" + c.getPreferredSize()); //$NON-NLS-1$
                    w = Math.max(w, c.getPreferredSize().width);
                    h = Math.max(h, c.getPreferredSize().height);
                }
                System.out.println(w + ", " + h); //$NON-NLS-1$
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
        //TODO if(user!=null && user.getPrefs().getDefaultTrack() != null)
        //{ setExploitMode() Mettre une filière en paramètre ???????
        //}else
        setAccueilMode();
        setStatus("Prêt");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        toolBar.add(PrintAction.getButton());
      
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
        Font v = new Font("Arial", Font.BOLD, 12); //$NON-NLS-1$
        labDateAct.setFont(v);
        String dateActuelle = language.formatLongDate(new Time()) + "   "; //$NON-NLS-1$
        labDateAct.setText(dateActuelle);
        toolBar.add(labDateAct);
        
        
        //filière actuelle
        labTrackAct = new JLabel();
        labTrackAct.setFont(v);
        String filiereActuelle = " |    " + language.getText("track") + " : "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        /*TODO ajouter la filiere a l'affichage 
        if( (String s = UserImpl.getTrack()) != null)
        {
            filiereActuelle += s;
        }
        else*/
            filiereActuelle += "aucune  "; //$NON-NLS-1$
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
        JMenu menuFichier = new JMenu(language.getText("file")); //$NON-NLS-1$
        menuBar.add(menuFichier);

        //Preferences
        Action pref = PreferencesAction.getInstance();
        menuFichier.add(pref);

        //Print
        Action print = PrintAction.getInstance();
        PrintAction.setExploitView(exploitView);
        menuFichier.add(print);
        
        menuFichier.add(new JSeparator());
        
        //Import
        Action impor = new AbstractAction(language.getText("import")) {

            public void actionPerformed(ActionEvent e)
            {
            // TODO Auto-generated method stub
                System.out.println("Faire fonction Importer...."); //$NON-NLS-1$
            }

        };
        menuFichier.add(impor);
        
        //Export
        Action export = ExportAction.getInstance();
        menuFichier.add(export);
        
        menuFichier.add(new JSeparator());
        
        //Gestion users
        Action usersMngmt = new AbstractAction("Gestion des utilisateurs") {
            public void actionPerformed(ActionEvent arg0)
            {
                UsersManagementView umv = new UsersManagementView();
                umv.printView(frame);
            }
        };
        menuFichier.add(usersMngmt);
        
        menuFichier.add(new JSeparator());
        
        //Logout
        Action logout = new AbstractAction(language.getText("logout")) {
            public void actionPerformed(ActionEvent e)
            {
                int res = JOptionPane.showConfirmDialog(null,language.getText("msg6"),language.getText("logout"),JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
                if(res == JOptionPane.YES_OPTION)
                {
                    setAccueilMode();
                    try
                    {
                        RemoteDataManager.getUserManager().disconnect(iUser);
                    }
                    catch (RemoteException e1)
                    {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    iUser = null;
                    //TODO loginView.reset();
                    if( !checkLogin())
                    {
                        JOptionPane.showMessageDialog(null, language.getText("errLogin1"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
                        System.exit(1);
                    }
                    
                    //TODO JG, charger pref user notamment filière par défaut(si pas ds pref->afficher view)
                    System.out.println("apres logout : charger "+ iUser.getName() + " prefs"); //$NON-NLS-1$ //$NON-NLS-2$
                }
                else
                {}
            }
        };
        menuFichier.add(logout);
        
        //Quitter
        Action quit = new AbstractAction(language.getText("quit")) { //$NON-NLS-1$

            public void actionPerformed(ActionEvent e)
            {
                int res = JOptionPane.showConfirmDialog(null,language.getText("msg7"),language.getText("exit"),JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);  //$NON-NLS-1$//$NON-NLS-2$
                if(res == JOptionPane.YES_OPTION)
                {
                    /* Demande trop de temps ;-)
                    try {
                        RemoteDataManager.getUserManager().disconnect(iUser);
                    }
                    catch (RemoteException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }*/
                    System.exit(0);                
                }
            }
        };
        menuFichier.add(quit);

        
        //////////
        // Mail //
        //////////
        JMenu menuMail = new JMenu(language.getText("mail")); //$NON-NLS-1$
        menuBar.add(menuMail);
        
        Action sendMail = MailAction.getInstance();
        menuMail.add(sendMail);

        JMenu formatedMail = new JMenu(language.getText("preFormatedMail")); //$NON-NLS-1$
        menuMail.add(formatedMail);
        
        Action sendPreFormatedClassMail = MailPreFormatedClassAction.getInstance();
        formatedMail.add(sendPreFormatedClassMail);
                
        Action sendPreFormatedTeacherMail = MailPreFormatedTeacherAction.getInstance();
        formatedMail.add(sendPreFormatedTeacherMail);
        
        

        
        ///////////////
        // Affichage //
        ///////////////
        JMenu menuAffichage = new JMenu(language.getText("view")); //$NON-NLS-1$
        menuBar.add(menuAffichage);
        
        JMenu mode = new JMenu(language.getText("mode")); //$NON-NLS-1$
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
        JMenu menuAide = new JMenu(language.getText("help")); //$NON-NLS-1$
        menuBar.add(menuAide);
        
        Action aideenligne = new AbstractAction(language.getText("helpOnline")) { //$NON-NLS-1$

            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                //ouvre la fenetre aide en ligne
                System.out.println("ouvrir fenetre Aide en ligne..."); //$NON-NLS-1$
            }

        };
        menuAide.add(aideenligne);
        
        // a propos //
        Action apropos = new AbstractAction(language.getText("about")) {//$NON-NLS-1$

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
        status = new JLabel(language.getText("ready")); //$NON-NLS-1$
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
    public static void setStatus(String etat)
    {
        status.setText(etat);
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
        File f = new File("Conf.xml"); //$NON-NLS-1$
        //si le fichier Conf.xml existe deja on utilise l'ip du server inclue
        if(f.canRead()) 
        {
            //System.out.println("fichier conf présent"); //$NON-NLS-1$
            BufferedReader br = null;
            String ligne;

            try {
                br = new BufferedReader(new FileReader(f));
            }
            catch(FileNotFoundException exc) {
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
            //System.out.println("fichier conf NON présent"); //$NON-NLS-1$
            enterIPServer();
        }
        
        System.out.println("Le serveur est up"); //$NON-NLS-1$
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
        String serverIP = " "; //$NON-NLS-1$
        while(res!=0)
        {
            serverIP = JOptionPane.showInputDialog(language.getText("errClientConf")); //$NON-NLS-1$
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
    private static boolean checkLogin()
    {
        String login = null;
        String pass;
        boolean test = false;
        
        while(test == false)
        {
            loginView.getFrame().setVisible(true);
            
            login = loginView.getLogin();
            pass = loginView.getPass();
            
            try {
                if(RemoteDataManager.getUserManager().ConnectToRich(login, pass))
                {
                    System.out.println("login="+login+", pass="+pass + " => OK");  //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
                    test = true;
                    try {
                        iUser = RemoteDataManager.getUserManager().get(login);
                        RemoteDataManager.getUserManager().addUserListener(iUser, new userListener());
                    } catch (RemoteException e) {
                        JOptionPane.showMessageDialog(null, language.getText("errLogin1"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
                    }    
                    return true;
                }
                JOptionPane.showMessageDialog(null, language.getText("errLogin2"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(null, language.getText("errLogin1"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
            }
            
            //test fictif...
            /*if(login.compareTo(pass) == 0)
            {
                System.out.println("Test fictif : login="+login+", pass="+pass + " => OK");  //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
                test = true;
                try {
					iUser = RemoteDataManager.getUserManager().get(login);
                    RemoteDataManager.getUserManager().addUserListener(iUser, new userListener());
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("Test fictif : login="+login+", pass="+pass + " => KO");   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
            }*/
        }
        
        return false;
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
        PrintAction.getInstance().setEnabled(true);
        labTrackAct.setVisible(true);
        enableButGpExploit();
        if(exploitPanel==null)
        {
            setStatus("Chargement...");
            FlexiProgressMonitor fpm = new FlexiProgressMonitor();
            fpm.run();
            exploitView = new ExploitationView();
            exploitPanel = (JPanel)exploitView.getPanel();
            centerPanel.add(exploitPanel, JLayeredPane.PALETTE_LAYER);
            fpm.stop();
            setStatus("Prêt");
        }
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
        PrintAction.getInstance().setEnabled(false);
        labTrackAct.setVisible(false);
        disableButGpExploit();
        if(mngmtPanel == null)
        {
            setStatus("Chargement...");
            FlexiProgressMonitor fpm = new FlexiProgressMonitor();
            fpm.run();
            try {
                mngmtView = new ManagementView();
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(null, language.getText("errMngmt1"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
                setAccueilMode();
            }
            mngmtPanel   = mngmtView.getJSP(); 
            centerPanel.add(mngmtPanel, JLayeredPane.PALETTE_LAYER);
            fpm.stop();
            setStatus("Prêt");
        }
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
        PrintAction.getInstance().setEnabled(false);
        labTrackAct.setVisible(false);
        disableButGpExploit();
        centerPanel.moveToFront(accueilPanel);
        centerPanel.validate();
        centerPanel.repaint();
    }
    
    
    private static class userListener extends UnicastRemoteObject implements IUserListener
    {

        /**
         * DOCME
         * @throws RemoteException
         */
        protected userListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 1L;

        /**
         * DOCME Description
         * Quel service est rendu par cette méthode
         * <code>exemple d'appel de la methode</code>
         *
         * @return IUser connected
         * @throws RemoteException
         *
         * @see fr.umlv.ir3.flexitime.common.rmi.admin.IUserListener#getUser()
         */
        public IUser getUser() throws RemoteException
        {
            return iUser;
        }
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
            JOptionPane.showMessageDialog(null, language.getText("errClientConf2"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
            System.exit(1);
        }
        
        //gestion login
        loginView = new LoginView(frame);
        if( !checkLogin() )
        {
            JOptionPane.showMessageDialog(null, language.getText("errLogin1"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
            System.exit(1);
        }
        
        //TODO JG, charger pref user notamment filière par défaut(si pas ds pref->afficher view)
        System.out.println("charge "+ iUser.getName() + " prefs"); //$NON-NLS-1$ //$NON-NLS-2$
        //PreferencesImpl prefs = new PreferencesImpl();
        
        Client c = new Client();
        
        
        splash.close();
        c.run();
    }

}

