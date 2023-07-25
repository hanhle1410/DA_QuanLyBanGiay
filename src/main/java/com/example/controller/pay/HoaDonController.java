package com.example.controller.pay;

import com.example.entity.*;
import com.example.repository.TaiKhoanRepository;
import com.example.service.impl.HoaDonService;
import com.example.service.impl.KhachHangService;
import com.example.service.impl.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/pay/")
public class HoaDonController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private KhachHangService khachHangService;


    @Transactional(rollbackFor = Exception.class)
    @PostMapping("luu")
    public String createOrUpdateHoaDon(
            @RequestParam("ten") String ten,
            @RequestParam("sdt") String sdt,
            HttpSession session
    ) {
        try {
            // Lấy thông tin người dùng đang đăng nhập từ session
            TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("user");
            if (taiKhoan == null) {
                // Nếu không tìm thấy thông tin người dùng, chuyển hướng đến trang đăng nhập
                return "redirect:/login";
            }
            // Lấy thông tin nhân viên tương ứng với người dùng đang đăng nhập
            NhanVien nhanVien = taiKhoan.getIdNV();
            if (nhanVien == null) {
                // Nếu không tìm thấy thông tin nhân viên, chuyển hướng đến trang lỗi
                return "redirect:/error";
            }


            // Tìm kiếm thông tin khách hàng dựa trên số điện thoại
            KhachHang khachHang = this.khachHangService.findBySdt(sdt);
            // Nếu khách hàng không tồn tại, tạo mới khách hàng
            if (khachHang == null) {
                khachHang = new KhachHang();
                String ma = UUID.randomUUID().toString();
                khachHang.setMa(ma);
                khachHang.setTen(ten);
                khachHang.setSdt(sdt);
                this.khachHangService.addKH(khachHang);
            }
            // Lưu khách hàng vào cơ sở dữ liệu

            HoaDon hoaDon = new HoaDon();
            String ma = UUID.randomUUID().toString();
            hoaDon.setMa(ma);
            hoaDon.setIdKH(khachHang);
            hoaDon.setIdNV(nhanVien); // Thêm thông tin nhân viên vào hóa đơn
            hoaDon.setNgayTao(LocalDate.now());
            hoaDon.setNgayThanhToan(LocalDate.now());
            hoaDon.setTrangThai(1); // Đánh dấu hóa đơn đã được thanh toán
            hoaDon.setTongTien(shoppingCartService.getAmount());
            // Lưu thông tin hóa đơn vào cơ sở dữ liệu
            hoaDonService.add(hoaDon);
            // Chuyển hướng đến trang hiển thị thông tin hóa đơn vừa tạo
            return "redirect:/pay/luu/"+hoaDon.getId();
        } catch (Exception ex) {
            // Nếu có lỗi xảy ra, rollback transaction
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw ex;
        }
    }

        @GetMapping("/luu/{id}")
        public String showHoaDon(@PathVariable("id") UUID id, Model model) {
            // Lấy thông tin hóa đơn từ cơ sở dữ liệu
            HoaDon hoaDon = hoaDonService.findById(id);
            // Kiểm tra xem hóa đơn có tồn tại không
            if (hoaDon == null) {
                return "redirect:/shopping-cart/views";
            }
            // Truyền thông tin hóa đơn vào model để hiển thị trên trang JSP
            model.addAttribute("hoaDon", hoaDon);
            // Trả về tên của trang JSP để hiển thị thông tin hóa đơn
            return "pay/thong-tin-hoa-don";
        }



}