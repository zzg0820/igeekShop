package main.java.com.igeek.service;

import main.java.com.igeek.bean.User;
import main.java.com.igeek.dao.impl.UserImpl;

import java.sql.SQLException;

public class UserService {
    UserImpl userImpl = new UserImpl();
    // 通过姓名检查是否注册
    public boolean isLogin(String username){
        User user = null;
        try {
            user = userImpl.findUserByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user == null;
    }

    // 通过邮箱检查是否注册
    public boolean isLoginByEmail(String email){
        User user = null;
        try {
            user = userImpl.findUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user == null;
    }

    // 检查用户名密码是否正确
    public User checkLogin(String username, String password){
        try {
            return userImpl.getUser(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 注册用户
    public Boolean regUser(User user){
        try {
            int i = userImpl.regUser(user);
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 通过姓名返回用户id
    public User getUserByName(String userName){
        User user = null;
        try {
            user = userImpl.findUserByUsername(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
