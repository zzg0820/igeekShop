package main.java.com.igeek.servlet;

import com.google.gson.Gson;
import main.java.com.igeek.ov.ResponseEntity;
import main.java.com.igeek.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUsername.do")
public class CheckUsernameAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        ResponseEntity responseEntity = null;
        String userName = req.getParameter("userName");
        boolean login = userService.isLogin(userName);
        if (login){
            responseEntity = new ResponseEntity(100,null,"获取成功");
        }else {
            responseEntity = new ResponseEntity(103,null,"该用户名已被注册");
        }
        Gson gson = new Gson();
        String json = gson.toJson(responseEntity);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
