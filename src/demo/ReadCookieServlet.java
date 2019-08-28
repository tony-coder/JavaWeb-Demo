package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadCookieServlet",urlPatterns = "/ReadCookie")
public class ReadCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookieName = "username";
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie=cookies[i];
                if (cookie.getName().equals(cookieName))
                    cookieValue = cookie.getValue();
            }
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><title>读取Cookie</title>");
        out.println("<body><h3>从浏览器读回一个Cookie</h3>");
        out.println("Cookie名：" + cookieName + "<br>");
        out.println("Cookie值：" + cookieValue + "<br>");
        out.println("</body></html>");

    }
}
