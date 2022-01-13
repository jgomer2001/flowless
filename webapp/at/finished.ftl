<#ftl output_format="HTML">
<html>
<body>

<#if success>

<h1>Successful authentication!</h1>

<p>In practice this page will not be shown. Instead, user's browser will be taken to the target application

<#else>

<h1>Authentication failed</h1>

<p>${error!""}

<p>Try again later

</#if>


</body>
</html>
