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

@WebServlet("/addCart.do")
public class AddCartAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScService scService = new ScService();
        HttpSession session = req.getSession();
        // 获取pid
        int pid = Integer.parseInt(req.getParameter("pid"));
        // 根据session获取用户
        User user =(User)session.getAttribute("loginUser");
//        System.out.println(user);
        // 判断有没有用户
        if (user == null){
            req.setAttribute("noUser","您尚未登录，请先登录");
            req.getRequestDispatcher("/proInfo.do?pid="+pid).forward(req,resp);
        }else {
            // 获取数量
            int num = Integer.parseInt(req.getParameter("num"));
            boolean b = scService.addShopCart(pid, num, user);
            if (b){
                /*List<ScWithItem> scList = scService.getScList(user);
                System.out.println(scList);*/
//                session.setAttribute("scList",scList);
                req.setAttribute("addSucces","添加成功");
                req.getRequestDispatcher("/proInfo.do?pid="+pid).forward(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
