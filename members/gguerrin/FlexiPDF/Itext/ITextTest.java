/*
 * Created on 29 nov. 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package Itext;

import java.awt.Color;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author Famille
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class ITextTest 
{
	public static void main(String[] args) {
	System.out.println("Exemple: colspan, rowspan, padding, spacing, colors");
	
	// Etape 1: Creation de l'objet document
	   Document document = new Document();
	   try {
		   
	// Etape2:		  
 	// Il faut creer un writer qui est lié au document	  
 	// and et directement un flux PDF comme fichier
		PdfWriter.getInstance(document, new FileOutputStream("Chap0505.pdf"));
	
	// Etape3: il faut ouvrir le document
		document.open();
		   
	// Etape4: Creation d'un tableau et ajout de celui ci dans le document
		   Table table = new Table(6,20);
		   table.setBorderWidth(1);
		   table.setBorderColor(new Color(0, 0, 255));
		   table.setPadding(0);
		   table.setSpacing(0);
		  
		//Creation des colonne avec les jour
		  String[] colheader = {"lundi","mardi","mercredi","jeudi","vendredi"};
		Cell cell = new Cell();
		table.addCell(cell);
		   for( int i = 0; i<colheader.length;i++)
		   {
		   		cell = new Cell(colheader[i]);
		   		cell.setColspan(1);
				table.addCell(cell);
		   }
		
		
		//Creation des ligne et des heures
		String[] lineheader = {"8h-10h","10h-12h","14h-16h","16h-18h"};
		for( int i = 0; i<lineheader.length;i++)
		{
			cell = new Cell(lineheader[i]);
			table.addCell(cell,new Point(i+1,0));
		}
		
	   
	   // Ajout des cours
	   for( int i = 1; i<5;i++)
		{
			for( int j = 1; j<6;j++)
			{
				cell = new Cell("Cours");
				cell.setVerticalAlignment(Cell.ALIGN_CENTER);
				table.addCell(cell,new Point(i,j));
			}
		}
		document.add(table);
	  }
	   catch(DocumentException de) {
		   System.err.println(de.getMessage());
	   }
	   catch(IOException ioe) {
		   System.err.println(ioe.getMessage());
	   }
	   // step 5: we close the document
	   document.close();
   }
}
