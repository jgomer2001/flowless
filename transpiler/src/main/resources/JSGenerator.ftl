<#ftl output_format="JavaScript">

//Generated at ${.now?iso_utc}
function ${flow.@id}<#recurse flow>
}

<#macro header>
(
<#if .node.inputs?size gt 0>
    ${.node.inputs.short_var?join(", ")}
</#if>
) {
_basePath = ${.node.base.STRING}
</#macro>

<#macro statement>
    <#recurse>
</#macro>

<#macro assignment><@util_preassign node=.node /> ${.node.expression}</#macro>

<#macro rrf_call>
    <#if .node.statusr_block?size gt 0><#visit .node.statusr_block></#if>
    <#assign isvar = .node.object_expr?size = 0>
    it = ${isvar?then(.node.variable!"", .node.object_expr!"")}

<@util_preassign node=.node />
RenderReplyFetch(_basePath, ${.node.STRING}, it)
</#macro>

<#macro action_call>
    <#assign catch=.node.preassign_catch?size gt 0>

    <#if catch>
${.node.preassign_catch.short_var} = null;
try {
    </#if>
    <@util_preassign node=.node />

    ActionCall(<#visit .node.call>)
    <#if catch>
} catch (e) {
     ${.node.preassign_catch.short_var} = e
}
    </#if>
</#macro>

<#macro flow_call>
    <@util_preassign node=.node />
FlowCall(<@util_url_overrides node=.node.overrides/>, <#visit .node.call>)
</#macro>

<#macro call>
"${.node.qname}<#if .node.ALPHANUM?size gt 0>#${.node.ALPHANUM}</#if>"
<@util_argslist node=.node prefix=", " />
</#macro>

<#macro redirect>
Redirect(${.node.STRING}<#if .node.UINT?size gt 0>, ${.node.UINT}</#if>)
</#macro>

<#macro finish>
<#if .node.object_expr?size = 0>
    it = { success: ${.node.BOOL} }
<#else>
    it = ${.node.object_expr}
</#if>
return it
</#macro>

<#macro loop>
    <#if .node.variable?size = 0>
it = ${.node.UINT}
    <#else>
it = ${.node.variable}
    </#if>

for (let count = 0; count < it; count++) {

    <#list .node.statement as st>
        <#recurse st>
    </#list>

    <#visit .node.quit_stmt>
}
</#macro>

<#macro ifelse>
if (<#recurse .node.caseof>) {
    <#list .node.statement as st>
        <#recurse st>
    </#list>
}
<@util_else node=.node.elseblock />
</#macro>

<#macro quit_stmt>
if (<#recurse .node.caseof>) break
<@util_else node=.node.elseblock />
</#macro>

<#macro choice>
    <#list .node.option as case>
        <#if case?index gt 0>else </#if>
if (equals(${.node.simple_expr },${case.simple_expr})) {
        <#list case.statement as st>
            <#recurse st>
        </#list>
}
    </#list>
<@util_else node=.node.elseblock />
</#macro>

<#macro boolean_expr>
    <#if .node.NOT?size gt 0>!</#if>
equals(${.node.simple_expr[0]}, ${.node.simple_expr[1]})
</#macro>

<#macro boolean_op_expr>
    <#if .node.AND?size = 0>
||
    <#else>
&&
    </#if>
    <#recurse>
</#macro>

<#macro log>
Log(<@util_argslist node=.node prefix="" />)
</#macro>

<#macro statusr_block>
    <#assign isuint = .node.statusr_allow.variable?size = 0>
    <#assign isequality = statusr_until.boolean_expr.NOT?size gt 0>

AllowStatusRequest(${isuint?then(.node.statusr_allow.UINT!"", .node.statusr_allow.variable!"")},
    "${.node.statusr_until.boolean_expr.simple_expr[0]!""}", "${.node.statusr_until.boolean_expr.simple_expr[1]!""}",
    ${isequality?c}, [<#recurse .node.statusr_reply>])
</#macro>

<#macro util_else node>
<#if node?size gt 0>
else {
    <#recurse node>
}
</#if>
</#macro>

<#macro util_preassign node>
<#if node.preassign?size = 0>
    <#if node.preassign_catch?size gt 0>
${node.preassign_catch.variable} =
    </#if>
<#else>
${node.preassign.variable} =
</#if>
</#macro>

<#macro util_argslist node prefix>
<#if node.argument.simple_expr?size gt 0>${prefix}</#if>${node.argument.simple_expr?join(", ")}
</#macro>

<#macro util_url_overrides node>
[${node.STRING?join(", ")}]
</#macro>

<#macro @element></#macro>
