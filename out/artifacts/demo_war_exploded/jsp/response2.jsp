<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/6
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = (String) request.getAttribute("username");
    String userName2 = (String) application.getAttribute("username");
%>
<h3><font color="blue"> Hello, <%=userName%>!</font></h3>
<p>another <%=userName2%></p>
