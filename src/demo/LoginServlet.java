package demo;

import com.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        DataSource dataSource = (DataSource) getServletContext().getAttribute("dataSource");
        try {
            Connection conn = dataSource.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rst = pstm.executeQuery();

            boolean valid = rst.next();
            if (valid) {
                User validuser = new User(username, password);
                request.getSession().setAttribute("user", validuser);
                out.println("欢迎您，" + username);
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        // 用户名和口令均为admin，认为登录成功
//        if (username.equals("admin") && password.equals("admin")) {
//            request.setAttribute("username", username);
//            RequestDispatcher rd = request.getRequestDispatcher("/welcome/welcome.jsp");
//            rd.forward(request, response);
//            /*out.println("登录成功！欢迎您， " + username);*/
//        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
//            rd.forward(request, response);
//            /*out.println("对不起！您的用户名或密码不正确.");*/
//        }
//        out.println("</body></html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
