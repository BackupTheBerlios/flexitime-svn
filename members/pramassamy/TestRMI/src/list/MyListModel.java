/*
 * Created on 11 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package list;

import java.io.Serializable;

import javax.swing.AbstractListModel;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyListModel extends AbstractListModel implements Serializable{

	/* (non-Javadoc)
	 * @see javax.swing.ListModel#getSize()
	 */
	public int getSize() {
		return m_nSize;
	}

	/* (non-Javadoc)
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	public Object getElementAt(int index) {
		return new Integer(index);
	}

	public void incr(){
		m_nSize++;
		fireIntervalAdded(this, m_nSize-2, m_nSize-1);
		
	}
	int m_nSize = 1;
}
