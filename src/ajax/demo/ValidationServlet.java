package ajax.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ValidationServlet", urlPatterns = {"/validation.do"})
public class ValidationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");

        String username = request.getParameter("username");
        String message = "用户名可以使用！";
        //这里只做示范式的验证，实际应用可与数据库的用户名比较
        if (username.equals("hacker")) {
            message = "用户名已被占用！";
        }
        PrintWriter out = response.getWriter();
        out.println("<response>");
        out.println("<message>" + message + "</message>");
        out.println("</response>");

    }
}
