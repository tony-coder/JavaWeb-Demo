<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/5
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>initTest</title>
</head>
<body>
公司名称：<%=config.getInitParameter("company") %><br>
邮箱地址：<%=config.getInitParameter("email") %>
</body>
</html>
