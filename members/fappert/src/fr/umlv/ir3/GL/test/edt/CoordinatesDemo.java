package fr.umlv.ir3.GL.test.edt;

/* CoordinatesDemo.java is a 1.4 application that requires no other files. */

import javax.swing.*;

import fr.umlv.ir3.GL.test.printing.PrintUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/* 
 * This displays a framed area.  As the user moves the cursor
 * over the area, a label displays the cursor's location. When 
 * the user clicks, the area displays a 7x7 dot at the click
 * location.
 */
public class CoordinatesDemo {
	
    private JLabel label;
    private Point clickPoint, cursorPoint;
    private CoordinateArea coordinateArea = null;

    private void buildUI(Container container) {
        container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));

    	          
        coordinateArea = new CoordinateArea(this);
        
        label = new JLabel();
        resetLabel();
        
        JButton b_zoom_moins = new JButton("Zoom -");
        JButton b_zoom_plus = new JButton("Zoom +");
        JButton b_imprimer = new JButton("Imprimer...");
        
        b_zoom_plus.addActionListener(new ActionListener() {
        /* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Zoom+");
			coordinateArea.zoomPlus();
			coordinateArea.repaint();

		}
        });
        b_zoom_moins.addActionListener(new ActionListener() {
        	/* (non-Javadoc)
    		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    		 */
    		public void actionPerformed(ActionEvent arg0) {
    			System.out.println("Zoom-");
    			coordinateArea.zoomMoins();
    			coordinateArea.repaint();

    		}
            });
        b_imprimer.addActionListener(new ActionListener() {
        	/* (non-Javadoc)
    		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    		 */
    		public void actionPerformed(ActionEvent arg0) {
    			PrintUtilities.printComponent(coordinateArea);

    		}
            });
        
        container.add(coordinateArea);
        container.add(label);
        container.add(b_zoom_moins);
        container.add(b_zoom_plus);
        container.add(b_imprimer);
        

        //Align the left edges of the components.
        coordinateArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT); //redundant
        b_zoom_moins.setAlignmentX(Component.LEFT_ALIGNMENT); //redundant
        b_zoom_plus.setAlignmentX(Component.LEFT_ALIGNMENT); //redundant
        b_imprimer.setAlignmentX(Component.LEFT_ALIGNMENT); //redundant
    }

    public void updateCursorLocation(int x, int y) {
        if (x < 0 || y < 0) {
            cursorPoint = null;
            updateLabel();
            return;
        }
            
        if (cursorPoint == null) {
            cursorPoint = new Point();
        }
        
        cursorPoint.x = x;
        cursorPoint.y = y;
        updateLabel();
    }

    public void updateClickPoint(Point p) {
        clickPoint = p;
        updateLabel();
    }

    public void resetLabel() {
        cursorPoint = null;
        updateLabel();        
    }
    
    protected void updateLabel() {
        String text = "";

        if ((clickPoint == null) && (cursorPoint == null)) {
            text = "Click or move the cursor within the framed area.";
        } else {
            
            if (clickPoint != null) {
                text += "The last click was at (" 
                        + clickPoint.x + ", " + clickPoint.y + "). ";
            }
            
            if (cursorPoint != null) {
                text += "The cursor is at ("
                        + cursorPoint.x + ", " + cursorPoint.y + "). ";
            }
        }
        
        label.setText(text);
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
        JFrame frame = new JFrame("CoordinatesDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        CoordinatesDemo controller = new CoordinatesDemo();
        controller.buildUI(frame.getContentPane());

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
