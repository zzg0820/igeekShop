package main.java.com.igeek.servlet;

import com.google.gson.Gson;
import main.java.com.igeek.bean.Product;
import main.java.com.igeek.ov.PageEntity;
import main.java.com.igeek.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/page.do")
public class PageAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        resp.setCharacterEncoding("UTF-8");
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        String cId = req.getParameter("cId");
        int rows = 12;
        int totalRows = productService.getProNumByCid(cId);
        int totalPage = (int) Math.ceil((double) totalRows/12) ;
        List<Product> productList = productService.getProListByPage(cId,currentPage,rows);
//        System.out.println(productList);
        PageEntity pageEntity = new PageEntity(currentPage,rows,totalPage,totalRows,productList);
        Gson gson = new Gson();
        String json = gson.toJson(pageEntity);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
