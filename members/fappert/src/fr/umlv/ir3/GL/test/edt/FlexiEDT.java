/*
 * Created on 4 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.GL.test.edt;

import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;


import fr.umlv.ir3.GL.test.edt.model.EDTModel;
import fr.umlv.ir3.GL.test.edt.renderer.EDTCellHeaderRenderer;
import fr.umlv.ir3.GL.test.edt.renderer.EDTCellRenderer;



/**
 * DOCME Description
 * 
 * A component that allows the user to manage a planning
 * A separate model, <code>EDTModel</code>, represents the contents
 * of the planning.
 * 
 * @version 0.1
 * @see model.EDTModel
 * @see renderer.EDTCellRenderer
 * @see renderer.EDTCellHeaderRenderer
 * 
 * @author FlexiTeam - binou
 */
public class FlexiEDT extends JPanel
{
	public static final int WEEK_WIDTH = 75;
	public static final int DAY_COLUMN_WIDTH = 75;
	public static final int DAY_HEIGTH = 25;
	public static final int GAP_HEIGTH = 15;
	
	private GridBagLayout gbl;
	
	public DragSource dragSource;
	public DropTarget dropTarget;
	private static BufferedImage buffImage = null; //buff image
	private static Point cursorPoint = new Point();
	
	
    private EDTModel model;
    private EDTCellRenderer cellRenderer;
    private EDTCellHeaderRenderer cellHeaderRenderer;

    public FlexiEDT(EDTModel model)
    {
        super();
        
        this.gbl = new GridBagLayout();
        setLayout(gbl);
        
        
        dragSource = new DragSource();
		ComponentDragSourceListener tdsl = new ComponentDragSourceListener();
		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, new ComponentDragGestureListener(tdsl));
		ComponentDropTargetListener tdtl = new ComponentDropTargetListener();
		dropTarget = new DropTarget(this, DnDConstants.ACTION_MOVE, tdtl);
        
        this.model = model;
        this.cellRenderer = new EDTCellRenderer();
        this.cellHeaderRenderer = new EDTCellHeaderRenderer();
        
        this.init();
        
        
    }

   
    /** 
     * Returns the model of the FlexiEDT
     *
     * @return the model used by the component
     * 
     * @see EDTModel
     * @author   FlexiTeam - binou
     */
    public EDTModel getModel()
    {
        return model;
    }



    /** 
     * Initialyse the time table
     * Is only used at the creation
     * 
     * @author   FlexiTeam - binou
     */
    private void init()
    {
        this.createWeekLign();
        this.createDayColumn();
        this.fillLesson();
    }
    

    /** 
     * Generate the week Header of the time table containing the number of each week
     * 
     * @author   FlexiTeam - binou
     */
    private void createWeekLign()
    {
        for (int i = 0 ; i < model.getNbWeeks() ; i++)
            addWeekHeader(i+1,0,i);  //+1 =+dayColumn
    } 
    
    /** 
     * Generate the first Column of the planning
     * containing : <br>
     * - the name of each day
     * - all gap's header
     * - each date of each days on each weeks
     * Is only used at the creation
     * 
     * @author   FlexiTeam - binou
     */
    private void createDayColumn()
    {
        int tempY;
        for (int i = 0 ; i < model.getNbDays()  ; i++)
        {
            tempY = i*(model.getDayGapSize()+1)+1; //dernier +1 = +weekLign
            addDayHeader(0,tempY,i);
            for (int j = 0 ; j < model.getNbWeeks() ; j++)
                addDateHeader(j+1,tempY,j,i);
            int length;
            int cur = tempY+1;
            for (int j = 0 ; j < model.getNbBloc() ; j++)
            {
                length = model.getBlocSize(j);
                addGapHeader(0,cur,j,length);
                cur += length;
            }
        }
    }
    
    /** 
     * Generate the data in the planning :
     * - each Lessons
     * - each empty space (no lessons)
     * Is only used at the creation
     * 
     * @author   FlexiTeam - binou
     */
    private void fillLesson()
    {
        int tempY;
        for (int k = 0 ; k < model.getNbWeeks() ; k++)
        {
            for (int i = 0 ; i < model.getNbDays() ; i++)
            {
                tempY = i * (model.getDayGapSize() + 1) + 1;
                for (int j = 0 ; j < model.getDayGapSize() ; j++)
                    //addEmptyLesson(k, tempY + j);
                    addGap(k+1, (tempY+1)+j, k,i,j);
            }
        } 
    }
    
    /** 
     * DOCME Description
     * Add to the layout a week header at the specified coordinate
     * Is only used at the creation
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param weekNumber the column number of the header to add
     * 
     * @author   FlexiTeam - binou
     */
    private void addWeekHeader(int x, int y, int weekNumber)
    {
        //System.out.println("Ajout d'un header semaine en ["+x+","+y+"]");
        
        JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getWeekHeaderAt(weekNumber),EDTCellHeaderRenderer.WEEK_HEADER);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        add(comp, c);
    }
    

    /** 
     * DOCME Description
     * Add to the layout a date header at the specified coordinate
     * Is only used at the creation
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param weekNumber the week number of the date to add
     * @param dayNumber the day number of the header to add
     * 
     * @author   FlexiTeam - binou
     */
    private void addDateHeader(int x, int y, int weekNumber, int dayNumber)
    {
        //System.out.println("Ajout d'un header jour/semaine en ["+x+","+y+"]");
        
        JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getDateHeaderAt(weekNumber,dayNumber),EDTCellHeaderRenderer.DATE_HEADER);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        add(comp, c);
    }
    


    /** 
     * DOCME Description
     * Add to the layout a gap header at the specified coordinate
     * Is only used at the creation
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param length
     * @param gapNumber the gap number of the header to add
     * 
     * @author   FlexiTeam - binou
     */
    private void addGapHeader(int x, int y, int blocNumber, int length)
    {
        //System.out.println("Ajout d'un header horaire en ["+x+","+y+"]");
        JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getGapHeaderAt(blocNumber),EDTCellHeaderRenderer.GAP_HEADER);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridheight = length;
        c.fill = GridBagConstraints.VERTICAL;
        add(comp, c);
    }


    /** 
     * DOCME Description
     * Add to the layout a day header at the specified coordinate
     * Is only used at the creation
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param dayNumber - the day number of the header to add
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    private void addDayHeader(int x, int y, int dayNumber)
    {
       //System.out.println("Ajout d'un header jour en ["+x+","+y+"]");
       JComponent comp = cellHeaderRenderer.getEDTCellHeaderRendererComponent(this,model.getDayHeaderAt(dayNumber),EDTCellHeaderRenderer.DAY_HEADER);
       
       GridBagConstraints c = new GridBagConstraints();
       c.gridx = x;
       c.gridy = y;
       add(comp, c);
    }
    
    
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param weekNumber
     * @param dayNumber
     * @param gapNumber 
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    private void addGap(int x, int y, int weekNumber, int dayNumber, int gapNumber)
    {

        JComponent comp = cellRenderer.getEDTCellRendererComponent(this,model.getElementAt(weekNumber,dayNumber,gapNumber), weekNumber, dayNumber,gapNumber);
        if(comp != null)
        {
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = x;
            c.gridy = y;
            if(comp instanceof JLesson)
            {
                c.gridheight = ((JLesson)comp).getNbGaps();
                c.fill = GridBagConstraints.VERTICAL;
            }
            add(comp, c);
        }
    }
    
    
	/** 
     * Change the style of a gap in (x,y) and the followings, 
     * when there's a drag over them
     *
     * @param lesson
	 * @param j
	 * @param i
     * @return 
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    private boolean setDragOverStyle(JLesson lesson, int i, int j)
    {
        // TODO Auto-generated method stub
        return true;
    }
    
    
    
    private int xToWeek(int x)
    {
        return x-1;
    }
    
    private int yToDay(int y)
    {
        return (y-2)/(model.getDayGapSize()+1);
    }
    
    private int yToGapInTheDay(int y)
    {
        return y - (yToDay(y)*(model.getDayGapSize()+1)+1) - 1;
    }
    
    private boolean isALessonGap(Point p)
    {
        return !(p.x<=0 || p.y<=1 || (p.y-1)%(model.getDayGapSize()+1) == 0 );
    }
    
    
    
    
    
    
	final class ComponentDragSourceListener implements DragSourceListener {
		public void dragDropEnd(DragSourceDropEvent dsde) {
		}
		public void dragEnter(DragSourceDragEvent dsde)  {
			int action = dsde.getDropAction();
			if (action == DnDConstants.ACTION_MOVE) {
				dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
			} 
			else {
				dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
			}
		}
		public void dragOver(DragSourceDragEvent dsde) {
			int action = dsde.getDropAction();
			if (action == DnDConstants.ACTION_MOVE) {
				dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
			} 
			else {
				dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
			}
		}
		public void dropActionChanged(DragSourceDragEvent dsde)  {
			int action = dsde.getDropAction();
			if (action == DnDConstants.ACTION_MOVE) {
				dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
			} 
			else {
				dsde.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
			}
		}
		public void dragExit(DragSourceEvent dse) {
		   dse.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
		}	
	}
		
	final class ComponentDragGestureListener implements DragGestureListener {
		ComponentDragSourceListener tdsl;
		public ComponentDragGestureListener(ComponentDragSourceListener tdsl) {
			this.tdsl = tdsl;
		}
		public void dragGestureRecognized(DragGestureEvent dge) {
			
			
		    Point p_abs = dge.getDragOrigin();
		    Point p_rel = gbl.location(p_abs.x, p_abs.y);
		    
		    //lit le label sur la grille d'origine
			Component comp = getComponentAt(p_abs);
			
			//System.out.println(p_abs);
			//System.out.println(p_rel);
			//System.out.println("[" + xToWeek(p_rel.x) + "," + yToDay(p_rel.y) + "," + yToGapInTheDay(p_rel.y) + "]" );
			
			//on test si c bien une case de cours et si c bien un cours ... sinon pas de drag !
			if (comp != null && comp instanceof JLesson && comp != FlexiEDT.this && isALessonGap(p_rel)   &&  model.isALesson(xToWeek(p_rel.x),yToDay(p_rel.y),yToGapInTheDay(p_rel.y)) )
			{
				cursorPoint.setLocation(SwingUtilities.convertPoint(FlexiEDT.this, dge.getDragOrigin(), comp));
				buffImage = new BufferedImage(comp.getWidth(), comp.getHeight(), java.awt.image.BufferedImage.TYPE_INT_ARGB_PRE);//buffered image reference passing the comp's ht and width
				Graphics2D graphics = buffImage.createGraphics();//creating the graphics for buffered image
				graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));	//Sets the Composite for the Graphics2D context
				boolean opacity = ((JComponent)comp).isOpaque();
				if (opacity) {
					((JComponent)comp).setOpaque(false);				
				}
				comp.paint(graphics); //painting the graphics to label
				if (opacity) {
					((JComponent)comp).setOpaque(true);					
				}
				graphics.dispose();
				//remove(comp);
				//créer une copie sans les dates (car impossible de savoir les dates à ce moment précis mais on connait le reste
				//dragSource.startDrag(dge, DragSource.DefaultMoveDrop , buffImage, cursorPoint, new TransferableComponent(new JLesson((JLesson)comp)), tdsl);	
				dragSource.startDrag(dge, DragSource.DefaultMoveDrop , buffImage, cursorPoint, new TransferableComponent(comp), tdsl);
				revalidate();
				repaint();
			}
		}
	}
	
	

	final class ComponentDropTargetListener implements DropTargetListener {
		private Rectangle rect2D = new Rectangle();
		Insets insets;
		public void dragEnter(DropTargetDragEvent dtde) {
		    //System.out.println("dragEnter()");
		    /*Point pt = dtde.getLocation();
			paintImmediately(rect2D.getBounds());
			rect2D.setRect((int) (pt.getX()-cursorPoint.getX()),(int) (pt.getY()-cursorPoint.getY()),buffImage.getWidth(),buffImage.getHeight());
			((Graphics2D) getGraphics()).drawImage(buffImage,(int) (pt.getX()-cursorPoint.getX()),(int) (pt.getY()-cursorPoint.getY()),FlexiEDT.this);
			dtde.acceptDrag(dtde.getDropAction());*/
		}
		public void dragExit(DropTargetEvent dte) {
		    //System.out.println("dragExit()");
		    //redessine la partie du buffImage pour qu'il disparaisse vu kon sort d'une zone de drop
			paintImmediately(rect2D.getBounds());
		}
		public void dragOver(DropTargetDragEvent dtde) {
		    Point p_abs = dtde.getLocation();
		    Point p_rel = gbl.location(p_abs.x,p_abs.y);
		    
		    //on desactive le drop si on est pas sur une case de cours ou si on est sur un cours
		    if(!isALessonGap(p_rel)  ||  model.isALesson(xToWeek(p_rel.x),yToDay(p_rel.y),yToGapInTheDay(p_rel.y)))
		    {
		        dtde.rejectDrag();
		        paintImmediately(rect2D.getBounds());   
		    }
		    else
		    {
			    paintImmediately(rect2D.getBounds());
				rect2D.setRect((int) (p_abs.getX()-cursorPoint.getX()),(int) (p_abs.getY()-cursorPoint.getY()),buffImage.getWidth(),buffImage.getHeight());
				((Graphics2D) getGraphics()).drawImage(buffImage,(int) (p_abs.getX()-cursorPoint.getX()),(int) (p_abs.getY()-cursorPoint.getY()),FlexiEDT.this);
				dtde.acceptDrag(dtde.getDropAction());
			    
			    //Ici on peut savoir sur kel objet potentiel on veut placer le cours !!
			    // Il faut donc provoquer l'affichage des zones ici
				//System.out.println("Ajout potentiel en : " + gbl.location(pt.x,pt.y).x + "," + gbl.location(pt.x,pt.y).y );
	
				Transferable transferable = dtde.getTransferable();
				if (transferable.isDataFlavorSupported(TransferableComponent.COMPONENT_FLAVOR))
				{
					try
	                {
	                    Component comp = (Component) transferable.getTransferData(TransferableComponent.COMPONENT_FLAVOR);
	                    if(comp instanceof JLesson)
	                    {
	                        JLesson lesson = (JLesson)comp;
	                        boolean dragOver = setDragOverStyle(lesson, p_rel.x, p_rel.y);
	                    }
	                }
	                catch (UnsupportedFlavorException e)
	                {e.printStackTrace();}
	                catch (IOException e)
	                {e.printStackTrace();}
				}
		    }
		}


        public void dropActionChanged(DropTargetDragEvent dtde) {
		    System.out.println("dropActionChanged()");
			
		    /*Point pt = dtde.getLocation();
			paintImmediately(rect2D.getBounds());
			rect2D.setRect((int) (pt.getX()-cursorPoint.getX()),(int) (pt.getY()-cursorPoint.getY()),buffImage.getWidth(),buffImage.getHeight());
			((Graphics2D) getGraphics()).drawImage(buffImage,(int) (pt.getX()-cursorPoint.getX()),(int) (pt.getY()-cursorPoint.getY()),FlexiEDT.this);
			dtde.acceptDrag(dtde.getDropAction());*/
		}

		public void drop(DropTargetDropEvent dtde) {
			try {
			    System.out.println("ATTENTION drop !!!!");
				paintImmediately(rect2D.getBounds());
				int action = dtde.getDropAction();
				Transferable transferable = dtde.getTransferable();
				if (transferable.isDataFlavorSupported(TransferableComponent.COMPONENT_FLAVOR))
				{
				    System.out.println("DataFlavor OK");
				    // On recupere le composant a droper
					Component comp = (Component) transferable.getTransferData(TransferableComponent.COMPONENT_FLAVOR);
					Point location = dtde.getLocation();
					if (comp == null) {
					    System.out.println("rien a dropper :(");
						dtde.rejectDrop();
						dtde.dropComplete(false);
						revalidate();
						repaint();
						return;						
					}
					else {
					    Point target = gbl.location(location.x,location.y);
					    System.out.println("Ajout en " + target.x + "," + target.y);
						//add(comp, 0);
						//comp.setLocation((int)(location.getX()-cursorPoint.getX()),(int)(location.getY()-cursorPoint.getY()));
						dtde.dropComplete(true);
						revalidate();
						repaint();
						return;
					}
				}
				else {
				    
					dtde.rejectDrop();
					dtde.dropComplete(false);
					return;			
				}
			}		
			catch (Exception e) {	
				System.out.println(e);
				dtde.rejectDrop();
				dtde.dropComplete(false);
			}	
		}
	}
	

    
    
    

}

