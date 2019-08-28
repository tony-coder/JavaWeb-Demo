package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAgent = request.getHeader("User-Agent");
        //在请求对象上存储一个属性
        request.setAttribute("param1", "请求作用域属性");
        //在会话对象上存储一个属性
        request.getSession().setAttribute("param2", "会话作用域属性");
        if ((userAgent != null) && (userAgent.indexOf("MSIE") != -1)) {  //检测是否是从IE浏览器发出
            /*
             * 以"/"开头的相对路径
             *      此时，/代表整个web工程的路径，即http://localhost:8080/
             * 不以"/"开头的相对路径
             *      此时是相对于当前资源的相对路径
             */
            response.sendRedirect("/helloweb/welcome/welcome.jsp");
        } else {
            response.sendRedirect("/helloweb/");
        }
    }
}
