/*
 * Created on 28 janv. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.richClient.gui.renderers;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.DeviceTreeNode;
import fr.umlv.ir3.flexitime.richClient.models.management.device.TypeDeviceTreeNode;


/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FlexiTreeRenderer extends DefaultTreeCellRenderer
{
    public FlexiTreeRenderer()
    {
        super();
    }
    
    public Component getTreeCellRendererComponent(JTree tree,Object value,boolean selected,boolean expanded,boolean leaf,int row,boolean hasFocus)
    {
        DefaultTreeCellRenderer comp = (DefaultTreeCellRenderer)super.getTreeCellRendererComponent(tree,value,selected,expanded,leaf,row,hasFocus);
        
        if( value instanceof RootTreeNode)
        {
            System.out.println("RootTreeNode");
            comp.setIcon(new JLabel().getIcon());
        }
        else if  (value instanceof TypeDeviceTreeNode)
        {
            System.out.println("TypeDeviceTreeNode");
            ImageIcon ic=new ImageIcon(FlexiTreeRenderer.class.getResource("/fr/umlv/ir3/flexitime/richClient/gui/pictures/_materiel.png"));
            comp.setIcon(ic);
        }
        else if  (value instanceof DeviceTreeNode)
        {
            System.out.println("DeviceTreeNode");
        }
        return comp;
    }
}
