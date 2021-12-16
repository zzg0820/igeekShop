package main.java.com.igeek.filter;

import main.java.com.igeek.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/power/*")
public class IsLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User loginUser = (User)session.getAttribute("loginUser");
        if (loginUser == null){
            req.setAttribute("loginError","您尚未登录，请先登录");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
