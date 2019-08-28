<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/4/14
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>上传文件</title>
</head>
<body>
${message}<br/>
<form action="fileUpload.do" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td colspan="2" align="center">文件上传</td>
        </tr>
        <tr>
            <td>会员号：</td>
            <td><input type="text" name="id" size="30"></td>
        </tr>
        <tr><td>文件名：</td>
            <td><input type="file" name="fileName" size="30"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="提交"></td>
            <td align="left"><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
