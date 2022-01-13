<#ftl output_format="HTML">
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<body>

<p> <b>${nick}</b>, choose your favorite instrument from the list:</p>

<form method="post" enctype="application/x-www-form-urlencoded">

    <#list instruments as instr>        
        <div>
            <input type="radio" name="favorite" id="${instr?counter}" value="${instr}">
            <label for="${instr?counter}">${instr}</label>
        </div>
    </#list>
    
    <input type="submit" value="Continue" />
</form>

</body>
</html>
