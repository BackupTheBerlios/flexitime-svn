/*
 * Created on 25 nov. 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package FlexiPDFTest;

//Java
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

//JAXP
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;

//Avalon
import org.apache.avalon.framework.ExceptionUtil;
import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;

//FOP
import org.apache.fop.apps.Driver;
import org.apache.fop.apps.FOPException;
import org.apache.fop.messaging.MessageHandler;

/**
 * @author Famille
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class FlexiPDFClass 
{
	public void convertXML2PDF(File xml, File xslt, File pdf) throws IOException, FOPException, TransformerException 
	{
		//Construction d'un driver
		Driver driver = new Driver();
        
        //Installation d'un logger
		Logger logger = new ConsoleLogger(ConsoleLogger.LEVEL_INFO);
		driver.setLogger(logger);
		MessageHandler.setScreenLogger(logger);

		//Setup Renderer (output format)        
		driver.setRenderer(Driver.RENDER_PDF);
        
		//Setup output
		OutputStream out = new java.io.FileOutputStream(pdf);
		try
		{
			driver.setOutputStream(out);
			//Setup XSLT
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xslt));
       
			//Setup input for XSLT transformation
			Source src = new StreamSource(xml);
       
			//Resulting SAX events (the generated FO) must be piped through to FOP
			Result res = new SAXResult(driver.getContentHandler());

			//Start XSLT transformation and FOP processing
			transformer.transform(src, res);
		} 
		finally 
		{
			out.close();
		}
	}
	
	//FONCTION DE TEST
	public static void main(String[] args) {
		   try {
			   System.out.println("FOP ExampleXML2PDF ");
			   System.out.println("Preparing...");

			   //Setup directories
			   File baseDir = new File(".");
			   File outDir = new File(baseDir, "out");
			   outDir.mkdirs();

			   //Setup input and output files          
			   File xmlfile = new File(baseDir, "test.xml");
			   File xsltfile = new File(baseDir, "test.xsl");
			   File pdffile = new File(outDir, "ResultXML2PDF.pdf");

			   System.out.println("Input: XML (" + xmlfile + ")");
			   System.out.println("Stylesheet: " + xsltfile);
			   System.out.println("Output: PDF (" + pdffile + ")");
			   System.out.println();
			   System.out.println("Transforming...");
            
				FlexiPDFClass app = new FlexiPDFClass();
			   app.convertXML2PDF(xmlfile, xsltfile, pdffile);
            
			   System.out.println("Success!");
		   } catch (Exception e) {
			   System.err.println(ExceptionUtil.printStackTrace(e));
			   System.exit(-1);
		   }
	   }


}
