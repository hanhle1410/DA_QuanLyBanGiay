package com.example.controller.cart;

import com.example.entity.*;
import com.example.repository.*;
import com.example.service.impl.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/shopping-cart/")
public class GioHangCTController {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @Autowired
    private HoaDonCTRepository hoaDonCTRepository;
    @Autowired
    private GioHangCTService shoppingCartService;
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private VoucherRepository voucherRepository;
    @Autowired
    private GioHangRepository gioHangRepository;

    @GetMapping("views")
    public String viewProduct(@RequestParam(defaultValue = "0", name = "page") int number, Model model) {

        List<Voucher> vouchers = voucherRepository.findAll();
        Collections.sort(vouchers, Comparator.comparing(Voucher::getGiamGia));
        model.addAttribute("vouchers", vouchers);
        Pageable pageable = PageRequest.of(number, 4);
        Page<ChiTietSP> chiTietSPList = chiTietSPRepository.findAll(pageable);
        model.addAttribute("chiTietSPList", chiTietSPList);
        model.addAttribute("CART_ITEMS", shoppingCartService.getAllItems());
        model.addAttribute("TOTAL", shoppingCartService.getAmount());
        model.addAttribute("hoaDonList", hoaDonService.getallHoaDon());
        return "cart/cart-items";
    }

    @GetMapping("search")
    public String search(@RequestParam(defaultValue = "0", name = "page") int number,
                         @RequestParam("q") String keyword, Model model) {
        List<Voucher> vouchers = voucherRepository.findAll();
        Collections.sort(vouchers, Comparator.comparing(Voucher::getGiamGia));
        model.addAttribute("vouchers", vouchers);
        Pageable pageable = PageRequest.of(number, 4);
        Page<ChiTietSP> chiTietSPList = chiTietSPRepository.findAll(pageable);
        model.addAttribute("chiTietSPList", chiTietSPList);
        model.addAttribute("CART_ITEMS", shoppingCartService.getAllItems());
        model.addAttribute("TOTAL", shoppingCartService.getAmount());
        model.addAttribute("hoaDonList", hoaDonService.getallHoaDon());
        return "cart/cart-items";
    }


    @GetMapping("add/{id}")
    public String addCart(Model model, @PathVariable("id") UUID id, HttpSession session
    ) {

        ChiTietSP chiTietSP = chiTietSPService.layChiTietSP(id);
        if (chiTietSP != null) {
            GioHangCT item = new GioHangCT();
            item.setIdChiTietSP(chiTietSP);
            SanPham sanPham = chiTietSP.getIdSP();
            if (sanPham != null) {
                item.setDonGia(sanPham.getGiaBan());
                item.setSoLuong(1);
                chiTietSPService.addToCart(chiTietSP, item.getSoLuong());
                shoppingCartService.add(item);
            }
        }
        model.addAttribute("list_product", shoppingCartService);

        return "redirect:/shopping-cart/views";
    }


    @GetMapping("clear")
    public String clearCart() {
        shoppingCartService.clear();
        return "redirect:/shopping-cart/views";
    }


    @GetMapping("remove/{id}")
    public String deleteCart(
            Model model,
            @PathVariable("id") UUID id
    ) {
        shoppingCartService.remove(id);
        return "redirect:/shopping-cart/views";
    }


    @PostMapping("update/{id}")
    public String updateCart(
            Model model,
            @PathVariable("id") UUID id, @RequestParam("soLuong")Integer soLuong
    ) {

        shoppingCartService.update(id,soLuong);
        return "redirect:/shopping-cart/views";
    }

}
