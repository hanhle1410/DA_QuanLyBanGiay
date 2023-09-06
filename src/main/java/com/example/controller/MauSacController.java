package com.example.controller;


import com.example.entity.MauSP;
import com.example.service.MauSacService;
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
@RequestMapping("/mau-sac/")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listMS", mauSacService.getAll());
        model.addAttribute("view", "/WEB-INF/views/mau_sac/index.jsp");
        return "layout";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        MauSP mauSP = mauSacService.detail(UUID.fromString(id));
        model.addAttribute("ms", mauSP);
        model.addAttribute("listMS", mauSacService.getAll());
        model.addAttribute("view", "/WEB-INF/views/mau_sac/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        mauSacService.delete(UUID.fromString(id));
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("ms") MauSP mauSP){
        mauSacService.add(mauSP);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model){
        MauSP mauSP = mauSacService.detail(UUID.fromString(id));
        model.addAttribute("ms", mauSP);
        model.addAttribute("listMS", mauSacService.getAll());
        model.addAttribute("view", "/WEB-INF/views/mau_sac/update.jsp");
        return "layout";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("ms") MauSP mauSP){
        MauSP findMauSP1 = mauSacService.getById(mauSP.getId());
        BeanUtils.copyProperties(mauSP, findMauSP1);
        mauSacService.update(findMauSP1);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("clear")
    public String clearForm(Model model) {
        return "redirect:/mau-sac/hien-thi";
    }
}
