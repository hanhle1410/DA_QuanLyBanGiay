package com.example.controller.home;


import com.example.entity.TaiKhoan;
import com.example.service.impl.TKService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@WebServlet({
        "/loginForm",
        "/login"
})
public class LoginController  extends HttpServlet {

    @Autowired
    private TKService tkService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String viewLogin() {
        return "login/login";
    }

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        this.tkService = (TKService) context.getAttribute("userService");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        TaiKhoan user = tkService.authenticate(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/shopping-cart/views");
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
        }
    }

    @PostMapping("/loginForm")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        TaiKhoan user = tkService.authenticate(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/home";
        } else {
            return "redirect:/login?error=1";
        }
    }

}
