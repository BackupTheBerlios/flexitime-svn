/*
 * Created on 13 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package TestHiber;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import net.sf.hibernate.HibernateException;

import fr.umlv.ir3.flexitime.server.io.storage.TeacherStorage;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - Prâsad
 */
public class TestProf
{
    private JFrame jf;
    
    TestProf() throws HibernateException
    {
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final MyListModel lm = new MyListModel(TeacherStorage.get());
        
        final JList list = new JList(lm);
        JPanel jp = new JPanel(new BorderLayout());
        
        jp.add(list, BorderLayout.CENTER);
        
        JButton but = new JButton("Supprimer");
        but.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {
                int index = list.getSelectedIndex();
                if(index==-1)
                    return;
                
                try
                {
                    TeacherStorage.delete(lm.getAt(index));
                }
                catch (HibernateException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
            
        });
        
        jp.add(but, BorderLayout.SOUTH);
        
        jf.setContentPane(jp);
        
        jf.pack();
        jf.setVisible(true);
    }
    
    public static void main(String[] args) throws HibernateException
    {
        TestProf t = new TestProf();
    }
}

