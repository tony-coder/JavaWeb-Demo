<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/29
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Today's date</title>
</head>
<body>
<%
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
    String s = dateFormat.format(new Date());
%>
今天的日期是：<%=s%>
</body>
</html>
