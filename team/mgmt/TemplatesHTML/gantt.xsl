<?xml version="1.0" encoding="iso-8859-2" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:output method="html" indent="yes" encoding="UTF-8"/>

<xsl:include href="gantt-utils.xsl"/>

<xsl:template match="project">
    <table width="550" border="0">
     <tr>
      <td valign="top" BGCOLOR="#E9EDF5"><b><xsl:value-of select="name/@title"/></b></td>
      <td valign="top" BGCOLOR="#EEF2F7"><xsl:value-of select="name"/></td>
     </tr>
     <tr>
      <td valign="top" bgcolor="#E9EDF5"><b><xsl:value-of select="organization/@title"/></b></td>
      <td valign="top" BGCOLOR="#EEF2F7"><xsl:value-of select="organization"/></td>
     </tr>
     <tr>
      <td valign="top" bgcolor="#E9EDF5"><b><xsl:value-of select="description/@title"/></b></td>
      <td valign="top" BGCOLOR="#EEF2F7"><xsl:value-of select="description"/></td>
     </tr>
    </table>
</xsl:template>

</xsl:stylesheet>
