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

import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;



import fr.umlv.ir3.GL.test.edt.controller.ComponentDragSourceListener;
import fr.umlv.ir3.GL.test.edt.event.PlanningDataEvent;
import fr.umlv.ir3.GL.test.edt.event.PlanningDataListener;
import fr.umlv.ir3.GL.test.edt.model.DefaultPlanningModel;
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
 * @see model.DefaultPlanningModel
 * @see renderer.EDTCellRenderer
 * @see renderer.EDTCellHeaderRenderer
 * 
 * @author FlexiTeam - binou
 */
public class FlexiPlanning extends JPanel implements PlanningDataListener
{
	public static final int WEEK_WIDTH = 75;
	public static final int DAY_COLUMN_WIDTH = 75;
	public static final int DAY_HEIGTH = 18;
	public static final int GAP_HEIGTH = 15;
	
	private GridBagLayout gbl;
	
	public DragSource dragSource;
	public DropTarget dropTarget;
	private static BufferedImage buffImage = null; //buff image
	private static Point cursorPoint = new Point();
	
	private JLesson currentSelected = null;
	
	
    private DefaultPlanningModel model;
    private EDTCellRenderer cellRenderer;
    private EDTCellHeaderRenderer cellHeaderRenderer;

    public FlexiPlanning(DefaultPlanningModel model)
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
        
        this.model.addPlanningDataListener(this);
        
        this.init();

    }

   
    /** 
     * Returns the model of the FlexiEDT
     *
     * @return the model used by the component
     * 
     * @see DefaultPlanningModel
     * @author   FlexiTeam - binou
     */
    public DefaultPlanningModel getModel()
    {
        return model;
    }

    
    public JLesson getCurrentSelected()
    {
        return currentSelected;
    }
    public void setCurrentSelected(JLesson currentSelected)
    {
        if(this.currentSelected != null)
            this.currentSelected.setSelected(false);
        this.currentSelected = currentSelected;
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
    
    
    private void addGap(int weekNumber, int daynumber, int lowerGap)
    {
        //System.out.println(weekNumber+1 + "/" + (daynumber*(model.getDayGapSize()+1)+lowerGap+1));
        addGap(weekNumber+1, 1+daynumber*(model.getDayGapSize()+1)+lowerGap+1      , weekNumber, daynumber, lowerGap);
    }
    
    

    
    
    
    /** 
     * convert an indice of column into the week number
     *
     * @param columnNumber the column number
     * @return the week number
     * 
     * @author   FlexiTeam - binou
     */
    private int xToWeek(int columnNumber)
    {
        return columnNumber-1;
    }
    
    /** 
     * convert an indice of lign into the day number
     *
     * @param lignNumber the lign number
     * @return the day number
     * 
     * @author   FlexiTeam - binou
     */
    private int yToDay(int lignNumber)
    {
        return (lignNumber-2)/(model.getDayGapSize()+1);
    }
    
    /** 
     * convert an indice of lign into the gap number in its day
     *
     * @param lignNumber the lign number
     * @return the gap number in its day
     * 
     * @author   FlexiTeam - binou
     */
    private int yToGapInTheDay(int lignNumber)
    {
        return lignNumber - (yToDay(lignNumber)*(model.getDayGapSize()+1)+1) - 1;
    }
    
    /** 
     * return true if the specified datagrid cordinate is a lesson gap
     *
     * @param p the datagrid point
     * @return true if its a lesson gap
     * 
     * @author   FlexiTeam - binou
     */
    private boolean isALessonGap(Point p)
    {
        return !(p.x<=0 || p.y<=1 || (p.y-1)%(model.getDayGapSize()+1) == 0 );
    }
    
    
    /** 
     * convert a week number into a pixel number +2
     * 
     * bug ... not a good way, depend of the size
     *
     * @author   FlexiTeam - binou
     */
    private int weekToX(int week)
    {
        return DAY_COLUMN_WIDTH+week*WEEK_WIDTH+2  + gbl.getLayoutOrigin().x;
    }
    
    private int gapToY(int day, int gap)
    {
        return DAY_HEIGTH + (model.getDayGapSize()*day*GAP_HEIGTH + DAY_HEIGTH*(day+1)) + GAP_HEIGTH*gap + 2 + + gbl.getLayoutOrigin().y;
    }
    
    
    
    
    private Component getComponentAt(int week, int day, int gap)
    {
        return getComponentAt(    weekToX(week)    ,     gapToY(day, gap)         );
    }
    
    
    
    
	/** 
     * Change the style of a gap in (x,y) and the followings, 
     * when there's a drag over them
     *
     * @param j
	 * @param i
     * @return 
     * 
     * @see (si nécessaire)
     * @author   FlexiTeam - binou
     */
    private void setDragOverStyle(int x, int y, boolean value)
    {
        Component comp = getComponentAt(xToWeek(x) , yToDay(y) , yToGapInTheDay(y));
        if(comp instanceof JLesson)
        {
            JLesson jlesson = (JLesson)comp;
            jlesson.setDragOver(value);
            //Rectangle rect2Dselect = new Rectangle(jlesson.getBounds());
            //paintImmediately(rect2Dselect.getBounds());
        }
    }
    
    
    

    public void intervalAdded(PlanningDataEvent e)
    {
        System.out.println(e.getLowerGap() + " => " + e.getUpperGap());
        for (int i = e.getLowerGap() ; i <= e.getUpperGap()  ; i++)
            remove(   getComponentAt( e.getWeekNumber() , e.getDaynumber(), i)   );
        
        for (int i = e.getLowerGap() ; i <= e.getUpperGap()  ; i++)
            addGap(e.getWeekNumber(), e.getDaynumber(), i);
            
        //System.out.println(model.getDayGapSize() + "*" +e.getDaynumber()+ "*" + GAP_HEIGTH + "+" +DAY_HEIGTH+ "*" +(e.getDaynumber()+1)+"+"+ GAP_HEIGTH + "*" + e.getLowerGap() + "+ 2" );
        //System.out.println(x + " - " + y);
        
        
        
        
        System.out.println("intervalAdded()");
        System.out.println(e);
    }





    public void intervalRemoved(PlanningDataEvent e)
    {
        System.out.println("intervalRemoved()");
        System.out.println(e);
    }



    public void contentsChanged(PlanningDataEvent e)
    {
        System.out.println("contentsChanged()");
        System.out.println(e);
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
			if (comp != null && comp instanceof JLesson && comp != FlexiPlanning.this && isALessonGap(p_rel)   &&  model.isALesson(xToWeek(p_rel.x),yToDay(p_rel.y),yToGapInTheDay(p_rel.y)) )
			{
			    //Generation de l'image
				cursorPoint.setLocation(SwingUtilities.convertPoint(FlexiPlanning.this, dge.getDragOrigin(), comp));
				buffImage = new BufferedImage(comp.getWidth(), comp.getHeight(), java.awt.image.BufferedImage.TYPE_INT_ARGB_PRE);//buffered image reference passing the comp's ht and width
				Graphics2D graphics = buffImage.createGraphics();//creating the graphics for buffered image
				graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));	//Sets the Composite for the Graphics2D context
				boolean opacity = ((JComponent)comp).isOpaque();
				if (opacity) {
					((JComponent)comp).setOpaque(false);				
				}
				comp.paint(graphics);
				if (opacity) {
					((JComponent)comp).setOpaque(true);					
				}
				graphics.dispose();
					
				dragSource.startDrag(dge, DragSource.DefaultMoveDrop , buffImage, cursorPoint, new TransferableLessonBloc( new LessonBloc(((JLesson)comp).getLesson()) ), tdsl);
				revalidate();
				repaint();
			}
		}
	}
	
	
	final class ComponentDropTargetListener implements DropTargetListener {
		private Rectangle rect2D = new Rectangle();
		private Rectangle rect2Dselect = new Rectangle();
		
		Insets insets;
		
		//garde en mémoire le drag point potentiel actuel ainsi ke la longueur de l'ajout potentiel
		private Point dragPoint = new Point();
		private int length;
		
		public void dragEnter(DropTargetDragEvent dtde) {
		    //System.out.println("dragEnter() at " + System.currentTimeMillis());
		    /*Point pt = dtde.getLocation();
			paintImmediately(rect2D.getBounds());
			rect2D.setRect((int) (pt.getX()-cursorPoint.getX()),(int) (pt.getY()-cursorPoint.getY()),buffImage.getWidth(),buffImage.getHeight());
			((Graphics2D) getGraphics()).drawImage(buffImage,(int) (pt.getX()-cursorPoint.getX()),(int) (pt.getY()-cursorPoint.getY()),FlexiEDT.this);
			dtde.acceptDrag(dtde.getDropAction());*/
		    dragPoint.setLocation(-1,-1);
		}
		
		public void dragExit(DropTargetEvent dte) {
		    //System.out.println("dragExit() at " + System.currentTimeMillis());
		    //redessine la partie du buffImage pour qu'il disparaisse vu kon sort d'une zone de drop
			//paintImmediately(rect2D.getBounds());
			//System.out.println("[TODO] Effacer le drop potentiel en ["+ dragPoint.x + ","+ dragPoint.y +"] (at " + System.currentTimeMillis() + ")");
            for (int i = dragPoint.y ; i < dragPoint.y+length ; i++)
            {
                //System.out.println("setDragOverStyle(" + dragPoint.x + "," + i +", false)");
		        setDragOverStyle(dragPoint.x, i, false);
            }
			dragPoint.setLocation(-1,-1);
		}
		
		public void dragOver(DropTargetDragEvent dtde) {
		    //System.out.println("dragOver() at " + System.currentTimeMillis());
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
				
				((Graphics2D) getGraphics()).drawImage(buffImage,(int) (p_abs.getX()-cursorPoint.getX()),(int) (p_abs.getY()-cursorPoint.getY()),FlexiPlanning.this);
				dtde.acceptDrag(dtde.getDropAction());
	
				Transferable transferable = dtde.getTransferable();
				if (transferable.isDataFlavorSupported(TransferableLessonBloc.LESSON_FLAVOR))
				{
					try
	                {
					    //on test kon a bien changer de sélection
	                    if(dragPoint.x != p_rel.x || dragPoint.y != p_rel.y)
	                    {
	                        //Lecture du lesson bloc à dragguer
						    LessonBloc lesson = (LessonBloc)transferable.getTransferData(TransferableLessonBloc.LESSON_FLAVOR);
						    
	                        //On déselectionne le dragOverStyle précédent
	                        if(dragPoint.x != -1 && dragPoint.y != -1)
	                        {
	                            //System.out.println("[TODO] Effacer le drop potentiel en ["+ dragPoint.x + ","+ dragPoint.y +"] (at " + System.currentTimeMillis() + ")");
	                            for (int i = dragPoint.y ; i < dragPoint.y+length ; i++)
							        setDragOverStyle(dragPoint.x, i, false);
	                        }
	                        
	                        //on mémorise pour la suite le nous point de drag potentiel et sa longueur
	                        dragPoint.setLocation(p_rel.x,p_rel.y);
	                        
						    //on regarde combien de créneau nous est disponible
						    int nbEmptyGap = model.getNbEmptyGapAt(xToWeek(p_rel.x) , yToDay(p_rel.y) , yToGapInTheDay(p_rel.y));
	                        if(nbEmptyGap <= 0)
	                            System.out.println("Oula gros pb :s");
	                        
						    if(lesson.getNbGap() > nbEmptyGap)
						        length = nbEmptyGap;    
						    else
						        length = lesson.getNbGap();
						    
	                        //on sélectionne la zone du drag potentiel
						    for (int i = p_rel.y ; i < p_rel.y+length ; i++)
						        setDragOverStyle(p_rel.x, i, true);

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
		    //System.out.println("dropActionChanged()");
			
		    /*Point pt = dtde.getLocation();
			paintImmediately(rect2D.getBounds());
			rect2D.setRect((int) (pt.getX()-cursorPoint.getX()),(int) (pt.getY()-cursorPoint.getY()),buffImage.getWidth(),buffImage.getHeight());
			((Graphics2D) getGraphics()).drawImage(buffImage,(int) (pt.getX()-cursorPoint.getX()),(int) (pt.getY()-cursorPoint.getY()),FlexiEDT.this);
			dtde.acceptDrag(dtde.getDropAction());*/
		}

		public void drop(DropTargetDropEvent dtde) {
			try {
			    //System.out.println("ATTENTION drop !!!!");
				paintImmediately(rect2D.getBounds());
				int action = dtde.getDropAction();
				Transferable transferable = dtde.getTransferable();
				if (transferable.isDataFlavorSupported(TransferableLessonBloc.LESSON_FLAVOR))
				{
				    //System.out.println("DataFlavor OK");
				    // On recupere le lesson a droper
				    LessonBloc lesson = (LessonBloc)transferable.getTransferData(TransferableLessonBloc.LESSON_FLAVOR);
				    lesson.setNbGap(length);
					Point location = dtde.getLocation();
					if (lesson == null) {
					    System.out.println("rien a dropper !!!");
						dtde.rejectDrop();
						dtde.dropComplete(false);
						revalidate();
						repaint();
						return;						
					}
					else {
					    //System.out.println(location);
					    Point target = gbl.location(location.x,location.y);

					    //System.out.println("Ajout en [" + target.x + "," + target.y + "]" + "week " + xToWeek(target.x) + " day " + yToDay(target.y) + "gap " + yToGapInTheDay(target.y));
					    getModel().addElement(xToWeek(target.x) , yToDay(target.y) , yToGapInTheDay(target.y) , lesson );

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

