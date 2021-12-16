package main.java.com.igeek.servlet;

import main.java.com.igeek.bean.Product;
import main.java.com.igeek.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/proInfo.do")
public class ProInfoAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        int pId = Integer.parseInt(req.getParameter("pid"));
        Product proById = productService.getProById(pId);
        req.setAttribute("proById",proById);
        req.getRequestDispatcher("/product_info.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
