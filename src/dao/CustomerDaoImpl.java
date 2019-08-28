package dao;

import com.demo.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDaoInter {
    @Override
    public boolean addCustomer(Customer customer) throws DaoException {
        String sql = "INSERT INTO customers VALUES(?,?,?,?)";
        try (Connection conn = getConnection();
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

    @Override
    public Customer findById(String id) throws DaoException {
        String sql = "SELECT id,name,eamil,balance FROM customers WHERE id=?";

        Customer customer = new Customer();
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
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

    @Override
    public ArrayList<Customer> findAllCustomer() throws DaoException {
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
