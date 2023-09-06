package com.example.controller;

import com.example.entity.ChiTietSP;
import com.example.service.ChiTietSanPhamService;
import com.example.service.DeGiayService;
import com.example.service.DongSanPhamService;
import com.example.service.KichCoService;
import com.example.service.MauSacService;
import com.example.service.NhaSanXuatService;
import com.example.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping(value = "/chi-tiet-san-pham/")
public class ChiTietSanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private KichCoService kichCoService;

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @Autowired
    private DeGiayService deGiayService;

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listMS", mauSacService.getAll());
        model.addAttribute("listKC", kichCoService.getAll());
        model.addAttribute("listCTSP", chiTietSanPhamService.getAll());
        model.addAttribute("view", "/WEB-INF/views/chi_tiet_san_pham/index.jsp");
        return "layout";
    }

    @GetMapping("view-san-pham")
    public String viewSanPham(Model model){
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listDSP", dongSanPhamService.getAll());
        model.addAttribute("listDG", deGiayService.getAll());
        model.addAttribute("listNSX", nhaSanXuatService.getAll());
        model.addAttribute("view", "/WEB-INF/views/san_pham/index.jsp");
        return "layout";
    }

    @GetMapping("view-kich-co")
    public String viewKichCo(Model model){
        model.addAttribute("listKC", kichCoService.getAll());
        model.addAttribute("view", "/WEB-INF/views/kich_co/index.jsp");
        return "layout";
    }

    @GetMapping("view-mau-sac")
    public String viewMauSac(Model model){
        model.addAttribute("listMS", mauSacService.getAll());
        model.addAttribute("view", "/WEB-INF/views/mau_sac/index.jsp");
        return "layout";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        ChiTietSP chiTietSP = chiTietSanPhamService.detail(UUID.fromString(id));
        model.addAttribute("ctsp", chiTietSP);
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listMS", mauSacService.getAll());
        model.addAttribute("listKC", kichCoService.getAll());
        model.addAttribute("listCTSP", chiTietSanPhamService.getAll());
        model.addAttribute("view", "/WEB-INF/views/chi_tiet_san_pham/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        chiTietSanPhamService.delete(UUID.fromString(id));
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("ctsp") ChiTietSP chiTietSP, Model model, BindingResult bindingResult){
        chiTietSanPhamService.add(chiTietSP);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }


    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model){
        ChiTietSP chiTietSP = chiTietSanPhamService.getById(UUID.fromString(id));
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listMS", mauSacService.getAll());
        model.addAttribute("listKC", kichCoService.getAll());
        model.addAttribute("listCTSP", chiTietSanPhamService.getAll());
        model.addAttribute("ctsp", chiTietSP);
        model.addAttribute("view", "/WEB-INF/views/chi_tiet_san_pham/update.jsp");
        return "layout";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("ctsp") ChiTietSP chiTietSP){
        ChiTietSP findchiTietSP1 = chiTietSanPhamService.getById(chiTietSP.getId());
        BeanUtils.copyProperties(chiTietSP, findchiTietSP1);
        chiTietSanPhamService.update(chiTietSP);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("clear")
    public String clearForm( Model model) {
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

}
