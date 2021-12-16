package main.java.com.igeek.servlet;

import com.google.gson.Gson;
import main.java.com.igeek.bean.User;
import main.java.com.igeek.ov.ResponseEntity;
import main.java.com.igeek.service.ScService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/power/removeCart.do")
public class RemoveCartAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScService scService = new ScService();
        resp.setCharacterEncoding("UTF-8");
        ResponseEntity responseEntity = null;
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        boolean b = scService.removeCart(loginUser);
        System.out.println(b);
        if (b){
            responseEntity = new ResponseEntity(100,null,"清空成功");
        }else {
            responseEntity = new ResponseEntity(103,null,"清空失败");
        }
        Gson gson = new Gson();
        String json = gson.toJson(responseEntity);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
