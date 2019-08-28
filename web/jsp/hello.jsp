<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/6
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<img src="../images/duke.gif">  <!--同级目录-->
My name is Duck.what is yours?
<form action="" method="post">
    <input type="text" name="username" size="25">
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
<%!
    String username = "Duke";
%>
<%@include file="response.jsp" %>
</body>
</html>
