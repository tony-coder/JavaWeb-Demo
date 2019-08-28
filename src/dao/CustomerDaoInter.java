package dao;

import com.demo.Customer;

import java.util.ArrayList;

public interface CustomerDaoInter  extends Dao{
    //添加客户方法
    public boolean addCustomer(Customer customer) throws DaoException;

    //按id查询客户的方法
    public Customer findById(String id) throws DaoException;

    //查询所有客户的方法
    public ArrayList<Customer> findAllCustomer() throws DaoException;
}
