<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/27
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input a Customer</title>
</head>
<body>
<font color="red">${result}</font>
<p>请输入一条客户记录</p>
<form action="/helloweb/addCustomer.do" method="post">
    <table>
        <tr>
            <td>客户号:</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>客户名:</td>
            <td><input type="text" name="custName"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>余额：</td>
            <td><input type="text" name="balance"></td>
        </tr>
        <tr>
            <td><input type="submit" value="确定"></td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
