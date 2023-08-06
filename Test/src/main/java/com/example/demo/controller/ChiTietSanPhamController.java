package com.example.demo.controller;

import com.example.demo.entity.ChiTietSP;
import com.example.demo.entity.KichCo;
import com.example.demo.entity.MauSP;
import com.example.demo.entity.SanPham;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.KichCoService;
import com.example.demo.service.MauSacService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number,
                          Model model){
        Pageable pageable = PageRequest.of(number, 4);
        Page<ChiTietSP> chiTietSPPage = chiTietSanPhamService.getAll(pageable);
        model.addAttribute("listCTSP", chiTietSPPage);
//        model.addAttribute("listSP", sanPhamService.getAll());
//        model.addAttribute("listMS", mauSacService.getAll());
//        model.addAttribute("listKC", kichCoService.getAll());
        model.addAttribute("listCTSP", chiTietSanPhamService.getAll());
        model.addAttribute("view", "/WEB-INF/views/chi_tiet_san_pham/index.jsp");
        return "layout";
    }

    @GetMapping("view-san-pham")
    public String viewSanPham(Model model){
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("view", "/WEB-INF/views/san_pham/index.jsp");
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
    public String add(@ModelAttribute("ctsp") ChiTietSP chiTietSP){
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
    public String update(@RequestParam("id") String id,
                         @RequestParam("idSP") String idSP,
                         @RequestParam("idMauSP") String idMauSP,
                         @RequestParam("idKichCo") String idKichCo,
                         @RequestParam("soLuong") String soLuong){
        SanPham sanPhamm = sanPhamService.getById(UUID.fromString(idSP));
        MauSP mauSP = mauSacService.getById(UUID.fromString(idMauSP));
        KichCo kichCo = kichCoService.getById(UUID.fromString(idKichCo));
        ChiTietSP chiTietSP = ChiTietSP.builder()
                .idSP(sanPhamm)
                .idMauSP(mauSP)
                .idKichCo(kichCo)
                .soLuong(Integer.valueOf(soLuong))
                .build();
        ChiTietSP chiTietSP1 = chiTietSanPhamService.getById(UUID.fromString(id));
        chiTietSP.setId(chiTietSP1.getId());
        BeanUtils.copyProperties(chiTietSP, chiTietSP1);
        chiTietSanPhamService.update(chiTietSP);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("clear")
    public String clearForm( Model model) {
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

}
