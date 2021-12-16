package main.java.com.igeek.dao.util;



import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoUtil {
    // 使用连接池获取DataSource
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 返回DataSource
    public static ComboPooledDataSource getDataSource(){
        return dataSource;
    }

    // 获取链接对象
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
