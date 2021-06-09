<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="3.0">

    <xsl:output method="text" encoding="UTF-8" />
    
    <xsl:variable name="now" select="current-dateTime()"/>
    
    <xsl:template name="arglist">
        <xsl:param name="args" />
        (
        <xsl:for-each select="$args">
            <xsl:if test="position() gt 1">, </xsl:if><xsl:value-of select="." />
        </xsl:for-each>
        )
    </xsl:template>
    
    <xsl:template name="issuecall">
        <xsl:param name="type" />
        <xsl:param name="call" />
    
        <xsl:choose>
            <xsl:when test="$type='task_call'">taskCall</xsl:when>
            <xsl:otherwise>flowCall</xsl:otherwise>
        </xsl:choose>
        ('<xsl:value-of select="$call/qname"/>')
        <xsl:call-template name="arglist"><xsl:with-param name="args" select="$call/argument" /></xsl:call-template>
    </xsl:template>
    
    <xsl:template name="equals">
        <xsl:param name="one" />
        <xsl:param name="two" />
        (equals(<xsl:value-of select="$one" />, <xsl:value-of select="$two" />))
    </xsl:template>
    
    <xsl:template match="flow">

//Generated at <xsl:value-of select="$now"/>
function 
    <xsl:apply-templates />
}
    </xsl:template>

    <xsl:template match="header">
        <xsl:value-of select="replace(qname,'\.','_')" />
        <xsl:call-template name="arglist"><xsl:with-param name="args" select="inputs/param" /></xsl:call-template> {
    </xsl:template>
    
    <xsl:template match="invocation">
        <xsl:if test="variable"><xsl:value-of select="variable"/> = </xsl:if>
        <xsl:call-template name="issuecall">
            <xsl:with-param name="type" select="@type" />
            <xsl:with-param name="call" select="call" />
        </xsl:call-template>
    </xsl:template>
    
    <xsl:template match="log">
        print
        <xsl:call-template name="arglist"><xsl:with-param name="args" select="argument" /></xsl:call-template>
    </xsl:template>
    
    <xsl:template match="assignment">
        <xsl:value-of select="variable"/> = <xsl:value-of select="expression"/>
        <xsl:text>
        </xsl:text>
    </xsl:template>

    <xsl:template match="accept">    
        accept(<xsl:value-of select="."/>)
    </xsl:template>
    
    <xsl:template match="reject">    
        reject(<xsl:value-of select="."/>)    
    </xsl:template>

    <xsl:template match="ifelse">       
        if <xsl:apply-templates select="caseof" /> {
        <xsl:apply-templates select="*[not(self::elseblock || self::caseof)]" />
        }
        <xsl:apply-templates select="elseblock" />
    </xsl:template>

    <xsl:template match="caseof">
        <xsl:call-template name="equals">
            <xsl:with-param name="one" select="simple_expr[1]" />
            <xsl:with-param name="two" select="simple_expr[2]" />
        </xsl:call-template>
    </xsl:template>

    <xsl:template match="elseblock">
       else {
          <xsl:apply-templates />
       }
    </xsl:template>

    <xsl:template match="choice">
        <xsl:for-each select="option">
            <xsl:if test="position() gt 1">else </xsl:if>if
            <xsl:call-template name="equals">
                <xsl:with-param name="one" select="../simple_expr" />
                <xsl:with-param name="two" select="simple_expr" />
            </xsl:call-template>
            {
            <xsl:apply-templates select="*[not(self::simple_expr)]" />    
            }
        </xsl:for-each>
        <xsl:apply-templates select="elseblock" />
    </xsl:template>
    
    <xsl:template match="loop">
        for (var counter = 0; counter<xsl:text disable-output-escaping="yes">&lt;</xsl:text>
            <xsl:value-of select="@times" />; counter++) {
            <xsl:apply-templates />
        }
    </xsl:template>
    
    <xsl:template match="quit_stmt">
        if <xsl:apply-templates select="caseof" /> {
            break;
        }
        <xsl:apply-templates select="elseblock" />
    </xsl:template>
    
</xsl:stylesheet>
