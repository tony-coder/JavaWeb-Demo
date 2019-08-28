package demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.demo.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("custName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Customer customer = new Customer(name, email, phone);

        HttpSession session = request.getSession();
        // 会话作用域对象的访问使用了同步代码块，这是因为HttpSession对象不是先线程安全的，其他Servlet和Jsp页面可能在多个线程中同时访问或修改这些对象
        synchronized (session) {
            session.setAttribute("customer", customer);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/displayCustomer.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
