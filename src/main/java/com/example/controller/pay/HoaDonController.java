package com.example.controller.pay;

import com.example.entity.GioHangCT;
import com.example.repository.GioHangRepository;
import com.example.service.impl.GioHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HoaDonController {

    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private GioHangRepository gioHangRepository;

//    @PostMapping("/gio-hang/thanh-toan")
//    public String thanhToan(Model model, HttpSession session) {
//        // Lấy đối tượng GioHang từ phiên của người dùng hoặc cơ sở dữ liệu
//        GioHangCT gioHang = (GioHangCT) this.gioHangRepository.findAll();
//        if (gioHang == null) {
//            return "redirect:/shopping-cart/views";
//        }
//
//        // Thực hiện việc thanh toán
//        gioHangService.thanhToan(gioHang.getIdGioHang());
//
//        // Xóa đối tượng GioHang ra khỏi phiên của người dùng
//        session.removeAttribute("gioHang");
//
//        // Thêm thông báo vào Model để hiển thị trên trang thanh toán thành công
//        model.addAttribute("message", "Đơn hàng của bạn đã được đặt thành công!");
//
//        // Trả về tên trang thanh toán thành công
//        return "thanh-toan-thanh-cong";
//    }

}