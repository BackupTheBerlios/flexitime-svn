/*
 * Created on 14 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import fr.umlv.ir3.GL.flexitime.client.listener.AddTeacherListener;
import fr.umlv.ir3.GL.flexitime.client.listener.RemoveTeacherListener;
import fr.umlv.ir3.GL.flexitime.client.model.TeacherListModel;


/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FlexitimeClient extends JPanel {
	static JFrame frame;

	JList list;

	/**
	 * @return
	 */
	public FlexitimeClient() {
		super(new BorderLayout());

		TeacherListModel listModel = new TeacherListModel();
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		JScrollPane listView = new JScrollPane(list);
		listView.setPreferredSize(new Dimension(200, 700));
		
		JButton addButton = new JButton("Add");
		addButton.setPreferredSize(new Dimension(80,20));
		addButton.addActionListener(new AddTeacherListener(listModel));
		JButton removeButton = new JButton("Remove");
		removeButton.setPreferredSize(new Dimension(80,20));
		removeButton.addActionListener(new RemoveTeacherListener(listModel,list));


		add(createPanelForComponent(listView, "JList"),BorderLayout.NORTH);
		add(addButton, BorderLayout.WEST);
		add(removeButton, BorderLayout.EAST);

	}

	
	public JPanel createPanelForComponent(JComponent comp, String title) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(comp, BorderLayout.CENTER);
		if (title != null) {
			panel.setBorder(BorderFactory.createTitledBorder(title));
		}
		return panel;
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);

		//Create and set up the window.
		frame = new JFrame("test archi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		JComponent newContentPane = new FlexitimeClient();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
