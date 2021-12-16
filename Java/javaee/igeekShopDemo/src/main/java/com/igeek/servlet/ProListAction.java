package main.java.com.igeek.servlet;

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

@WebServlet("/proList.do")
public class ProListAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cId = req.getParameter("cId");
        ProductService productService = new ProductService();
        // 当前页码
        int currentPage = 1;
        // 一页多少数据
        int rows = 12;
        // 总共多少条
        int totalRows = productService.getProNumByCid(cId);
//        System.out.println(totalRows);
        // 一共多少页
        int totalPage = (int) Math.ceil((double) totalRows/12) ;
//        System.out.println(totalPage);
        // 数据
        List<Product> productList = productService.getProListByPage(cId,currentPage,rows);
//        System.out.println(productList);
        PageEntity pageEntity = new PageEntity(currentPage,rows,totalPage,totalRows,productList);
        req.setAttribute("pageEntity",pageEntity);
        req.setAttribute("cId",cId);
        req.getRequestDispatcher("/product_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
