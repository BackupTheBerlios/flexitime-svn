<?xml version="1.0" encoding="iso-8859-2" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template name="header">
    <br /><br />
    
    <center><table width="100%" border="0"><tr><td bgcolor="#FFFFFF">
    <font CLASS="TITREA"><b><xsl:value-of select="/ganttproject/project/name"/></b></font>
    </td></tr></table></center>
    
    <center><table width="80%" border="0"><tr>  
    <td bgcolor="#6d9ec6"><center>
    
    <a>
	<xsl:attribute name="href"><xsl:value-of select="/ganttproject/links/@prefix" />.html</xsl:attribute>
	<xsl:value-of select="/ganttproject/links/home" />
    </a>  | 
    <a>
	<xsl:attribute name="href"><xsl:value-of select="/ganttproject/links/@prefix" />-chart.html</xsl:attribute>
	<xsl:value-of select="/ganttproject/links/chart" />
    </a> | 
    <a>
	<xsl:attribute name="href"><xsl:value-of select="/ganttproject/links/@prefix" />-tasks.html</xsl:attribute>
	<xsl:value-of select="/ganttproject/links/tasks" />
    </a> | 
    <a>
	<xsl:attribute name="href"><xsl:value-of select="/ganttproject/links/@prefix" />-resources.html</xsl:attribute>
	<xsl:value-of select="/ganttproject/links/resources" />
    </a>
    
    </center></td></tr></table></center>
    
    <br />
    
</xsl:template>

<xsl:template name="footer">
    <br />
    <center>
    <table width="80%" border="0" cellpadding="0" cellspacing="0"><tr>  
    <td bgcolor="#6d9ec6" width="50%" align="center">
	<b><xsl:value-of select="/ganttproject/footer/@date"/></b>
    </td></tr></table>
    </center>
</xsl:template>

<xsl:template match="/">
    <html>
	<head>
	    <meta name="author" content="Jérôme GUERS" />
	    <title>Suivi d'avancement de FlexiTime</title>
	
	    <style>@import url("../npds/themes/Carnet/style/style.css"); </style>
    </head>
    <body>
    <center>
	    <xsl:call-template name="header"/>
	    <xsl:apply-templates/>
    </center>
    <xsl:call-template name="footer"/>
    </body>
    </html>
</xsl:template>

<xsl:template match="links" />
<xsl:template match="title" />
<xsl:template match="project" />
<xsl:template match="chart" />
<xsl:template match="resources" />
<xsl:template match="tasks" />

</xsl:stylesheet>
