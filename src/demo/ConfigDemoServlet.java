package demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet", urlPatterns = {"/configDemo.do"},
        initParams = {
                @WebInitParam(name = "email", value = "hacker@163.com"),
                @WebInitParam(name = "telephone", value = "8899123")
        })
public class ConfigDemoServlet extends HttpServlet {
    String servletName = null;
    ServletConfig config = null;
    String email = null;
    String telephone = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
        servletName = config.getServletName();
        email = config.getInitParameter("email");
        telephone = config.getInitParameter("telephone");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*等效
        servletName=getServletConfig().getServletName();
        email = getServletConfig().getInitParameter("email");
        telephone = getServletConfig().getInitParameter("telephone");*/
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<head><title>配置对象</title></head>");
        out.println("Servlet 名称: " + servletName + "<br>");
        out.println("Email 地址: " + email + "<br>");
        out.println("电话: " + telephone);
        out.println("</body></html>");

    }
}
