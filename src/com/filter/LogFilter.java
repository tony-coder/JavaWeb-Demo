package com.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "logFilter", urlPatterns = {"/*"}, asyncSupported = true)
public class LogFilter extends HttpFilter {
    private FilterConfig config;

    //实现过滤方法
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //super.doFilter(request, response, chain); 若未注释会出现网页出现重复（双份
        //因为多次重复执行doFilter会导致respon多次重复操作
        //第一次执行过doFilter后response已经包含了jsp的内容，等再次执行doFilter时会再次输出一次jsp内容，最后会导致内容重复出现

        //获取应用上下文对象
        ServletContext context = config.getServletContext();
        //记录开始过滤时间
        long start = System.currentTimeMillis();
        System.out.println("请求的资源: " + request.getRequestURI());
        System.out.println("用户地址: " + request.getRemoteAddr());
        context.log("请求的资源: " + request.getRequestURI());
        context.log("用户地址: " + request.getRequestURI());
        //请求转到下一资源或下一过滤器
        chain.doFilter(request, response);
        //记录返回到过滤器的时间
        long end = System.currentTimeMillis();
        System.out.println("请求的总时间: " + (end - start) + "毫秒");
        context.log("请求的总时间: " + (end - start) + "毫秒");
    }

    //实现初始化方法
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        //super.init();
        this.config = fConfig;
    }
}
