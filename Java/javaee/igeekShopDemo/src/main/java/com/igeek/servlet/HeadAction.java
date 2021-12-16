package main.java.com.igeek.servlet;

import com.google.gson.Gson;
import main.java.com.igeek.bean.Category;
import main.java.com.igeek.ov.ResponseEntity;
import main.java.com.igeek.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/head.do")
public class HeadAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        CategoryService categoryService = new CategoryService();
        ResponseEntity responseEntity = null;
        List<Category> categoryList = categoryService.getCategoryList();
        if (categoryList.size()==0){
            responseEntity = new ResponseEntity(102,null,"获取失败");
        }else {
            responseEntity = new ResponseEntity(100,categoryList,"获取成功");
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
