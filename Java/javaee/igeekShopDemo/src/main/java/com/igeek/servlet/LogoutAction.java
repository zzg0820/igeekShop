package main.java.com.igeek.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/power/logOut.do")
public class LogoutAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("autoLogin","false");
        cookie.setMaxAge(0);
        cookie.setPath(req.getContextPath());
        resp.addCookie(cookie);
        HttpSession session = req.getSession();
        session.invalidate();
        String base = req.getContextPath();
        /*StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);*/
        resp.sendRedirect(base+"/index.do");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
