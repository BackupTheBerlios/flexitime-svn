/*
 * Created on 28 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.test.dnd;

//G�rer le drag and drop sur un �l�ment graphique en java2D

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class TestDnDImage extends JFrame implements MouseMotionListener {
    
    //coordonn�es de l'image
    private int x1=50;
    private int y1=50;
    //select=true si l'image est cliqu�e, false sinon
    boolean select=false;
    //Image � afficher
    Image image = Toolkit.getDefaultToolkit().getImage("icon.gif"); //l'image � dessiner
    
    public static void main(String args[]){
        new TestDnDImage();
    }
    
    public TestDnDImage(){
        this.setBounds(200,200,200,200);
        this.setVisible(true);
        this.addMouseMotionListener(this);
    }
    
    
    public void mouseMoved(MouseEvent e){
        select=false;//si la souris bouge sans le bouton droit appuy�, on d�selectionne le point
        System.err.println("mouseMoved() -> d�selection du point...");
    }
    
    public void mouseDragged(MouseEvent e){
        int x=e.getX();// r�cupere la coordonn�e x de la souris
        int y=e.getY();// r�cupere la coordonn�e y de la souris
        
        System.err.println("mouseDragged() [x,y] -> [" + x +","+y+"]");
        //si on dragndrop l'image
       if (!select && x>x1 && y>y1) 
       	select=true;  
        //Si l'image est cliqu�e, on la fait suivre le curseur � l'�cran
        if (select) {
            x1=x;
            y1=y;
        repaint();    
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 =(Graphics2D) g;
        //on dessine un font gris
        g2.setColor(Color.gray);
        g2.fillRect(0,0,800,600);
        //on met l'image sur la fenetre
        g.drawImage(image, x1, y1, this);
    }
} 
