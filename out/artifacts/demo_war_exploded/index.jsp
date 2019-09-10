<%--/
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/3/26
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <style type="text/css">
        a {
            display: block;
        }
    </style>
</head>
<body>
<div>
    <%--    客户端路径是指运行在浏览器上的路径。--%>
    <%--    比如：表单、超链接、js（location.href）、Ajax（url）、CSS和JS的引入以及重定向等--%>
    <%--    路径分为绝对路径和相对路径，相对路径又分为相对主机的路径和相对于当前请求的路径--%>
    <a href="login.jsp">登录</a>

    <a href="questions.jsp">测试</a>
    <!-- 不以"/"开头的相对地址 -->
    <!--
        不以/开头，则相对于当前资源的路径
        当前资源的路径为:http://localhost:8080/helloweb/
        而showtime.do也在此路径下
        所以直接书写showtime.do
     -->
    <a href="showtime.do">显示时间</a>

    <!-- 以"/"开头的相对地址 -->
    <!-- /代表了整个web项目，即:http://localhost:8080/ -->
    <a href="/helloweb/RedirectServlet">请求转发（根据浏览器）</a>

    <a href="configDemo.do">Servlet配置对象ServletConfig</a>

    <a href="${pageContext.request.contextPath}/fileUpload.jsp">上传文件</a>

    <a href="fileDownload.do">下载</a>

    <a href="/helloweb/ShowSessionServlet">查看会话状态</a>

    <a href="/helloweb/GussNumberServlet">玩猜数游戏</a>

    <a href="SendCookie">向客户发送一个Cookie对象</a>

    <a href="ReadCookie">从客户端读取Cookies</a>

    <a href="counter.jsp">counter.jsp</a>

    <a href="todayDate.jsp">查看今天的日期</a>

    <a href="area.jsp">计算圆的面积</a>

    <a href="customer.jsp">保存javaBean</a>

    <a href="jsp/inputCustomer.jsp">输入客户信息</a>

    <a href="jsp/queryProduct.jsp">查询商品</a>

    <a href="jsp/addCustomer.jsp">插入记录</a>

    <a href="jsp/listenerTest.jsp">监听器示例</a>

    <a href="jsp/onlineCount.jsp">请求监听器示例</a>

    <a href="jsp/sessionDisplay.jsp">会话监听器示例</a>

    <a href="asyncDemo">异步处理模拟</a>

    <a href="sayncListener">异步监听器示例</a>

    <form method="post" action="account.do">
        <a href="account.do">安全验证示例</a>
        <input type="submit" value="post">
    </form>

    <a href="authorize.do">编程式安全示例</a>

    <a href="AJAX/simpleRequest.html">异步刷新简单示例</a>

    <a href="AJAX/innerHTML.html">学生查询异步</a>

    <a href="AJAX/parseXML.html">Parseing XML Response with DOM</a>

    <a href="AJAX/gynamicContent.html">动态创建页面内容</a>

    <a href="AJAX/register.html">AJAX数据验证示例</a>

    <a href="AJAX/dynamicList.html">AJAX动态加载列表框示例</a>

    <a href="AJAX/toolTip.html">AJAX创建工具提示</a>

    <img src="images/duke.gif">
</div>

</body>
</html>
