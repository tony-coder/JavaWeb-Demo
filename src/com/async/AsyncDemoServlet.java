package com.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(urlPatterns = "/asyncDemo", asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>异步调用demo</title></head>");
        out.println("<body>");
        out.println("进入Servlet的时间" + LocalTime.now() + ".<br>");
        out.flush();
        AsyncContext asyncContext = request.startAsync();  // 开始异步调用并返回异步上下文对象
        asyncContext.setTimeout(30 * 1000);  //毫秒时间 设置异步调用的超时时长30秒
        asyncContext.start(new Executor(asyncContext));
        out.println("结束Servlet的时间: " + LocalTime.now() + ".<br>");
        out.flush();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
