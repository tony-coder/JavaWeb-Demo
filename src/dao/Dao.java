package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public interface Dao {
    //查找并返回数据源对象
    //静态方法
    public static DataSource getDataSource() {
        DataSource dataSource=null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/webstoreDS");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    //返回连接对象方法
    //默认方法
    public default Connection getConnection() throws DaoException {
        DataSource dataSource = getDataSource();
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
