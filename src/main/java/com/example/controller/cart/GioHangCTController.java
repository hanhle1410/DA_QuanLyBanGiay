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
    private ChiTietSPRepository chiTietSPRepository;
    @Autowired
    private GioHangCTService shoppingCartService;
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private VoucherRepository voucherRepository;
    @Autowired
    private GioHangCTService gioHangCTService;

    @GetMapping("views")
    public String viewProduct(@RequestParam(defaultValue = "0", name = "page") int number, Model model) {

        Pageable pageable = PageRequest.of(number, 4);

        List<Voucher> vouchers = voucherRepository.findAll();
        Collections.sort(vouchers, Comparator.comparing(Voucher::getGiamGia));
        model.addAttribute("vouchers", vouchers);

        model.addAttribute("CART_ITEMS", gioHangCTService.getAllItems());
        model.addAttribute("TOTAL", gioHangCTService.getAmount());

        List<HoaDon> hoaDons = hoaDonService.getAllHoaDonByNgayTaoAndTrangThai();
        model.addAttribute("hoaDonList", hoaDons);
        Collections.sort(hoaDons, Comparator.comparing(HoaDon::getMa).reversed());

        Page<ChiTietSP> chiTietSPList = chiTietSPRepository.findAll(pageable);
        model.addAttribute("chiTietSPList", chiTietSPList);

        return "cart/cart-items";
    }

    @GetMapping("search")
    public String search(@RequestParam(defaultValue = "0", name = "page") int number,
                         @RequestParam("q") String keyword, Model model) {
        Pageable pageable = PageRequest.of(number, 4);

        List<Voucher> vouchers = voucherRepository.findAll();
        Collections.sort(vouchers, Comparator.comparing(Voucher::getGiamGia));
        model.addAttribute("vouchers", vouchers);

        model.addAttribute("CART_ITEMS", gioHangCTService.getAllItems());
        model.addAttribute("TOTAL", gioHangCTService.getAmount());

        List<HoaDon> hoaDons = hoaDonService.getAllHoaDonByNgayTaoAndTrangThai();
        model.addAttribute("hoaDonList", hoaDons);
        Collections.sort(hoaDons, Comparator.comparing(HoaDon::getMa).reversed());

        Page<ChiTietSP> chiTietSPList = chiTietSPRepository.findAll(pageable);
        model.addAttribute("chiTietSPList", chiTietSPList);

        return "cart/cart-items";
    }


    @GetMapping("add/{id}")
    public String addCart(Model model, @PathVariable("id") UUID id) {
        ChiTietSP chiTietSP = chiTietSPService.layChiTietSP(id);
        if (chiTietSP != null) {
            GioHangCT item = new GioHangCT();
            item.setIdChiTietSP(chiTietSP);
            item.setDonGia(chiTietSP.getIdSP().getGiaBan());
            item.setSoLuong(1);
            gioHangCTService.add(item);
        }
        model.addAttribute("list_product", gioHangCTService.getAllItems());
        return "redirect:/shopping-cart/views";
    }
    @GetMapping("remove/{id}")
    public String removeCartItem(@PathVariable("id") UUID id) {
        // Xóa dữ liệu từ cơ sở dữ liệu và maps
        gioHangCTService.remove(id);
        return "redirect:/shopping-cart/views";
    }
    @GetMapping("clear")
    public String clearCart() {

        gioHangCTService.clear();
        return "redirect:/shopping-cart/views";
    }
    @PostMapping("update/{id}")
    public String updateCart(
            Model model,
            @PathVariable("id") UUID id, @RequestParam("soLuong")Integer soLuong
    ) {
        gioHangCTService.update(id,soLuong);
        return "redirect:/shopping-cart/views";
    }

}
