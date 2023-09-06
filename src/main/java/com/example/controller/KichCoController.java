package com.example.controller;

import com.example.entity.KichCo;
import com.example.service.KichCoService;
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
@RequestMapping("/kich-co/")
public class KichCoController {

    @Autowired
    private KichCoService kichCoService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listKC", kichCoService.getAll());
        model.addAttribute("view", "/WEB-INF/views/kich_co/index.jsp");
        return "layout";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        KichCo kichCo = kichCoService.detail(UUID.fromString(id));
        model.addAttribute("kc", kichCo);
        model.addAttribute("listKC", kichCoService.getAll());
        model.addAttribute("view", "/WEB-INF/views/kich_co/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        kichCoService.delete(UUID.fromString(id));
        return "redirect:/kich-co/hien-thi";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("kc") KichCo kichCo){
        kichCoService.add(kichCo);
        return "redirect:/kich-co/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model){
        KichCo kichCo = kichCoService.detail(UUID.fromString(id));
        model.addAttribute("kc", kichCo);
        model.addAttribute("listKC", kichCoService.getAll());
        model.addAttribute("view", "/WEB-INF/views/kich_co/update.jsp");
        return "layout";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("kc") KichCo kichCo){
        KichCo findKichCo1 = kichCoService.getById(kichCo.getId());
        BeanUtils.copyProperties(kichCo, findKichCo1);
        kichCoService.update(findKichCo1);
        return "redirect:/kich-co/hien-thi";
    }

    @GetMapping("clear")
    public String clearForm(Model model) {
        return "redirect:/kich-co/hien-thi";
    }
}
