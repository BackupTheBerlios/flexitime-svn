/*
 * Created on 16 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package twowayRMI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.sf.hibernate.Session;

import tools.HibernateUtil;
import twowayRMI.ui.ProfListModel;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Client {

	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("10.25.42.2");
		
		final IRMIProf rmiprof = (IRMIProf) registry.lookup("Profs");
		
		final ProfListModel model = new ProfListModel(rmiprof);
		
		JFrame f = new JFrame("Client Prof");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new BorderLayout());
		
		final JList list = new JList(model);
		JScrollPane scroll = new JScrollPane(list);
		panel.add(scroll, BorderLayout.CENTER);
		
		JButton b = new JButton("Add");
		panel.add(b, BorderLayout.NORTH);
		
		b.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String text1 = JOptionPane.showInputDialog(null,"Entrez un nom");
				String text2 = JOptionPane.showInputDialog(null,"Entrez un prénom");
				String text3 = JOptionPane.showInputDialog(null,"Entrez un mail");
				if(text1 == null)
					return;
				Professeur p = new Professeur(text1, text2, text3);
				try {
					rmiprof.saveProf(p);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		JButton mod = new JButton("Modifier");
		panel.add(mod, BorderLayout.SOUTH);
		
		mod.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if(index==-1)
					return;
				Professeur p = model.getAt(index);
				System.out.println("Modifier: "+p.getNom() +" "+p);
				String newNom = JOptionPane.showInputDialog(null, "Entrez le nouveau nom pour "+p.getNom());
				if(newNom=="")
					return;
				p.setNom(newNom);
				try {
					rmiprof.saveProf(p);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		f.setContentPane(panel);
		
		f.pack();
		f.setVisible(true);
		
	}
}
