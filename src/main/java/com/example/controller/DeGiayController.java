package com.example.controller;


import com.example.entity.DeGiay;
import com.example.service.DeGiayService;
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
@RequestMapping("/de-giay/")
public class DeGiayController {

    @Autowired
    private DeGiayService deGiayService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("view", "/WEB-INF/views/de_giay/index.jsp");
        return "layout";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        DeGiay deGiay = deGiayService.detail(UUID.fromString(id));
        model.addAttribute("dg", deGiay);
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("view", "/WEB-INF/views/de_giay/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        deGiayService.delete(UUID.fromString(id));
        return "redirect:/de-giay/hien-thi";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("dg") DeGiay deGiay){
        deGiayService.add(deGiay);
        return "redirect:/de-giay/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model){
        DeGiay deGiay = deGiayService.detail(UUID.fromString(id));
        model.addAttribute("dg", deGiay);
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("view", "/WEB-INF/views/de_giay/update.jsp");
        return "layout";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("dg") DeGiay deGiay){
        DeGiay findDeGiay1 = deGiayService.getById(deGiay.getId());
        BeanUtils.copyProperties(deGiay, findDeGiay1);
        deGiayService.update(findDeGiay1);
        return "redirect:/de-giay/hien-thi";
    }

    @GetMapping("clear")
    public String clearForm(Model model) {
        return "redirect:/de-giay/hien-thi";
    }
}
