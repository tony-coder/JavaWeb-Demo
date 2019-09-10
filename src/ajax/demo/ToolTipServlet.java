package ajax.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToolTipServlet", urlPatterns = {"/toolTip.do"})
public class ToolTipServlet extends HttpServlet {
    private Map<String, String> dogs = new HashMap<>();

    @Override
    public void init() throws ServletException {
        dogs.put("dog1", "It is a dog");
        dogs.put("dog2", "It is a lovely dog!");
        dogs.put("dog3", "It is a very lovely dog");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String data = dogs.get(key);

        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        out.println("<response>");
        out.println("<description>" + data + "</description>");
        out.println("</response>");
        out.close();

    }
}
