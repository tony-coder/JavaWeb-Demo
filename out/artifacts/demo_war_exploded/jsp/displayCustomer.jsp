<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/13
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" class="com.demo.Customer" scope="session">
    <jsp:setProperty name="customer" property="*"/>  <!--设置bean的所有属性的捷径 将使用请求参数的每个值为属性赋值-->
</jsp:useBean>
<html>
<head>
    <title>显示客户信息</title>
</head>
<body>
<h4>客户信息如下</h4>
<table border="1">
    <tr>
        <td>客户名：</td>
        <td><jsp:getProperty name="customer" property="custName"/></td>
    </tr>
    <tr>
        <td>Email地址：</td>
        <td><jsp:getProperty name="customer" property="email"/></td>
    </tr>
    <tr>
        <td>电话：</td>
        <td><jsp:getProperty name="customer" property="phone"/></td>
    </tr>
</table>
</body>
</html>
