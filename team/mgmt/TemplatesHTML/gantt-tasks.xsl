<?xml version="1.0" encoding="iso-8859-2" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:output method="html" indent="yes" encoding="UTF-8"/>

<xsl:include href="gantt-utils.xsl"/>

<xsl:template match="tasks">

<table width="80%" border="0">
 <tr>
  <td class="HEADER"><xsl:value-of select="@name"/></td>
  <td width="80" align="center" class="HEADER"><xsl:value-of select="@begin"/></td>
  <td width="80" align="center" class="HEADER"><xsl:value-of select="@end"/></td>
  <td class="HEADER"><xsl:value-of select="@milestone"/></td>
  <td width="50" align="center" class="HEADER">Etat</td>
  <td width="200" align="center" class="HEADER"><xsl:value-of select="@assigned-to"/></td>
  <td class="HEADER"><xsl:value-of select="@notes"/></td>
 </tr>
 <xsl:for-each select="task">
	<tr>
		<td valign="top" bgcolor="#e9edf5">
			<xsl:attribute name="style">
				<xsl:choose>
					<xsl:when test="number(@depth) &gt; 0">
						<xsl:text>padding-left: </xsl:text>
						<xsl:value-of select="number(@depth)"/>
						<xsl:text>em;</xsl:text>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text>text-decoration: underline;</xsl:text>
					</xsl:otherwise>
			</xsl:choose>
			</xsl:attribute><b><xsl:value-of select="name"/></b></td>
		<td valign="top" bgcolor="#eef2f7"><xsl:value-of select="begin"/></td>
		<td valign="top" bgcolor="#e9edf5"><xsl:value-of select="end"/></td>
		<td valign="top" align="center" bgcolor="#eef2f7">
			<xsl:choose>
				<xsl:when test="milestone='true'">Oui</xsl:when>
				<xsl:otherwise>Non</xsl:otherwise>
			</xsl:choose>
		</td>
		<td valign="top" align="center" bgcolor="#e9edf5"><xsl:value-of select="progress"/> %</td>
		<td valign="top" bgcolor="#eef2f7"><xsl:value-of select="assigned-to"/></td>
		<td valign="top" bgcolor="#e9edf5"><pre width="40"><xsl:value-of select="notes"/></pre></td>
	</tr>
  </xsl:for-each>
</table>
</xsl:template>

</xsl:stylesheet>
