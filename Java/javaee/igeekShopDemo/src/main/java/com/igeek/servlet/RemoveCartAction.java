package main.java.com.igeek.servlet;

import main.java.com.igeek.bean.User;
import main.java.com.igeek.service.ScService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/removeCart.do")
public class RemoveCartAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScService scService = new ScService();
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        scService.removeCart(loginUser);
        resp.sendRedirect(req.getContextPath()+"/cart.do");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
