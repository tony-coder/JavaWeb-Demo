<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/4
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>errorHandler</title>
</head>
<body>
<img src="images/404.jpg"><br/>
页面发生了下面的错误: <%=exception.getMessage()%><br/>
请重试！
</body>
</html>
