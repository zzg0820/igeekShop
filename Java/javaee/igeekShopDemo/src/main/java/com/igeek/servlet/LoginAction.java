package main.java.com.igeek.servlet;

import main.java.com.igeek.bean.User;
import main.java.com.igeek.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remUserName = request.getParameter("remUserName");
        System.out.println(remUserName);
        String autoLogin = request.getParameter("autoLogin");
        if (userService.isLogin(username)){
            request.setAttribute("loginError","该用户尚未注册");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            User user = userService.checkLogin(username, password);
            if (user == null){
                request.setAttribute("loginError","用户名或密码不正确");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                if (remUserName != null){
                    if(remUserName.equals("on")){
                        Cookie cookie = new Cookie("username",user.getUserName());
                        Cookie cookie1 = new Cookie("remUserName","on");
                        cookie.setPath(request.getContextPath());
                        cookie1.setPath(request.getContextPath());
                        cookie.setMaxAge(7*24*3600);
                        cookie1.setMaxAge(7*24*3600);
                        response.addCookie(cookie);
                        response.addCookie(cookie1);
                    }
                }else {
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null){
                        for (Cookie cookie:cookies){
                            if (cookie.getName().equals("username")){
                                cookie.setMaxAge(0);
                                response.addCookie(cookie);
                            }
                            if (cookie.getName().equals("remUserName")){
                                cookie.setMaxAge(0);
                                response.addCookie(cookie);
                            }
                        }
                    }
                }
                request.setAttribute("loginError","");
                session.setAttribute("loginUser",user);
                request.getRequestDispatcher("/").forward(request,response);
            }
        }
    }
}
