package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import fr.umlv.ir3.flexitime.common.tools.*;
import fr.umlv.ir3.flexitime.common.data.general.*;

public final class flexitimeAuth_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>FlexiTime</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" title=\"flexicss\" href=\"/res/flexitime.css\" />\r\n");
      out.write(" \r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"#E5F8FE\">\r\n");

	String login = (String) request.getAttribute("login");
	String nom = (String) request.getAttribute("longName");
	String edt = (String) request.getAttribute("edt");
	String semaine = (String)request.getAttribute("semaine");
    String planning = (String)request.getAttribute("planning");
    String typeedt = (String)request.getAttribute("typeedt");
	Time time = new Time();
	String typePerson = (String) request.getAttribute("typePerson");
	String listtracks = (String)request.getAttribute("listtracks");
	String listclasses = (String)request.getAttribute("listclasses");
	String listgroups = (String)request.getAttribute("listgroups");

      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\r\n");
      out.write("<table bgcolor=\"#f7f9fb\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td WIDTH=\"8\"><img name=\"header_r2_c1\" src=\"/res/header_r2_c1.jpg\" width=\"8\" height=\"70\" border=\"0\" alt=\"1\"></td>\r\n");
      out.write("<td WIDTH=\"30%\" background=\"/res/header_r2_c9.jpg\"><a href=\"/\"><img name=\"header_r2_c2\" src=\"/res/logo.jpg\" width=\"300\" height=\"70\" border=\"0\" alt=\"Bienvenue sur \" TITLE=\"Bienvenue sur \"></A></td>\r\n");
      out.write("<td width=\"*\" background=\"/res/header_r2_c9.jpg\" align=\"center\" valign=\"middle\"><b>Bonjour ");
      out.print( nom );
      out.write("</b><br></td>\r\n");
      out.write("<td width=\"20%\" background=\"/res/header_r2_c9.jpg\" align=\"center\" valign=\"middle\" width=\"300\"><b>");
      out.print( time.getStrDate() );
      out.write("<b></td>\r\n");
      out.write("<td nowrap background=\"/res/header_r2_c9.jpg\" ></td>\r\n");
      out.write("<td WIDTH=\"1\"><img src=\"/res/spacer.gif\" width=\"1\" height=\"70\" border=\"0\" alt=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</TABLE>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"100%\" align=\"right\" valign=\"top\">\r\n");
      out.write("<form action=\"/lightClient/\" method=\"post\">\r\n");
      out.write("<input type=\"hidden\" name=\"login\" value=\"");
      out.print( login );
      out.write("\">\r\n");
      out.write("<input type=\"submit\" name=\"devalid\" value=\"Déconnexion\">\r\n");
      out.write("</form>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<center>\r\n");
      out.write("<form action=\"/lightClient");
      out.print(typePerson);
      out.write("\" method=\"post\">\r\n");
      out.write("<input type=\"hidden\" name=\"login\" value=\"");
      out.print(login);
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"planning\" value=\"");
      out.print( planning );
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"semaine\" value=\"");
      out.print( semaine );
      out.write("\">\r\n");
      out.write("<table class=\"sampletable\" width=\"100%\"  cellpadding=\"0\" cellspacing=\"0\"><tr><td colspan=\"3\">\r\n");

if(typePerson.equals("/TraitementTeacher")){

      out.write('\r');
      out.write('\n');

}else{

      out.write("\r\n");
      out.write("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"><tr>\r\n");
      out.write("<td align=\"center\" width=\"50%\" background=\"/res/header_r3_c8.jpg\">\r\n");
      out.write("<input type=\"submit\" name=\"typeedt\" value=\"Emploi du temps\">\r\n");
      out.write("</td>\r\n");
      out.write("<td align=\"center\" width=\"50%\" background=\"/res/header_r3_c8.jpg\">\r\n");
      out.write("<input type=\"submit\" name=\"edtsalle\" value=\"Salles\">\r\n");
      out.write("</td>\r\n");
      out.write("</tr></table>\r\n");

}

      out.write("\r\n");
      out.write("</td></tr>\r\n");
      out.write("<tr>\r\n");

if(typePerson.equals("/TraitementTeacher")){

      out.write('\r');
      out.write('\n');

}else{

      out.write('\r');
      out.write('\n');

if(edt!=null){

      out.write("\r\n");
      out.write("<td align=\"center\" width=\"33%\" background=\"/res/header_r3_c8.jpg\">\r\n");

if(planning.equals("hebdo") && !semaine.equals("0")){

      out.write("\r\n");
      out.write("<input type=\"submit\" name=\"stepbefore\" value=\"Semaine précédente\">\r\n");

}else{

      out.write("\r\n");
      out.write("&nbsp;\r\n");

}

      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td align=\"center\" width=\"*\" background=\"/res/header_r3_c8.jpg\">\r\n");

if(planning.equals("hebdo")){

      out.write("<input type=\"submit\" name=\"switch\" value=\"EDT Trimestriel\">\r\n");

}else{

      out.write("\r\n");
      out.write("<input type=\"submit\" name=\"switch\" value=\"EDT Hebdomadaire\">\r\n");

}

      out.write("</td>\r\n");
      out.write("<td align=\"center\" width=\"33%\" background=\"/res/header_r3_c8.jpg\">\r\n");

if(planning.equals("hebdo") && !semaine.equals("2")){

      out.write("\r\n");
      out.write("<input type=\"submit\" name=\"stepafter\" value=\"Semaine suivante\">\r\n");

}else{

      out.write("\r\n");
      out.write("&nbsp;\r\n");

}

      out.write("</td>\r\n");

}

      out.write('\r');
      out.write('\n');

}

      out.write("\r\n");
      out.write("</tr></table>\r\n");
      out.write("<table><tr>\r\n");
if(typeedt.equals("edt") && listtracks!=null){
      out.write("\r\n");
      out.write("<td>");
      out.print(listtracks);
      out.write("</td>\r\n");
      out.write("<td><input type=\"submit\" name=\"trackssubmit\" value=\"Valider\"></td>\r\n");
if(listclasses!=null){
      out.write("\r\n");
      out.write("<td>");
      out.print(listclasses);
      out.write("</td>\r\n");
      out.write("<td><input type=\"submit\" name=\"classsubmit\" value=\"Valider\"></td>\r\n");
if(listgroups!=null){
      out.write("\r\n");
      out.write("<td>");
      out.print(listgroups);
      out.write("</td>\r\n");
      out.write("<td><input type=\"submit\" name=\"groupssubmit\" value=\"Valider\"></td>\r\n");
}}}
      out.write("\r\n");
      out.write("</tr></table>\r\n");
      out.write("</form>\r\n");

if(edt!=null) out.println(edt);

      out.write("\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
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
