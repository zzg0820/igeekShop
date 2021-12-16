package main.java.com.igeek.servlet;

import main.java.com.igeek.bean.Product;
import main.java.com.igeek.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index.do")
public class WelcomeAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        req.setCharacterEncoding("UTF-8");
        List<Product> hotPro = productService.getHotPro();
        List<Product> newPro = productService.getNewPro();
        req.setAttribute("hotProList",hotPro);
        req.setAttribute("newProList",newPro);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
