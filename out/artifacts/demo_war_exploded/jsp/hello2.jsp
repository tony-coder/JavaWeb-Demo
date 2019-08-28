<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/6
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body bgcolor="white">
<img src="../images/duke.gif">
My name is Duke. What is yours?
<form action="" method="post">
    <input type="text" name="username" size="25">
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
<%
    String userName = request.getParameter("username");
    request.setAttribute("username", userName);
    application.setAttribute("username", userName);
%>
<jsp:include page="response2.jsp"/>
</body>
</html>
