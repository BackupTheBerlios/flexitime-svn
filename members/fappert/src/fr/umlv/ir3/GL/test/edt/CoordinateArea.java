/*
 * Created on 2 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.edt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CoordinateArea extends JComponent implements MouseInputListener
{
	private static final int NB_SEMAINES = 7;
	private static final int NB_JOURS = 5;
	private static final int NB_CRENEAUX_JOUR = 8;
	private static final int LONGUEUR_SEMAINE = 75;
	private static final int HAUTEUR_JOUR = 20;
	private static final int HAUTEUR_CRENEAUX = 15;
	
	private int zoom = 1;
	
	Point point = null;
    CoordinatesDemo controller;
    Dimension preferredSize = new Dimension(800,500);
    Color gridColor;
    
    private int hauteurTotal()
    {
    	int res = (NB_CRENEAUX_JOUR*HAUTEUR_CRENEAUX*zoom+HAUTEUR_JOUR)*NB_JOURS;
    	System.out.println(res);
    	return (res);
    }
    
    private int longueurTotal()
    {
    	int res = NB_SEMAINES*LONGUEUR_SEMAINE*zoom;
    	System.out.println(res);
    	return res;
    }

    public CoordinateArea(CoordinatesDemo controller) {
        this.controller = controller;
        
        //Add a border of 5 pixels at the left and bottom,
        //and 1 pixel at the top and right.
        setBorder(BorderFactory.createBevelBorder(1,Color.DARK_GRAY, Color.LIGHT_GRAY));
                                                  
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
        setOpaque(true);
    }

    public Dimension getPreferredSize() {
        return preferredSize;
    }

    protected void paintComponent(Graphics g) {
        //Paint background if we're opaque.
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        //Paint 20x20 grid.
        g.setColor(Color.GRAY);
        drawGrid(g, 20);
        
        //If user has chosen a point, paint a small dot on top.
        if (point != null) {
            g.setColor(getForeground());
            g.fillRect(point.x - 3, point.y - 3, 7, 7);
        }
    }
    
    //Draws a 20x20 grid using the current color.
    private void drawGrid(Graphics g, int gridSpace)
    {
    	Image Buffer=createImage(longueurTotal()+5,hauteurTotal()+5);
        Graphics gBuffer=Buffer.getGraphics();
        
    	Insets insets = getInsets();
    	//Point de départ de l'image
        int firstX = insets.left;
        int firstY = insets.top;
        int longueur = longueurTotal();
        int hauteur = hauteurTotal();
        
        int x = firstX;
        int y = firstY;
        for (int i = 0; i < NB_JOURS; i++)
        {
        	//Pour chaque jour on crée un ligne noire
        	// On pourrait le remplacer par le numéro de la semaine
        	gBuffer.fillRect(x,y,longueur,HAUTEUR_JOUR);
        	System.out.println("Rectangle [(" + x + "," + y +")("+ (x+longueur) + "," + (y+HAUTEUR_JOUR) + ")]");
        	y += HAUTEUR_JOUR + HAUTEUR_CRENEAUX*zoom;
        	
        	//On va créer une ligne grise pour chaque créneau horaire de la journée
        	for (int j = 0; j < NB_CRENEAUX_JOUR-1; j++)
        	{
            	gBuffer.setColor(Color.LIGHT_GRAY);
            	gBuffer.drawLine(x, y, (x+longueur), y);
        		System.out.println("Ligne horizontale [(" + x + "," + y +")("+ (x+longueur) + "," + y + ")]");
        		y += HAUTEUR_CRENEAUX*zoom;
			}
        	gBuffer.setColor(Color.BLACK);
		}
        //dernière ligne du tableau
        gBuffer.drawLine(x, y, (x+longueur), y);

        x = firstX;
        y = firstY;
        for (int i = 0; i < NB_SEMAINES+1; i++)
        {
        	//on trace une ligne pour séparer les semaines
        	gBuffer.drawLine(x, y, x, y+hauteur);
        	System.out.println("Ligne verticale [(" + x + "," + y +")("+ x + "," + (y+hauteur) + ")]");
			x += LONGUEUR_SEMAINE*zoom;
		}
        
        
        //écriture de l'image générée sur le graphics
        g.drawImage (Buffer,0,0, this);
    }

    //Methods required by the MouseInputListener interface.
    public void mouseClicked(MouseEvent e) { 
        int x = e.getX();
        int y = e.getY();
        if (point == null) {
            point = new Point(x, y);
        } else {
            point.x = x;
            point.y = y;
        }
        controller.updateClickPoint(point);
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
        controller.updateCursorLocation(e.getX(), e.getY());
    }

    public void mouseExited(MouseEvent e) { 
        controller.resetLabel();
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) { }
    
    
	public void zoomMoins() {
		if(zoom > 0)
			this.zoom -= 1;
	}
	
	public void zoomPlus() {
		this.zoom += 1;
	}
}
