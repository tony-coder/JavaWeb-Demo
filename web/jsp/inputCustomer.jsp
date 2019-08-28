<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/13
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入客户信息</title>
</head>
<body>
<h4>输入客户信息</h4>
<form action="/helloweb/CustomerServlet" method="post">
    <table>
        <tr>
            <td>客户名：</td>
            <td><input type="text" name="custName"></td>
        </tr>
        <tr>
            <td>邮件地址：</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td><input type="submit" value="确定"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
