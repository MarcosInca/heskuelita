<%@ page import="com.capgemini.heskuelita.entity.UserAnnotation" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login Page</title>
</head>

<body>
<%UserAnnotation us = (UserAnnotation)session.getAttribute ("user");%>
Bienvenido : <%=us.getUsername()%>
</body>

</html>