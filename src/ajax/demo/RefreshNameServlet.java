package ajax.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RefreshNameServlet",urlPatterns = {"/refreshNameList.do"})
public class RefreshNameServlet extends HttpServlet {
    private class Student {
        private int year;
        private String sclass;
        private String name;

        public Student(int year, String sclass, String name) {
            this.year = year;
            this.sclass = sclass;
            this.name = name;
        }
    }

    private List<Student> students = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        students.add(new Student(2018, "class1", "李小明"));
        students.add(new Student(2018, "class1", "张冬玫"));
        students.add(new Student(2018, "class2", "赵亮"));
        students.add(new Student(2018, "class2", "王强"));
        students.add(new Student(2018, "class2", "孙文"));
        students.add(new Student(2019, "class1", "Micheal Jordon"));
        students.add(new Student(2019, "class1", "Henry Smith"));
        students.add(new Student(2019, "class2", "Joeory Bush"));
        students.add(new Student(2019, "class2", "Karta"));
        students.add(new Student(2019, "class2", "Luews"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int syaer = Integer.parseInt(request.getParameter("syear"));
        String sclass = request.getParameter("sclass");
        StringBuilder results = new StringBuilder();
        results.append("<snames>");
        for (Student stu : students) {
            if (syaer == stu.year && sclass.equals(stu.sclass)) {
                results.append("<sname>");
                results.append(stu.name);
                results.append("</sname>");
            }
        }
        results.append("</snames>");
        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().println(results.toString());

    }
}
