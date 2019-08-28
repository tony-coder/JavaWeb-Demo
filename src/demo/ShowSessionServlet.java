package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ShowSessionServlet", urlPatterns = "/ShowSessionServlet")
public class ShowSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //创建或返回用户会话对象
        HttpSession sess = request.getSession(true);  //当参数为true时创建一个新的会话对象，当参数为false时返回null
        String heading = null;
        //从会话对象中检索accessCount属性
        Integer accessCount = (Integer) sess.getAttribute("accessCount");
        if (accessCount == null) {
            accessCount = new Integer(1);
            heading = "欢迎您，首次登录该页面";
        } else {
            heading = "欢迎您，再次访问该页面";
            accessCount += 1;
        }
        //将accessCount作为属性存储到会话对象中
        sess.setAttribute("accessCount", accessCount);
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>会话跟踪示例</title></head>");
        out.println("<body><center>");

        out.println("<h4>" + heading + "<a href='ShowSessionServlet'>再次访问</a></h4>");
        out.println("<table border='0'>");
        out.println("<tr bgcolor=\"ffad00\"><td>信息</td><td>值</td></tr>\n");
        String state = sess.isNew() ? "新会话" : "旧会话";
        out.println("<tr><td>会话状态：</td><td>" + state + "</td></tr>\n");
        out.println("<tr><td>会话ID：</td><td>" + sess.getId() + "</td></tr>\n");
        out.println("<tr><td>创建时间:<td>");
        out.println("" + new Date(sess.getCreationTime()) + "</tr>\n");
        out.println("<tr><td>最近访问时间:<td>");
        out.println("" + new Date(sess.getLastAccessedTime()) + "</tr>\n");
        out.println("<tr><td>最大不活动时间:<td>" +
                sess.getMaxInactiveInterval() + "</tr>\n");
        out.println("<tr><td>Cookie:<td>" + request.getHeader("Cookie") + "</tr>\n");
        out.println("<tr><td>已被访问次数:<td>" + accessCount + "</tr>\n");
        out.println("</table>");
        out.println("</center></body></html>");
    }
}
