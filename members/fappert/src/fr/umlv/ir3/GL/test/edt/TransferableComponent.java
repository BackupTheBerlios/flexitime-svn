package fr.umlv.ir3.GL.test.edt;

import java.awt.datatransfer.*;
import java.awt.*;
import java.util.*;

public class TransferableComponent implements Transferable {
	public static final DataFlavor COMPONENT_FLAVOR = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType, "JLesson");
	private Component component;
	private DataFlavor[] flavors = { COMPONENT_FLAVOR };
	
	/**
	* Constructs a transferrable component object for the specified component.
	*/
	public TransferableComponent(Component comp) {
		this.component = comp;
	}  
	public synchronized Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
		if (flavor == COMPONENT_FLAVOR) {
			return component;
		}
		else {
			throw new UnsupportedFlavorException(flavor);	
		}			
	}

	public DataFlavor[] getTransferDataFlavors() {
		return flavors;
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return Arrays.asList(flavors).contains(flavor);
	}
}
