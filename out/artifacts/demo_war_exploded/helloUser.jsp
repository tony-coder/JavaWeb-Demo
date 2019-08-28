<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/4
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--使用Page指令的errprPage属性指定的页面优先级高--%>
<%@ page errorPage="errorHandler.jsp" %>
<html>
<body>
<%
    if (request.getParameter("name") == null) {
        throw new RuntimeException("没有指定name请求参数");
    }
%>
Hello,<%=request.getParameter("name")%>
</body>
</html>
