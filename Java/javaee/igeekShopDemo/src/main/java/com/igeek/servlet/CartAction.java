package main.java.com.igeek.servlet;

import main.java.com.igeek.bean.ShoppingCart;
import main.java.com.igeek.bean.User;
import main.java.com.igeek.service.ScService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cart.do")
public class CartAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScService scService = new ScService();
        HttpSession session = req.getSession();
        User loginUser = (User)session.getAttribute("loginUser");
        if (loginUser == null){
            resp.sendRedirect("/igeekShop/cart.jsp");
        }else {
            ShoppingCart shoppingCart = scService.getScList(loginUser);
            req.setAttribute("shoppingCart",shoppingCart);
            req.getRequestDispatcher("/cart.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
