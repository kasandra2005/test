<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create cat</title>
</head>
<body>
<form name="cat" action="/test/create" method="post">
    <p>Name</p>
    <input title="Name" type="text" name="name"></input>
    <input type="submit" value="Create cat"></input>
</form>
<#if name??>
    <p>Please, enter name</p>
</#if>

<br>

<form action="/test/">
    <button type="submit">Menu</button>
</form>

</body>
</html>