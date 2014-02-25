<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    
    <xsl:template match="/">
        <html>
            <body>
                <h1>
                    <xsl:value-of select="."/>
                </h1>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>