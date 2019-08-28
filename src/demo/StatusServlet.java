package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatusServlet")
public class StatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String qq = request.getParameter("q");
        if (qq == null) {
            out.println("没有提供请求参数.");
        } else if (qq.equals("0")) {
            out.println(response.getStatus() + "<br>");
            out.println("Hello,Guys!");
        } else if (qq.equals("1")) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else if (qq.equals("2")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            response.sendError(404, "resource cannot found!");
        }
    }
}
