<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/25
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品查询</title>
</head>
<body>
<form action="/helloweb/queryproduct.do" method="post">
    请输入商品号：
    <input type="text" name="productid" size="15">
    <input type="submit" value="确定">

</form>
<p>
    <a href="/helloweb/queryproduct.do">查询所有商品</a>
</p>
</body>
</html>
