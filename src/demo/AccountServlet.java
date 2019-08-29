package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AccountServlet",urlPatterns = "/account.do")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Declarative Security Example</title>");
        out.println("</head><body>");
        out.println("欢迎你! <br>");
        out.println("HTTP POST请求对所有用户开放!");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Declarative Security Example</title>");
        out.println("</head><body>");
        String name = request.getRemoteUser();  // 若用户已被验证，返回用户名，否则返回null
        out.println("欢迎您，" + name + "!");
        out.println("<br>能够访问该页面，说明你是管理员(manager).");
        out.println("</body></html>");
    }
}