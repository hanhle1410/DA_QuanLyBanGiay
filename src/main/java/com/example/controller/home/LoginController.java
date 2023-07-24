package com.example.controller.home;


import com.example.entity.TaiKhoan;
import com.example.service.impl.TKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private TKService tkService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String viewLogin() {
        return "login/login";
    }

    @RequestMapping(value = "/loginForm",method = RequestMethod.POST)
    public String getTaiKhoanByUsernameAndPassword(
            @RequestParam("username") String username,
            @RequestParam("password") String password, Model model
    ) {
        TaiKhoan taiKhoan = tkService.findByUsernameAndPassword(username, password);
        if (taiKhoan == null) {
            return "redirect:/login";
        }
        return "redirect:/shopping-cart/views";
    }

}
