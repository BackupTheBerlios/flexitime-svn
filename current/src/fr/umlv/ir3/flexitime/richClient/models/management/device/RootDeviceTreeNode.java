/*
 * Created on 12 jan. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.models.management.device;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.richClient.models.management.RootTreeNode;

/**
 * Represents a tree node for a root device
 * @author GUERRIN Guillaume
 */
public class RootDeviceTreeNode extends RootTreeNode
{
    /**
     *le langage
     */
    private static FlexiLanguage language;
    static
    {
        language = FlexiLanguage.getInstance();
    }
    //	==================//
    //   Constructeurs  //
    //==================// 
	
	/**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4049637884510091060L;

    public RootDeviceTreeNode(TreeNode parent,List lstDevice) throws RemoteException
	{
		super(parent,lstDevice);
        LocalDataManager.getManager().addDataListener(IDevice.class,this);
	}
	
	/**
	 * Constructor by initialising
	 * @param parent the parent
	 * @param cat the category
	 * @param factory the BuckFactory
	 * @param model the model
	 * @throws RemoteException 
	 */
	public RootDeviceTreeNode(TreeNode parent,List lstDevice,DefaultTreeModel model) throws RemoteException
	{
		super(parent,lstDevice,model);
      LocalDataManager.getManager().addDataListener(IDevice.class,this);
    }
	
	
	//	=============//
    //   Méthodes  //
    //=============//

	
	/**
	 * Creates dynamiquely the list of the children when the user click on the "plus"
	 * @return the list of sub categories
	 */
	public List processChildren()
	{
		if(children.size()>0)return children;
		
		ArrayList list = new ArrayList(lst.size());
		Iterator ite = lst.iterator();
		HashMap map = new HashMap();
		for(;ite.hasNext();)
		{
			IDevice dev = (IDevice)ite.next();
    		if(dev!=null)
            {
                if(!map.containsKey(new Integer(dev.getType())))
    			{
    				ArrayList Devicelist = new ArrayList();
    				Devicelist.add(dev);
    				map.put(new Integer(dev.getType()),Devicelist);
    			}
    			else
    			{
    				((ArrayList)map.get(new Integer(dev.getType()))).add(dev);
    			}
            }
		}
		Iterator TypeDeviceIte = map.keySet().iterator();	
		for(int i=1;i<=IDevice.class.getFields().length;i++)
		{
			String name = language.getText("deviceType"+i) ;
            List lstDevice;
			if(map.get(new Integer(i))!= null )lstDevice = (List)map.get(new Integer(i));
			else lstDevice = new ArrayList();
			list.add(new TypeDeviceTreeNode(this,name,i,lstDevice,model));
		}
		this.children =list;
		return(list);
	}

	public void add() {}
	

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.flexitime.richClient.models.FlexiTreeNode#remove(javax.swing.tree.TreeNode)
	 */
	public void remove(IDevice device) throws RemoteException, FlexiException 
    {
        LocalDataManager.getManager().deleteDevice(device);

		
	}
    public void remove(TreeNode device) throws RemoteException, FlexiException {
       
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
     */
    public void dataChanged(DataEvent event)
    {
        IDevice device = (IDevice)event.getSource();
        int type = event.getEventType();
        switch(type)
        {
            case DataEvent.TYPE_PROPERTY_ADDED:
            {
                lst.add(device);
                TypeDeviceTreeNode tdtn = searchChild(device.getType());
                tdtn.add(device);
                break;
            }
            case DataEvent.TYPE_PROPERTY_CHANGED :
            {
                TypeDeviceTreeNode tdtn = searchChild(device.getType());
                tdtn.setValue(device);
                break;
            }
            case DataEvent.TYPE_PROPERTY_REMOVED:
            {
                 lst.remove(device);
                 TypeDeviceTreeNode tdtn = searchChild(device.getType());
                 tdtn.remove(device);
                break;
            }
        }
        
    }
    
    public TypeDeviceTreeNode searchChild(int type)
    {
        Iterator ite = children.iterator() ;
        for(;ite.hasNext();)
        {
            TypeDeviceTreeNode tdtn= (TypeDeviceTreeNode)ite.next();
            if(tdtn.getType()==type)
            {
                return tdtn;
            }
        }
        return null;
    }
}
