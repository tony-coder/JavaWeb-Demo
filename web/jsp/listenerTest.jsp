<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/7/31
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*,javax.sql.*" %>
<%
    DataSource dataSource = (DataSource) application.getAttribute("dataSource");
    Connection conn = dataSource.getConnection();
    String sql = "SELECT * FROM products";
    PreparedStatement pstm = conn.prepareStatement(sql);
    ResultSet rst = pstm.executeQuery();
%>
<html>
<head>
    <title>listenerTest</title>
</head>
<body>
<h4>商品表信息</h4>
<table border="1">
    <tr>
        <td>商品号</td>
        <td>商品名</td>
        <td>价格</td>
        <td>库存</td>

    </tr>
    <%
        while (rst.next()) {
    %>
    <tr>
        <td><%=rst.getString(1)%>
        </td>
        <td><%=rst.getString(2)%>
        </td>
        <td><%=rst.getDouble(3)%>
        </td>
        <td><%=rst.getInt(4)%>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
