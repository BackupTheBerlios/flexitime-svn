<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	version="1.0">


<xsl:variable name="font" select="'sans-serif'"/>
<xsl:template match="titre">
	<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
		<fo:page-sequence master-reference="simple">
 			<fo:flow flow-name="xsl-region-body">
				<fo:block font-size="15pt"
					line-height="24pt"
		      		space-after.optimum="15pt"
		     			color="black"
		     			text-align="center"
		     			padding-top="3pt">
                			<xsl:attribute name="font-family">
                   			 <xsl:value-of select="$font"/>
                			</xsl:attribute>
					<xsl:value-of select="text()"/>
		    			<!-- <xsl:apply-templates select="title"/> -->
				</fo:block>
      		</fo:flow>
    		</fo:page-sequence>
	</fo:root>

</xsl:template>
</xsl:stylesheet>
