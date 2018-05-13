<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1><a href="/test/search/">Cats List</a></h1>
<form name="cat" action="/test/searchCat" method="post">
    <p>Name</p>
    <input title="Name" type="text" name="name"/>
    <input type="submit" value="Search Cat"/>
</form>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
     <#list cats as cat>
        <tr>
            <td>${cat.id}</td>
            <td>${cat.name}</td>
            <td><a href="/test/delete/${cat.id}">DELETE</a></td>
            <td><a href="/test/update/${cat.id}">UPDATE</a></td>
        </tr>
    </#list>
</table>

<br>

<form action="/test/">
   <button type="submit">Menu</button>
</form>

</body>
</html>