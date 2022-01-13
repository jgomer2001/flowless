<#ftl output_format="HTML">
<html>
<body>

<h1>This is taking you too much time</h1>

<p>${message}
<p>To start the process all over again, click the button below.

<form action="${webCtx.restartUrl}" method="post">
    <input type="hidden" name="flowName" value="${flowName}">
    <input type="submit" value="Restart">
</form>

</body>
</html>
