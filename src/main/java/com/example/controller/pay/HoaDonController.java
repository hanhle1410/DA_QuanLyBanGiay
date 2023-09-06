package com.example.controller.pay;

import com.example.entity.*;
import com.example.repository.HoaDonCTRepository;
import com.example.repository.TaiKhoanRepository;
import com.example.repository.VoucherRepository;
import com.example.service.HoaDonService;
import com.example.service.KhachHangService;
import com.example.service.GioHangCTService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/pay/")
public class HoaDonController {
    @Autowired
    private HoaDonCTRepository hoaDonCTRepository;
    @Autowired
    private GioHangCTService gioHangCTService;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private VoucherRepository voucherRepository;

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("luu")
    public String createOrUpdateHoaDon(Model model,
                                       @RequestParam("ten") String ten,
                                       @RequestParam("sdt") String sdt,
                                       @RequestParam(value = "idVoucher", required = false) Voucher voucherId,
                                       HttpSession session
    ) {
        try {
            // Thêm voucher (nếu có)
            Voucher voucher = null;
            if (voucherId != null) {
                voucher = voucherRepository.findById(voucherId.getId()).orElse(null);
            }

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
            hoaDon.setIdKH(khachHang); // Thêm thông tin khách hàng vào hóa đơn
            hoaDon.setIdNV(nhanVien);  // Thêm thông tin nhân viên vào hóa đơn
            if (voucher != null) {
                hoaDon.setIdVoucher(voucher); // Thêm thông tin giảm giá vào hóa đơn (nếu có)
            }
            hoaDon.setNgayTao(LocalDate.now());
            hoaDon.setNgayThanhToan(LocalDate.now());
            hoaDon.setTrangThai(0); // Đánh dấu hóa đơn chưa được thanh toán
            BigDecimal amount =  gioHangCTService.getAmount();
            if (amount.compareTo(BigDecimal.ZERO) == 0) {
                model.addAttribute("errorMessage", "Không thể tạo hóa đơn với giỏ hàng trống.");
                return "redirect:/shopping-cart/views";
            }
            BigDecimal tongTien = amount;
            if (voucher != null) {
                BigDecimal giamGia = voucher.getGiamGia();
                BigDecimal soTienGiam = tongTien.multiply(giamGia).divide(BigDecimal.valueOf(100));
                tongTien = tongTien.subtract(soTienGiam);
            }
            hoaDon.setTongTien(tongTien);

            // Lưu thông tin hóa đơn vào cơ sở dữ liệu
            hoaDonService.add(hoaDon);

            List<GioHangCT> gioHangCTs =  gioHangCTService.getAllItems();
            for (GioHangCT gioHangCT : gioHangCTs) {
                ChiTietSP chiTietSP = gioHangCT.getIdChiTietSP();
                HoaDonCT hoaDonCT = new HoaDonCT();
                hoaDonCT.setIdHoaDon(hoaDon);
                hoaDonCT.setIdChiTietSP(chiTietSP); // Sửa lỗi sai gán id
                hoaDonCT.setSoLuong(gioHangCT.getSoLuong());
                hoaDonCT.setDonGia(gioHangCT.getDonGia());
                hoaDonCTRepository.save(hoaDonCT);
            }

            // Xóa giỏ hàng sau khi tạo hóa đơn thành công
            gioHangCTService.clear();

            // Chuyển hướng đến trang hiển thị thông tin hóa đơn vừa tạo
            return "redirect:/pay/luu/"+hoaDon.getId();
        } catch (Exception ex) {
            // Nếu có lỗi xảy ra, rollback transaction
            throw new RuntimeException(ex);
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

    @PostMapping("thanh-toan")
    public String updateTrangThaiHD(
            @RequestParam("hoaDonId") UUID hoaDonId
    ) {
        // Lấy thông tin hóa đơn từ cơ sở dữ liệu
        HoaDon hoaDon = hoaDonService.findById(hoaDonId);
        // Kiểm tra xem hóa đơn có tồn tại không
        if (hoaDon == null) {
            return "redirect:/shopping-cart/views";
        }
        // Cập nhật trạng thái của hóa đơn thành "paid"
        hoaDon.setTrangThai(1);
        hoaDonService.add(hoaDon);
        return "redirect:/shopping-cart/views";
    }




}