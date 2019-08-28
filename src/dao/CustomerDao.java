package dao;

import com.demo.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao extends BaseDao {
    //插入一条客户记录
    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customers VALUES(?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstms = conn.prepareStatement(sql)) {
            pstms.setString(1, customer.getId());
            pstms.setString(2, customer.getCustName());
            pstms.setString(3, customer.getEmail());
            pstms.setDouble(4, customer.getBalance());
            pstms.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //按姓名检索客户记录
    public Customer findByName(String cname) {
        String sql = "SELECT id,name,eamil,balance FROM customers WHERE name=?";

        Customer customer = new Customer();
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cname);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    customer.setId(rst.getString("id"));
                    customer.setCustName(rst.getString("name"));
                    customer.setEmail(rst.getString("email"));
                    customer.setBalance(rst.getDouble("balance"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return customer;
    }

    //查询所有客户的信息
    public ArrayList<Customer> findAllCustomer() {
        Customer customer = new Customer();
        ArrayList<Customer> custList = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                customer.setId(rst.getString("id"));
                customer.setCustName(rst.getString("name"));
                customer.setEmail(rst.getString("email"));
                customer.setBalance(rst.getDouble("balance"));
                custList.add(customer);
            }
            return custList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
