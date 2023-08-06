package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/trang-chu/")
public class TrangChuController {

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("view", "/WEB-INF/views/trang_chu/home.jsp");
        return "layout";
    }

    @GetMapping("thong-tin-tai-khoan")
    public String thongTin(Model model){
        model.addAttribute("view", "/WEB-INF/views/taikhoan.jsp");
        return "layout";
    }

}
