package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class flexitimeNoAuth_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>FlexiTime</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" title=\"flexicss\" href=\"/res/flexitime.css\" />\r\n");
      out.write("  \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	String login = (String) request.getAttribute("login");
	String codeErreur = (String) request.getAttribute("codeErreur");

      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<table class=\"sampletable\">\r\n");
      out.write("<tr><td colspan=\"3\"><table bgcolor=\"#f7f9fb\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td WIDTH=\"8\"><img name=\"header_r2_c1\" src=\"/res/header_r2_c1.jpg\" width=\"8\" height=\"70\" border=\"0\" alt=\"1\"></td>\r\n");
      out.write("\r\n");
      out.write("<td WIDTH=\"100%\" background=\"/res/header_r2_c9.jpg\"><a href=\"/\"><img name=\"header_r2_c2\" src=\"/res/logo.jpg\" width=\"300\" height=\"70\" border=\"0\" alt=\"Bienvenue sur \" TITLE=\"Bienvenue sur \"></A></td>\r\n");
      out.write("<td nowrap background=\"/res/header_r2_c9.jpg\" >\r\n");
      out.write("</td>\r\n");
      out.write("<td WIDTH=\"1\"><img src=\"/res/spacer.gif\" width=\"1\" height=\"70\" border=\"0\" alt=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</TABLE></td></tr>\r\n");
      out.write("<tr bgcolor=\"#F7F9FB\">\r\n");
      out.write("\t<form action=\"\" method=\"post\">\r\n");
      out.write("\t\t<td background=\"/res/header_r3_c8.jpg\"><b>Nom: </b><input type=\"text\" name=\"login\" \r\n");
      out.write("\t\t\t");

			 if(!codeErreur.equals("0") || login!=null){ out.println(" value=\"" + login + "\""); } 
			 
      out.write("\r\n");
      out.write("\t\t></td>\r\n");
      out.write("\t\t<td background=\"/res/header_r3_c8.jpg\"><b>Mot de passe: </b><input type=\"password\" name=\"password\"></td>\r\n");
      out.write("\t\t<td background=\"/res/header_r3_c8.jpg\"><input type=\"submit\" name=\"auth\" value=\"Valider\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" name=\"aide\" value=\"Aide\"></td>\r\n");
      out.write("\t</form>\r\n");
      out.write("</tr>\r\n");
 if(!codeErreur.equals("0")){ 
out.println("<tr><td background=\"/res/header_r3_c8.jpg\" align=\"center\" colspan=\"3\"><font color=\"red\"><b>"+codeErreur+"</b></font></td></tr>");
} 
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td colspan=\"3\" align=\"center\"><img src=\"/res/logo-umlv.jpg\" alt=\"umlv\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td colspan=\"3\" align=\"center\">Ce site a pour but d'afficher les emplois du temps des étudiants de Marne-la-Vallée !</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
