package com.example.controller;


import com.example.entity.DongSP;
import com.example.service.DongSanPhamService;
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
@RequestMapping("/dong-san-pham/")
public class DongSanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("view", "/WEB-INF/views/dong_san_pham/index.jsp");
        return "layout";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        DongSP dongSP = dongSanPhamService.detail(UUID.fromString(id));
        model.addAttribute("dsp", dongSP);
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("view", "/WEB-INF/views/dong_san_pham/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        dongSanPhamService.delete(UUID.fromString(id));
        return "redirect:/dong-san-pham/hien-thi";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("dsp") DongSP dongSP){
        dongSanPhamService.add(dongSP);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model){
        DongSP dongSP = dongSanPhamService.detail(UUID.fromString(id));
        model.addAttribute("dsp", dongSP);
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("view", "/WEB-INF/views/dong_san_pham/update.jsp");
        return "layout";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("dsp") DongSP dongSP){
        DongSP findDongSP = dongSanPhamService.getById(dongSP.getId());
        BeanUtils.copyProperties(dongSP, findDongSP);
        dongSanPhamService.update(findDongSP);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("clear")
    public String clearForm(Model model) {
        return "redirect:/dong-san-pham/hien-thi";
    }
}
