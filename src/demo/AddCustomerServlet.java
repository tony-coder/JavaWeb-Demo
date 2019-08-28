package demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.*;
import com.demo.Customer;

@WebServlet("/addCustomer.do")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao dao = new CustomerDao();
        Customer customer = new Customer();
        String message=null;
        try {
            customer.setId(request.getParameter("id"));
            //将传递来的字符串重新使用utf-8编码
            customer.setCustName(new String(request.getParameter("custName").getBytes("iso-8859-1"), "UTF-8"));
            customer.setEmail(new String(request.getParameter("email").getBytes("iso-8859-1"), "UTF-8"));
            customer.setBalance(Double.parseDouble(request.getParameter("balance")));

            boolean success = dao.addCustomer(customer);
            if (success) {
                message = "<li>成功插入一条记录";
            } else {
                message = "<li>插入记录错误";
            }
        } catch (Exception e) {
            message = "<li>插入记录错误";
        }

        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/addCustomer.jsp");
        rd.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
