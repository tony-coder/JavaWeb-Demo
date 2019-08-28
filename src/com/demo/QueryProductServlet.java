package com.demo;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@WebServlet("/queryproduct.do")
public class QueryProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection dbconn = null;
    DataSource dataSource;  //声明一个数据源变量

    /*@Override
    public void init() throws ServletException {
        super.init();
        //数据库地址
        String dburl = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT";
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "Bfx1997@_";

//        //jdbc驱动
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String dburl = "jdbc:mysql://localhost:3306/test?user=root&password=Bfx1997@_";
        try {
            Class.forName(driver); //加载驱动程序
            //创建连接对象
            dbconn = DriverManager.getConnection(dburl, username, password);

            System.out.println("数据库连接成功");

        } catch (ClassNotFoundException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
            getServletContext().log("驱动程序类找不到!");
        } catch (SQLException e2) {
            System.out.println("数据库连接失败");
            e2.printStackTrace();
        }
    }*/

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            //Context接口提供了将名字和对象绑定，通过名字检索对象的方法，可通过该接口的一个实现类InitialContext获取上下文对象
            Context context = new InitialContext();
            //查找数据源
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/webstoreDS");
            //通过数据源返回连接对象
            dbconn = dataSource.getConnection();
            System.out.println("数据库连接成功");
        } catch (NamingException | SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }

    //1.PreparedStatement是预编译的,对于批量处理可以大大提高效率.也叫JDBC存储过程
    //2.使用 Statement 对象。在对数据库只执行一次性存取的时侯，用 Statement 对象进行处理。PreparedStatement对象的开销比Statement大，对于一次性操作并不会带来额外的好处。
    //3.statement每次执行sql语句，相关数据库都要执行sql语句的编译，preparedstatement是预编译得,preparedstatement支持批处理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productid = request.getParameter("productid");
        try {
            String sql = "SELECT * FROM products WHERE prod_id = ?";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);  // 预处理语句
            pstmt.setString(1, productid);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                Product product = new Product();
                product.setProd_id(rst.getString("prod_id"));
                product.setPname(rst.getString("pname"));
                product.setPrice(rst.getDouble("price"));
                product.setStock(rst.getInt("stock"));
                request.getSession().setAttribute("product", product);
                response.sendRedirect("/helloweb/jsp/displyProduct.jsp");

            } else {
                response.sendRedirect("/helloweb/error/notFoundError.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> productList = null;
        productList = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM products";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Product product = new Product();
                product.setProd_id(rst.getString("prod_id"));
                product.setPname(rst.getString("pname"));
                product.setPrice(rst.getDouble("price"));
                product.setStock(rst.getInt("stock"));
                productList.add(product);

            }
            if (!productList.isEmpty()) {
                request.getSession().setAttribute("productList", productList);
                response.sendRedirect("/helloweb/jsp/displayAllProduct.jsp");
            } else {
                response.sendRedirect("/helloweb/error/notFoundError.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            dbconn.close();
            System.out.println("数据库断开");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
