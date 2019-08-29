package com.filter;


import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TextToHTMLFilter extends HttpFilter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        NonCachingRequestWrapper ncre = new NonCachingRequestWrapper(request);
        TextResponseWrapper trw = new TextResponseWrapper(response);
        //将包装后的请求和响应对象传到下一组件
        chain.doFilter(ncre, trw);
        //文本报表已经写入TextResponseWrapper对象中
        String top = "<html><head><title>销售报表</title></head>" + "<body background=\"textReport.gif\"><pre>";
        String bottom = "</pre></body></html>";
        //将文本数据嵌入到页面的<pre>标签中
        StringBuilder htmlFile = new StringBuilder(top);
        String textFile = new String(trw.toByteArray(), "UTF-8");
        htmlFile.append(textFile);
        htmlFile.append("<br>" + bottom);
        //设置请求的字符编码和响应的内容类型
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset= UTF-8");
        //设置内容类型的长度
        response.setContentLength(htmlFile.length());
        //将新数据用实际的PrintWriter输出
        PrintWriter out = response.getWriter();
        out.println(htmlFile.toString());

    }
}
