<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/10
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>customer</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        out.print(msg + "<br>");
    }
%>
请输入客户信息：
<form action="savebean.do" method="post">
    客户名：<input type="text" name="custName"><br>
    Email 地址：<input type="text" name="email"><br>
    电话：<input type="text" name="phone"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
