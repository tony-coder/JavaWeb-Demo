package dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class BaseDao {
    DataSource dataSource;

    //在构造方法中返回数据源对象
    public BaseDao() {
        try {
            Context context = new InitialContext();
            dataSource =
                    (DataSource) context.lookup("java:comp/env/jdbc/webstoreDS");
        } catch (NamingException e) {
            System.out.println("Exception: " + e);
        }
    }
    //返回一个连接对象
    public Connection getConnection()throws Exception {
        return dataSource.getConnection();
    }
}
