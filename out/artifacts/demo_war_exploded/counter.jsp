<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/29
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    int count = 0;
%>
<html>
<head>
    <title>计数</title>
</head>
<body>
<%
    count++;
%>
该页面已被访问<%= count %>次

</body>
</html>
