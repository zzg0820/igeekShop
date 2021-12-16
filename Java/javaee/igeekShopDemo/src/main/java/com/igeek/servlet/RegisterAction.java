package main.java.com.igeek.servlet;

import main.java.com.igeek.bean.User;
import main.java.com.igeek.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/register.do")
public class RegisterAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        User user = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
            String userName = BeanUtils.getProperty(user, "userName");
            if (!userService.isLogin(userName)){
                request.setAttribute("regErrMsg","用户名已被注册");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }else {
                String email = BeanUtils.getProperty(user, "email");
                if (!userService.isLoginByEmail(email)){
                    request.setAttribute("regErrMsg","邮箱已被注册");
                    request.getRequestDispatcher("/register.jsp").forward(request,response);
                }else {
                    String sex = BeanUtils.getProperty(user, "sex");
                    if (sex.equals("option1")) {
                        BeanUtils.setProperty(user, "sex", "男");
                    } else {
                        BeanUtils.setProperty(user, "sex", "女");
                    }
                    if (!userService.regUser(user)) {
                        request.setAttribute("regErrMsg", "注册失败");
                        request.getRequestDispatcher("/register.jsp").forward(request, response);
                    } else {
                        String bean = request.getContextPath();
                        response.sendRedirect(bean + "/login.jsp");
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
