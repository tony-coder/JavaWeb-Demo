<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/5
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Compute Prime</title>
</head>
<body>
<%
    for (int n = 2; n < 100; n++) {
        int i;
        for (i = 2; i < n; i++) {
            if (n % i == 0)
                break;
        }
        if (i == n) {
%>
<%=n%>&nbsp;&nbsp;
<%
        }
    }
%>
</body>
</html>
