package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleTestServlet")
public class SimpleTestServlet extends HttpServlet {
    private static final long serialVersionlet = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String quest1 = request.getParameter("quest1");
        String quest2 = request.getParameter("quest2");
        String[] quest3 = request.getParameterValues("quest3");
        String quest4 = request.getParameter("quest4").trim();
        int score = 0;
        if (quest1 != null && quest1.equals("1")) {
            score += 25;  //答对一题加25分
        }
        if (quest2 != null && quest2.equals("3")) {
            score += 25;
        }
        if (quest3 != null && quest3.length == 2 && quest3[0].equals("1") && quest3[1].equals("3")) {
            score += 25;
        }
        if (quest4 != null && (quest4.equals("HttpServlet") ||
                quest4.equals("javax.servlet.http.HttpServlet"))) {
            score = score + 25;
        }
        out.println("<html><head>");
        out.println("<title>测测试结果</title>");
        out.println("</head><body>");
        out.println("你的成绩是: " + score + "分");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
