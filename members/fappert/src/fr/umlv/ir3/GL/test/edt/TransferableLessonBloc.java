package fr.umlv.ir3.GL.test.edt;

import java.awt.datatransfer.*;
import java.util.*;

public class TransferableLessonBloc implements Transferable {
	public static final DataFlavor LESSON_FLAVOR = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType, "LessonBloc");
	private LessonBloc lessonBloc;
	private DataFlavor[] flavors = { LESSON_FLAVOR };
	
	/**
	* Constructs a transferrable component object for the specified component.
	*/
	public TransferableLessonBloc(LessonBloc lesson) {
		this.lessonBloc = lesson;
	}  
	public synchronized Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
		if (flavor == LESSON_FLAVOR) {
			return lessonBloc;
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