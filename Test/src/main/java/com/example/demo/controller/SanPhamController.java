package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.service.DeGiayService;
import com.example.demo.service.DongSanPhamService;
import com.example.demo.service.NhaSanXuatService;
import com.example.demo.service.SanPhamService;
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
@RequestMapping("/san-pham/")
public class SanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @Autowired
    private DeGiayService deGiayService;

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        model.addAttribute("view", "/WEB-INF/views/san_pham/index.jsp");
        return "layout";
//        return "san_pham/index";
    }

    @GetMapping("view-dong-sp")
    public String viewDongSp(Model model){
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("view", "/WEB-INF/views/san_pham/dong_san_pham/index.jsp");
        return "layout";
//        return "san_pham/dong_san_pham/index";
    }

    @GetMapping("view-de-giay")
    public String viewDeGiay(Model model){
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("view", "/WEB-INF/views/san_pham/de_giay/index.jsp");
        return "layout";
//        return "san_pham/de_giay/index";
    }

    @GetMapping("view-nha-san-xuat")
    public String viewNhaSanXuat(Model model){
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        model.addAttribute("view", "/WEB-INF/views/san_pham/nha_san_xuat/index.jsp");
        return "layout";
//        return "san_pham/nha_san_xuat/index";
    }

    @GetMapping("quay-lai")
    public String QuayLai(Model model){
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        SanPham sp = sanPhamService.detail(UUID.fromString(id));
        model.addAttribute("sp", sp);
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        model.addAttribute("view", "/WEB-INF/views/san_pham/index.jsp");
        return "layout";
//        return "san_pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        sanPhamService.delete(UUID.fromString(id));
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("sp") SanPham sanPham){
        sanPhamService.add(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model){
        SanPham sp = sanPhamService.detail(UUID.fromString(id));
        model.addAttribute("sp", sp);
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        model.addAttribute("view", "/WEB-INF/views/san_pham/update.jsp");
        return "layout";
//        return "san_pham/index";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("sp") SanPham sanPham){
        SanPham findSanPham = sanPhamService.getById(sanPham.getId());
        BeanUtils.copyProperties(sanPham, findSanPham);
        sanPhamService.update(findSanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("clear")
    public String clearForm( Model model) {
        return "redirect:/san-pham/hien-thi";
    }
}
