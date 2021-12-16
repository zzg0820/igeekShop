package main.java.com.igeek.dao.iface;

import main.java.com.igeek.bean.User;

import java.sql.SQLException;

public interface UserIface{
    // 根据用户名查询是否存在用户
    public User findUserByUsername(String username) throws SQLException;

    // 根据邮箱查询是否存在用户
    public User findUserByEmail(String email) throws SQLException;

    // 根据用户名密码返回用户
    public User getUser(String username, String password) throws SQLException;

    // 注册用户
    public int regUser(User user) throws SQLException;
}
