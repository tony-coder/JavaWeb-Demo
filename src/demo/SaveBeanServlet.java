package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.ObjectOutputStream;

import com.demo.Customer;

@WebServlet("/savebean.do")
public class SaveBeanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        try {
            Customer customer = new Customer();
            customer.setCustName(request.getParameter("custName"));
            customer.setEmail(request.getParameter("email"));
            customer.setPhone(request.getParameter("phone"));

            //得到用户名建立文件路径
            String name = request.getParameter("custName");
            String relativePath = "/WEB-INF/classes/customerDate/";
            String realPath = getServletContext().getRealPath(relativePath);

            File myPath = new File(realPath);
            if (!myPath.exists()) {
                myPath.mkdir();
            }
            realPath = realPath + name + ".ser";
            //将对象序列化到文件
            FileOutputStream fos = new FileOutputStream(realPath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customer);
            oos.close();
            message = "Successfully saved the bean as <br>" + realPath;
            request.setAttribute("msg", message);
        } catch (Exception e) {
            message = "An Exception occured.<br>" + e;
            request.setAttribute("msg", message);
        }
        getServletContext().getRequestDispatcher("/customer.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
