<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/8/1
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>会话监听器示例</title>
</head>
<body>
<table border="1">
    <c:forEach var="s" items="${applicationScope.sessionList}">
        <tr>
            <td><c:out value="${s.id}"></c:out></td>
            <td><c:out value="${s.creationTime}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
