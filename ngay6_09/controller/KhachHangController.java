package com.example.controller;

import com.example.entity.KhachHang;
import com.example.service.KhachHangService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;



    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("lists", khachHangService.getAll());
        model.addAttribute("view", "/WEB-INF/views/khach_hang/index.jsp");
        return "layout";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("kh") KhachHang khachHang){
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        khachHangService.delete(UUID.fromString(id));
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        KhachHang khachHang = khachHangService.detail(UUID.fromString(id));
        model.addAttribute("kh", khachHang);
        model.addAttribute("lists", khachHangService.getAll());
        model.addAttribute("view", "/WEB-INF/views/khach_hang/index.jsp");
        return "layout";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id ,Model model){
        KhachHang khachHang = khachHangService.getById(UUID.fromString(id));
        model.addAttribute("lists", khachHangService.getAll());
        model.addAttribute("kh", khachHang);
        model.addAttribute("view", "/WEB-INF/views/khach_hang/update.jsp");
        return "layout";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("kh") KhachHang khachHang){
        KhachHang findKhachHang = khachHangService.getById(khachHang.getId());
        BeanUtils.copyProperties(khachHang, findKhachHang);
        khachHangService.update(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("clear")
    public String clearForm( Model model) {
        return "redirect:/khach-hang/hien-thi";
    }
}
