<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form action="hello-servlet" method="get">
    <div>
        <input type="text" name="name"/>
        <input type="submit" name="click"/>
    </div>
</form>
</body>
</html>