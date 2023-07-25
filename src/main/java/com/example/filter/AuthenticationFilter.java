package com.example.filter;

import com.example.service.impl.TKService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationFilter implements Filter {

    private TKService tkService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        this.tkService = (TKService) context.getAttribute("tkService");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = session != null && session.getAttribute("user") != null;
        String loginURI = httpRequest.getContextPath() + "/login";

        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // If user is already logged in and is trying to access the login page, redirect to the home page
            httpRequest.getRequestDispatcher("/shopping-cart/views").forward(request, response);
        } else if (isLoggedIn || isLoginRequest || isLoginPage) {
            // If user is already logged in or is trying to access the login page, continue with the request
            chain.doFilter(request, response);
        } else {
            // Otherwise, redirect to the login page
            httpRequest.getRequestDispatcher("WEB-INF/views/login/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        // Do nothing
    }
}