package com.shivam.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Login_Filter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest)servletRequest;

        HttpServletResponse response=(HttpServletResponse) servletResponse;

        String path = ((HttpServletRequest) request).getRequestURI();

        if (request.getSession().getAttribute("name")!=null  || path.startsWith("/signup")){
            filterChain.doFilter(servletRequest,servletResponse);

        }else{
            request.getRequestDispatcher("/login").forward(servletRequest,servletResponse);
        }


    }

    public void destroy() {

    }
}
