<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/4
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    int count = 0;

    public void jspInit() {  //覆盖jspInit()
        System.out.println("jspInt...");
    }

    public void jspDestroy() {  //覆盖jspDestroy
        System.out.println("jspDestroy...");
    }
%>
<html>
<head>
    <title>jspInit and jspDestroy</title>
</head>
<body>
<%
    count++;
%>
覆盖jspInit()和jspDestroy()!<br>
该页面被访问<%=count%>次
</body>
</html>
