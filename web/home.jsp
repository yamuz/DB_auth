<%--
  Created by IntelliJ IDEA.
  User: yamuz
  Date: 11.12.2019
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String error = request.getParameter("error");
    if(error!=null&&error.equals("1")){
%>
<h4 style="color: red;">Authentication Error</h4>
<%
    }
%>

<form action="/home" method="post">
    <input type="hidden" name="act" value="auth">
    LOGIN : <input type="text" name="login">
    PASSWORD : <input type="password" name="password">
    <button>SIGN IN</button>
</form>

</body>
</html>
