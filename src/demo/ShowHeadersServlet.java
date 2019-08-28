package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ShowHeadersServlet")
public class ShowHeadersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<head><title>请求头文件</title></head>");
        out.println("服务器收到的请求头文件");
        out.println(request.getMethod() + request + " " + request.getRequestURI() + " " +
                request.getQueryString() + " " + request.getProtocol() + "<br>");

        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = (String) headers.nextElement();
            String value = request.getHeader(header);
            out.println(header + " = " + value + "<br>");
        }
        out.println("</body></html>");

    }
}
