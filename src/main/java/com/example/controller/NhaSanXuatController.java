package com.example.controller;


import com.example.entity.NhaSX;
import com.example.service.NhaSanXuatService;
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
@RequestMapping("/nha-san-xuat/")
public class NhaSanXuatController {

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        model.addAttribute("view", "/WEB-INF/views/nha_san_xuat/index.jsp");
        return "layout";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        NhaSX nhaSX = nhaSanXuatService.detail(UUID.fromString(id));
        model.addAttribute("nsx", nhaSX);
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        model.addAttribute("view", "/WEB-INF/views/nha_san_xuat/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        nhaSanXuatService.delete(UUID.fromString(id));
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("nsx") NhaSX nhaSX){
        nhaSanXuatService.add(nhaSX);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model){
        NhaSX nhaSX = nhaSanXuatService.detail(UUID.fromString(id));
        model.addAttribute("nsx", nhaSX);
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        model.addAttribute("view", "/WEB-INF/views/nha_san_xuat/update.jsp");
        return "layout";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("nsx") NhaSX nhaSX){
        NhaSX findNhaSX1 = nhaSanXuatService.getById(nhaSX.getId());
        BeanUtils.copyProperties(nhaSX, findNhaSX1);
        nhaSanXuatService.update(findNhaSX1);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("clear")
    public String clearForm(Model model) {
        return "redirect:/nha-san-xuat/hien-thi";
    }
}
