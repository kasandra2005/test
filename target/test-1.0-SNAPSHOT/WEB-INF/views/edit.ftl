<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create cat</title>
</head>
<body>
<form name="cat" action="/test/updateCat" method="post">
    <p>Name</p>
    <input title="Id" type="text" name="id" style="display:none" value="${cat.id}"/>
    <input title="Name" type="text" name="name" value="${cat.name}"/>
    <input type="submit" value="OK"/>
</form>

<#if name??>
<p>Please, enter name</p>
</#if>

</body>
</html>