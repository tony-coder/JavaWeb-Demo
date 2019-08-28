<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/3/26
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="login.do" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
            <td><input type="reset" value="取消"/></td>
        </tr>
    </table>
</form>
<form action="ClientInfoServlet" method="get">
    <input type="submit" value="获取客户端信息">
</form>
<form action="/helloweb/ShowHeadersServlet" method="get">
    <input type="submit" value="检索HTTP请求头">
</form>
<form action="getStatus" method="get">
    <input type="text" name="q"/>
    <input type="submit" value="状态码测试"/>
</form>
</body>
</html>
