/*
 * Created on 14 déc. 2004
 * by BOUVET Adrien
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.gui.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.models.management.UsersListModel;

/**
 * draws a frame where an administrator can manage the soft's users.
 * It is used to set password for users and also their permissions.
 * 
 * @version 0.2
 * @author FlexiTeam - BOUVET Adrien
 */
public class UsersManagementView
{

    private JDialog              userMngmtView;
    private JSplitPane           jspListOfUsers;
    private JScrollPane          listPanel;
    private JPanel               infosPanel;
    private PanelBuilder         builder;
    private String[]             permissions = { "administrateur", "secrétaire", "utilisateur" };

    private JTextField           tfLogin;
    private JTextField           tfPass;
    private JLabel               labPass;
    private JCheckBox            checkLDAP;
    private JComboBox            cbPermissions;
    private JButton              butOK;
    private JButton              butErase;
    private JButton              butCancel;

    private IUser                userSelected;

    private static FlexiLanguage language;
    static
    {
        language = FlexiLanguage.getInstance();
    }

    /**
     * printView - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param parentFrame
     */
    public void printView(JFrame parentFrame)
    {
        userMngmtView = new JDialog(parentFrame, "Gestion des utilisateurs", true); //$NON-NLS-1$

    /////////////////////////
    //panel de gauche (liste)
        List<IUser> listOfUsers = null;
        try
        {
            listOfUsers = RemoteDataManager.getUserManager().getAllUsers();
        }
        catch (RemoteException e)
        {
            JOptionPane.showMessageDialog(null, language.getText("errUserMngmt2"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE);
            userMngmtView.dispose();
        }
        final UsersListModel userModel = new UsersListModel(listOfUsers);
        final JList list = new JList(userModel);

        list.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent arg0)
            {
                if (!arg0.getValueIsAdjusting())
                {
                    int index = list.getSelectedIndex();
                    if(index == -1)
                        return;
                    IUser userTmp = (IUser) userModel.getElementAt(index);
                    setCurrentUser(userTmp);
                    updateInfosPanel(userTmp);
                    butOK.setText("Modifier");
                    butOK
                            .setToolTipText("Modifier les paramètres de l'utilisateur");
                }
            }

        });
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setCellRenderer(new DefaultListCellRenderer() {

            /**
             * Comment for <code>serialVersionUID</code>
             */
            private static final long serialVersionUID = 3979264742286504752L;

            public java.awt.Component getListCellRendererComponent(JList arg0,
                    Object arg1, int arg2, boolean arg3, boolean arg4)
            {
                JLabel c = (JLabel) super.getListCellRendererComponent(arg0,
                        arg1, arg2, arg3, arg4);

                c.setText( ( (IUser) arg1 ).getName());

                return c;
            }

        });

        final Action addUser = new AbstractAction() {

            /**
             * Comment for <code>serialVersionUID</code>
             */
            private static final long serialVersionUID = 3979264742286504752L;

            public void actionPerformed(ActionEvent arg0)
            {
                butOK.setText("ajouter");
                butOK.setToolTipText("Ajouter ce nouvel utilisateur");
                tfLogin.setText(""); //$NON-NLS-1$
                tfPass.setText(""); //$NON-NLS-1$
                tfPass.setEnabled(false);
                checkLDAP.setSelected(true);
                cbPermissions.setSelectedIndex(2);
            }

        };
        final Action removeUser = new AbstractAction() {

            /**
             * Comment for <code>serialVersionUID</code>
             */
            private static final long serialVersionUID = 3979264742286504752L;

            public void actionPerformed(ActionEvent arg0)
            {
                try
                {
                    RemoteDataManager.getUserManager().removeUser(userSelected);
                    userModel.removeUser(userSelected);
                }
                catch (RemoteException e)
                {
                    JOptionPane.showMessageDialog(null, language.getText("errUserMngmt2"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE);
                    userMngmtView.dispose();
                }
            }
        };

        list.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent arg0)
            {}

            public void mousePressed(MouseEvent arg0)
            {}

            public void mouseReleased(MouseEvent arg0)
            {
                if (arg0.isPopupTrigger())
                {
                    JList tmpList = (JList) arg0.getSource();
                    JPopupMenu popMenu;
                    String[] name = null;
                    Action[] action = null;
                    if (tmpList.getSelectedIndex() >= 0)
                    {
                        name = new String[] { "Ajouter un utilisateur", "Supprimer" };

                        action = new Action[] { addUser, removeUser };
                    }
                    else
                    {
                        name = new String[] { "Ajouter un utilisateur" };
                        action = new Action[] { addUser };
                    }
                    popMenu = createPopupMenu(name, action);
                    popMenu.show(arg0.getComponent(), arg0.getX(), arg0.getY());
                }
            }

            public void mouseEntered(MouseEvent arg0)
            {}

            public void mouseExited(MouseEvent arg0)
            {}
        });

        listPanel = new JScrollPane(list);

    /////////////////////////    
    //Panel de droite (infos)
        FormLayout layout = new FormLayout(
                "right:pref, 3dlu, pref, 3dlu, pref, 15dlu", // 6 columns//$NON-NLS-1$
                "9dlu, p, 3dlu, p, 3dlu, p, p, 3dlu, p, 3dlu, p, 9dlu, p"); // 13 rows//$NON-NLS-1$

        builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();

        // Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        // creation des components
        JLabel labExplication = new JLabel("(Pour ajouter/supprimer : clic droit sur un user)");
        tfLogin = new JTextField();
        tfLogin.setText("<le login>");//$NON-NLS-1$
        tfLogin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent arg0)
            {
                if (tfLogin.getText().compareTo("<le login>") == 0)//$NON-NLS-1$
                {
                    tfLogin.setText(""); //$NON-NLS-1$
                }
            }
            public void mousePressed(MouseEvent arg0) {}
            public void mouseReleased(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseExited(MouseEvent arg0) {}
        });
        tfPass = new JTextField();
        tfPass.setEnabled(false);
        labPass = new JLabel("Password :");
        labPass.setEnabled(false);
        final JLabel labLDAP1 = new JLabel("Cocher si le mot de passe du");
        final JLabel labLDAP2 = new JLabel("user est stocké dans le LDAP");
        checkLDAP = new JCheckBox("ldap");
        checkLDAP.setSelected(true);
        checkLDAP.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0)
            {
                if (checkLDAP.isSelected())
                {
                    tfPass.setEnabled(false);
                    labPass.setEnabled(false);
                }
                else
                {
                    tfPass.setEnabled(true);
                    labPass.setEnabled(true);
                }
            }
        });
        cbPermissions = new JComboBox(permissions);
        cbPermissions.setSelectedIndex(1);
        // cbPermissions.addActionListener(cbPermissions);

        
        //*******
        //boutons
        //*******
        butOK = new JButton("Ajouter");//$NON-NLS-1$
        butOK.setToolTipText("Ajouter ce nouvel utilisateur");
        butOK.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0)
            {
                if ( ( tfLogin.getText().compareTo("") != 0 && tfLogin.getText().compareTo("<le login>") != 0 ) && ( checkLDAP.isSelected() || tfPass.getText().compareTo("") != 0 )) //$NON-NLS-1$
                {
                    /*String s = "=>Ajouter " + tfLogin.getText();
                    if (checkLDAP.isSelected())
                        s += ", pass=<celui de ldap>";
                    else
                        s += ", pass=" + tfPass.getText();
                    s += ", droit="
                            + permissions[cbPermissions.getSelectedIndex()];
                    System.out.println(s);*/

                    if (butOK.getText().compareTo("Modifier") == 0)
                    {
                        userSelected.setName(tfLogin.getText());
                        if (checkLDAP.isSelected())
                            userSelected.setPassword(null);
                        else
                            userSelected.setPassword(tfPass.getText());
                        userSelected.setPrivilege(cbPermissions.getSelectedIndex());
                        try
                        {
                            RemoteDataManager.getUserManager().save(userSelected);
                        }
                        catch (RemoteException e)
                        {
                            JOptionPane.showMessageDialog(null, language.getText("errUserMngmt2"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE);
                            userMngmtView.dispose();
                        }
                    }
                    else
                    // on est dans Ajouter
                    {
                        if (checkLDAP.isSelected())
                            try
                            {
                                userSelected = DataFactory.createUser(tfLogin.getText(), cbPermissions.getSelectedIndex());
                            }
                            catch (FlexiException e)
                            {
                                JOptionPane.showMessageDialog(null, language.getText("errUserMngmt2"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE);
                                userMngmtView.dispose();
                            }
                        else
                            try
                            {
                                userSelected = DataFactory.createUser(tfLogin.getText(), tfPass.getText(), cbPermissions.getSelectedIndex()); 
                            }
                            catch (FlexiException e1)
                            {
                                JOptionPane.showMessageDialog(null, language.getText("errUserMngmt2"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE);
                                userMngmtView.dispose();
                            }
                        userModel.addUser(userSelected);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,language.getText("errUserMngmt1"), language.getText("erreur"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
            }
        });
        butErase = new JButton("Effacer");//$NON-NLS-1$
        butErase.setToolTipText("Effacer les champs du formulaire");
        butErase.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0)
            {
                tfLogin.setText(""); //$NON-NLS-1$
                tfPass.setText(""); //$NON-NLS-1$
                tfPass.setEnabled(false);
                checkLDAP.setSelected(true);
                cbPermissions.setSelectedIndex(2);
            }
        });
        butCancel = new JButton("Fermer"); //$NON-NLS-1$
        butCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0)
            {
                userMngmtView.dispose();
            }
        });

        
        
        // ajout des components au layout
        builder.add(labExplication,     cc.xyw (1, 2, 6));
        builder.addLabel("Login :",     cc.xy  (1, 4));
        builder.add(tfLogin,            cc.xyw (3, 4, 3));
        builder.add(checkLDAP,          cc.xywh(1, 6, 1, 2));
        builder.add(labLDAP1,           cc.xyw (3, 6, 3));
        builder.add(labLDAP2,           cc.xyw (3, 7, 3));
        builder.add(labPass,            cc.xy  (1, 9));
        builder.add(tfPass,             cc.xyw (3, 9, 3));
        builder.addLabel("Droits :",    cc.xy  (1, 11));
        builder.add(cbPermissions,      cc.xyw (3, 11, 3));
        builder.add(butOK,              cc.xy  (1, 13));
        builder.add(butErase,           cc.xy  (3, 13));
        builder.add(butCancel,          cc.xy  (5, 13));

        infosPanel = builder.getPanel();
        
        Dimension dim = new Dimension(350,200);
        infosPanel.setMinimumSize(dim);
        infosPanel.setPreferredSize(dim);

        // panel split
        jspListOfUsers = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, infosPanel);
        jspListOfUsers.setOneTouchExpandable(true);
        jspListOfUsers.setDividerLocation(100);

        // frame général
        userMngmtView.add(jspListOfUsers);
        userMngmtView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // ImageIcon icon = new
        // ImageIcon(getClass().getResource("../pictures/FlexiTime_icone32.png"));//$NON-NLS-1$
        // userMngmtView.setIconImage(icon.getImage());
        //userMngmtView.setSize(250, 200);
        userMngmtView.pack();
        userMngmtView.setResizable(true);
        // placement de la fenetre sur l'ecran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = userMngmtView.getPreferredSize();
        userMngmtView.setLocation(
                screenSize.width / 2 - ( labelSize.width / 2 ),
                screenSize.height / 2 - ( labelSize.height / 2 ));

        userMngmtView.setVisible(true);
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param userTmp
     */
    protected void setCurrentUser(IUser userTmp)
    {
        this.userSelected = userTmp;
    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param name
     * @param action
     * @return a popup menu printed when the user right clicks.
     */
    protected JPopupMenu createPopupMenu(String[] name, Action[] action)
    {
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem menuItem;
        for (int i = 0 ; i < name.length ; i++)
        {
            menuItem = new JMenuItem();
            menuItem.setAction(action[i]);
            menuItem.setText(name[i]);
            popMenu.add(menuItem);
        }
        return popMenu;

    }

    private void updateInfosPanel(IUser user)
    {
        tfLogin.setText(user.getName());
        if (user.getPassword() != null)
        {
            checkLDAP.setSelected(false);
            labPass.setEnabled(true);
            tfPass.setEnabled(true);
            tfPass.setText(user.getPassword());
        }
        else
        {
            checkLDAP.setSelected(true);
            labPass.setEnabled(false);
            tfPass.setEnabled(false);
            tfPass.setText("");
        }
        cbPermissions.setSelectedIndex(user.getPrivilege());
    }
}
