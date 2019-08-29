package demo;

import sun.misc.BASE64Decoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            askForPassword(response);
        } else {
            // 从Authorization请求头中解析出用户名和口令
            String userInfo = authorization.substring(6).trim();
            BASE64Decoder decoder = new BASE64Decoder();
            String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
            int index = nameAndPassword.indexOf(":");
            String username = nameAndPassword.substring(0, index);
            String password = nameAndPassword.substring(index + 1);
            // isUserInRole()返回一个布尔值，表示验证的用户是否属于指定的角色
            if (request.isUserInRole("director")) {
                showDirectorPage(request, response);
            } else if (request.isUserInRole("employee")) {
                showEmployeePage(request, response);
            }
        }
    }

    private void askForPassword(HttpServletResponse response) throws IOException {
        //向客户发送401响应
        response.setHeader("WWW-Authorization", "BASIC realm=\"Programmatic Test\"");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);  //401
    }

    private void showDirectorPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getRemoteUser();
        out.println("<html><head><title>Programmatic Security Example</title>");
        out.println("</head><body>");
        out.println("Welcome, " + username + "!");
        out.println("<br>这是为主管(<b>director</b>)产生的页面.");
        out.println("<br>Authorization: " + request.getHeader("Authorization") + "</b>");
        out.println("</body></html>");
    }

    private void showEmployeePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getRemoteUser();
        out.println("<html><head><title>Programmatic Security Example</title>");
        out.println("</head><body>");
        out.println("Welcome, " + username + "!");
        out.println("<br>这是为职员(<b>director</b>)产生的页面.");
        out.println("<br>Authorization: " + request.getHeader("Authorization") + "</b>");
        out.println("</body></html>");
    }
}
