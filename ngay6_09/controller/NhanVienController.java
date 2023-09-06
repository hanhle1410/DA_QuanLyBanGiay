package com.example.controller;

import com.example.entity.NhanVien;
import com.example.entity.TaiKhoan;
import com.example.service.ChucVuService;
import com.example.service.NhanVienService;
import com.example.service.TaiKhoanService;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;


    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listsCV", chucVuService.getAll());
        model.addAttribute("lists", nhanVienService.getAll());
        model.addAttribute("view", "/WEB-INF/views/nhan_vien/index.jsp");
        return "layout";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("nv") NhanVien nhanVien){
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        nhanVienService.delete(UUID.fromString(id));
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        NhanVien nhanVien = nhanVienService.detail(UUID.fromString(id));
        model.addAttribute("listsCV", chucVuService.getAll());
        model.addAttribute("nv", nhanVien);
        model.addAttribute("lists", nhanVienService.getAll());
        model.addAttribute("view", "/WEB-INF/views/nhan_vien/index.jsp");
        return "layout";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id ,Model model){
        NhanVien nhanVien = nhanVienService.detail(UUID.fromString(id));
        model.addAttribute("lists", nhanVienService.getAll());
        model.addAttribute("listsCV", chucVuService.getAll());
        model.addAttribute("nv", nhanVien);
        model.addAttribute("view", "/WEB-INF/views/nhan_vien/update.jsp");
        return "layout";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("nv") NhanVien nhanVien){
        NhanVien findNhanVien = nhanVienService.getById(nhanVien.getId());
        BeanUtils.copyProperties(nhanVien, findNhanVien);
        nhanVienService.update(findNhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("clear")
    public String clearForm( Model model) {
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("view-updatetk/{id}")
    public String viewUpdatetk(@PathVariable("id") String id ,Model model){
//        NhanVien nhanVien = nhanVienService.detail(UUID.fromString(id));
//        TaiKhoan taiKhoan = taiKhoanService.detail(UUID.fromString(id));
//        model.addAttribute("lists", nhanVienService.getAll());
//        model.addAttribute("listsTK", taiKhoanService.getAll());
//        model.addAttribute("nv", nhanVien);
//        model.addAttribute("tk", taiKhoan);
//        model.addAttribute("view", "/WEB-INF/views/nhan_vien/taikhoan.jsp");
        return "layout";
    }
    @PostMapping("updatetk")
    public String updatetk(@ModelAttribute("nv") NhanVien nhanVien){
//        NhanVien findNhanVien = nhanVienService.getById(nhanVien.getId());
//        BeanUtils.copyProperties(nhanVien, findNhanVien);
//        nhanVienService.update(findNhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
}
