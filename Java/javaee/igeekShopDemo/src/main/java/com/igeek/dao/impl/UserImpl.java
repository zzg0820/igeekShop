package main.java.com.igeek.dao.impl;

import main.java.com.igeek.bean.User;
import main.java.com.igeek.dao.iface.UserIface;
import main.java.com.igeek.dao.util.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserImpl implements UserIface {
    @Override
    public User findUserByUsername(String username) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from user where username = ?";
        return runner.query(sql,new BeanHandler<>(User.class),username);
    }

    @Override
    public User findUserByEmail(String email) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from user where email = ?";
        return runner.query(sql,new BeanHandler<>(User.class),email);
    }

    @Override
    public User getUser(String username, String password) throws SQLException{
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "select * from user where username = ? and password = ?";
        return runner.query(sql,new BeanHandler<>(User.class),username,password);
    }

    @Override
    public int regUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        return runner.update(sql,user.getUid(),user.getUserName(),user.getPassword(),user.getName(),
                user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),
                user.getCode());
    }
}
