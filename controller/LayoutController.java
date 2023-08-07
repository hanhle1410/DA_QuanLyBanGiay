package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lay-out")
public class LayoutController {

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        return "layout";
    }

//    @PostMapping("add")
//    public String add(@ModelAttribute("nv") NhanVien nhanVien){
//        nhanVienService.add(nhanVien);
//        return "redirect:/nhan-vien/hien-thi";
//    }
//
//    @GetMapping("delete/{id}")
//    public String delete(@PathVariable("id") String id){
//        nhanVienService.delete(UUID.fromString(id));
//        return "redirect:/nhan-vien/hien-thi";
//    }
//
//    @GetMapping("detail/{id}")
//    public String detail(@PathVariable("id") String id, Model model){
//        NhanVien nhanVien = nhanVienService.detail(UUID.fromString(id));
//        model.addAttribute("listsCV", chucVuService.getAll());
//        model.addAttribute("nv", nhanVien);
//        model.addAttribute("lists", nhanVienService.getAll());
//        model.addAttribute("view", "/WEB-INF/views/nhan_vien/index.jsp");
//        return "layout";
//    }
//
//    @GetMapping("view-update/{id}")
//    public String viewUpdate(@PathVariable("id") String id ,Model model){
//        NhanVien nhanVien = nhanVienService.detail(UUID.fromString(id));
//        model.addAttribute("lists", nhanVienService.getAll());
//        model.addAttribute("listsCV", chucVuService.getAll());
//        model.addAttribute("nv", nhanVien);
//        model.addAttribute("view", "/WEB-INF/views/nhan_vien/update.jsp");
//        return "layout";
//    }
//
//    @PostMapping("update")
//    public String update(@ModelAttribute("nv") NhanVien nhanVien){
//        NhanVien findNhanVien = nhanVienService.getById(nhanVien.getId());
//        BeanUtils.copyProperties(nhanVien, findNhanVien);
//        nhanVienService.update(findNhanVien);
//        return "redirect:/nhan-vien/hien-thi";
//    }
//    @GetMapping("clear")
//    public String clearForm( Model model) {
//        return "redirect:/nhan-vien/hien-thi";
//    }
}
