<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/25
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*,com.demo.Product" %>
<html>
<head>
    <title>显示所有商品</title>
</head>
<body>
<table border="1">
    <tr>
        <td>商品号</td>
        <td>商品名</td>
        <td>价格</td>
        <td>数量</td>
    </tr>
    <%
        ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");
        for (Product product : productList) {

    %>
    <tr>
        <td><%=product.getProd_id()%></td>
        <td><%=product.getPname()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getStock()%></td>
    </tr>

    <%
        }
    %>

</table>
</body>
</html>
