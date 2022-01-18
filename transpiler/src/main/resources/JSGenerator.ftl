<#ftl output_format="JavaScript">
<#--
- This templates generates valid JS code that should be run in non-strict mode
- Only one function is created and must not contain inner functions
- Any functions called here are implemented in file util.js
- An initial underscore in variables and function names prevent flow writers to use variables with the same names in their DSL code
-->

//Generated at ${.now?iso_utc}
function ${flow.@id}<#recurse flow>
}

<#macro header>
(
<#if .node.inputs?size gt 0>
    ${.node.inputs.short_var?join(", ")}
</#if>
) {
const _basePath = ${.node.base.STRING}
let _it = null, _it2 = null
<#-- repIt is accessible to flow writers (it's not underscore-prefixed). It allows to access the status of loops -->
let repIt = []
</#macro>

<#macro statement>
    <#recurse>
</#macro>

<#macro assignment><@util_preassign node=.node /> ${.node.expression}
</#macro>

<#macro rrf_call>
    <#local hasbool = .node.BOOL?size gt 0>
    
    <#if .node.statusr_block?size gt 0><#visit .node.statusr_block></#if>    
    <#if .node.variable?size = 0>
        _it = {}
    <#else>
        _it = ${.node.variable}
    </#if>

    _it = _renderReplyFetch(_basePath, ${.node.STRING}, ${hasbool?then(.node.BOOL, "false")}, _it)
    <#-- See FlowService#continueFlow > scriptCtx#resumeContinuation -->
    _it2 = JSON.parse(_it.second)
    if (_it.first.booleanValue()) return _abort(_it2)

    <@util_preassign node=.node /> _it2
    <#-- Clear temp variables to make serialization lighter (in the next RRF call) -->
    _it = null
    _it2 = null
</#macro>

<#macro action_call>
    <#local catch=.node.preassign_catch?size gt 0>

    <#if catch>
try {
    </#if>
    <@util_preassign node=.node /> _actionCall(<#visit .node.call>)

    <#if catch>
} catch (_e) {
     var ${.node.preassign_catch.short_var} = _e
}
    </#if>
</#macro>

<#macro flow_call>
    <@util_preassign node=.node />
_flowCall(_basePath, <@util_url_overrides node=.node.overrides/>, <#visit .node.call>)
</#macro>

<#macro call>

<#if .node.variable?size gt 0>
    ${.node.variable}, null
<#else>
    "${.node.call_subject.qname}", "<#if .node.call_subject.ALPHANUM?size gt 0>${.node.call_subject.ALPHANUM}</#if>"
</#if>

<@util_argslist node=.node prefix=", " />
</#macro>

<#macro rfac>
<#if .node.variable?size = 0>
    _it = ${.node.STRING}
<#else>
    _it = ${.node.variable}
</#if>
    <@util_preassign node=.node /> _redirectFetchAtCallback(_it)
    _it = null
</#macro>

<#macro finish>
<#if .node.variable?size = 0>
    _it = ${.node.BOOL}
<#else>
    _it = ${.node.variable}
</#if>
return _finish(_it)
</#macro>

<#macro loop>
    <#if .node.variable?size = 0>
_it = ${.node.UINT}
    <#else>
_it = ${.node.variable}
    </#if>
_ensureNumber(_it, "Number of iterations passed to Repeat is invalid")

<@util_preassign node=.node /> null
repIt.push(0)
for (let _times = _it; _times > 0; _times--) {
    repIt[repIt.length - 1]++

    <#list .node.statement as st>
        <#recurse st>
    </#list>

    <#if .node.quit_stmt?size gt 0><#visit .node.quit_stmt></#if>
}
_it = repIt.pop()

<#if .node.preassign?size gt 0>
${.node.preassign.variable} = _it
</#if>

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
if (_equals(${.node.simple_expr }, ${case.simple_expr})) {
        <#list case.statement as st>
            <#recurse st>
        </#list>
}
    </#list>
<@util_else node=.node.elseblock />
</#macro>

<#macro boolean_expr>
    <#if .node.NOT?size gt 0>!</#if>
_equals(${.node.simple_expr[0]}, ${.node.simple_expr[1]})
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
_log(<@util_argslist node=.node prefix="" />)
</#macro>

<#macro statusr_block>
    <#local isuint = .node.statusr_allow.variable?size = 0>
    <#local isequality = statusr_until.boolean_expr.NOT?size gt 0>

_allowStatusRequest(${isuint?then(.node.statusr_allow.UINT!"", .node.statusr_allow.variable!"")},
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
    <#local var = "" >
    <#if node.preassign?size = 0>
        <#if node.preassign_catch?size gt 0 && node.preassign_catch.variable?size gt 0>
            <#local var = node.preassign_catch.variable >
        </#if>
    <#else>
        <#local var = node.preassign.variable >
    </#if>
    <#if var?length gt 0>
<#if var?index_of(".") == -1 || var?index_of("[") == -1>var </#if>${var} =
    </#if> 
</#macro>

<#macro util_argslist node prefix>
<#if node.argument.simple_expr?size gt 0>${prefix}</#if>${node.argument.simple_expr?join(", ")}
</#macro>

<#macro util_url_overrides node>
[${node.STRING?join(", ")}]
</#macro>

<#macro @element></#macro>
