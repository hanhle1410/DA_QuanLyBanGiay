package com.example.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product/")
public class ProductController {

//    @Autowired
//    private SanPhamService sanPhamService;
//
//    @Autowired
//    private ChiTietSPService chiTietSPService;
//
//
//
//    @GetMapping("views")
//    public String danhSachSanPham(Model model) {
//        List<SanPham> sanPhamList = sanPhamService.layDanhSachSanPham();
//        model.addAttribute("sanPhamList", sanPhamList);
//        return "product/danh-sach-san-pham";
//    }
//
//    @GetMapping("views/{id}")
//    public String chiTietSanPham(@PathVariable("id") UUID id, Model model) {
//        SanPham sanPham = sanPhamService.laySanPham(id);
//        if (sanPham == null) {
//            return "404";
//        }
//        List<ChiTietSP> chiTietSPList = chiTietSPService.layDanhSachChiTietSP(id);
//        model.addAttribute("sanPham", sanPham);
//        model.addAttribute("chiTietSPList", chiTietSPList);
//        return "product/chi-tiet-san-pham";
//    }


}
