<?xml version="1.0" encoding="iso-8859-2" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:output method="html" indent="yes" encoding="UTF-8"/>

<xsl:include href="gantt-utils.xsl"/>

<xsl:template match="resources">
<table width="600" border="0">
 <tr>
  <td class="HEADER"><xsl:value-of select="@name"/></td>
  <td class="HEADER"><xsl:value-of select="@role"/></td>
  <td class="HEADER"><xsl:value-of select="@mail"/></td>
  <td class="HEADER"><xsl:value-of select="@phone"/></td>
 </tr>
  <xsl:for-each select="resource">
	<tr>
		<td valign="top" bgcolor="#e9edf5" ><b><xsl:value-of select="name"/></b></td>
		<td valign="top" bgcolor="#eef2f7"><xsl:value-of select="role"/></td>
		<td valign="top" bgcolor="#e9edf5"><a><xsl:attribute name="href">mailto:<xsl:value-of select="mail"/></xsl:attribute><xsl:value-of select="mail"/></a></td>
		<td valign="top" bgcolor="#eef2f7"><xsl:value-of select="phone"/></td>
	</tr>
  </xsl:for-each>
</table>

<br/><br/>
<img>
	<xsl:attribute name="src"><xsl:value-of select="/ganttproject/resources/chart/@path"/></xsl:attribute>
</img>
<br/>

</xsl:template>

</xsl:stylesheet>

