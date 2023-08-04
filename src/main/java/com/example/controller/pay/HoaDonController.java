package com.example.controller.pay;

import com.example.entity.*;
import com.example.repository.*;
import com.example.service.impl.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
    private GioHangService gioHangService;
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private ChiTietSPService chiTietSPService;
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
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @GetMapping("views")
    public String viewHoaDon(Model model
    ) {
        model.addAttribute("hoaDonList", hoaDonService.getallHoaDon());
        model.addAttribute("view","/WEB-INF/views/pay/list-hoa-don.jsp");
        return "login/home";
    }


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
            String maHD = UUID.randomUUID().toString();
            hoaDon.setMa(maHD);
            hoaDon.setIdKH(khachHang); // Thêm thông tin khách hàng vào hóa đơn
            hoaDon.setIdNV(nhanVien);  // Thêm thông tin nhân viên vào hóa đơn
            if (voucher != null) {
                hoaDon.setIdVoucher(voucher); // Thêm thông tin giảm giá vào hóa đơn (nếu có)
            }
            hoaDon.setNgayTao(LocalDate.now());
            hoaDon.setNgayThanhToan(LocalDate.now());
            hoaDon.setTrangThai(0); // Đánh dấu hóa đơn chưa được thanh toán
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

            GioHang gioHang = new GioHang();
            String maGH = UUID.randomUUID().toString();
            gioHang.setMa(maGH);
            gioHang.setIdKH(khachHang); // Thêm thông tin khách hàng vào hóa đơn
            gioHang.setIdNV(nhanVien);  // Thêm thông tin nhân viên vào hóa đơn
            gioHang.setTen(khachHang.getTen());
            gioHang.setSdt(khachHang.getSdt());
            gioHang.setDiaChi(khachHang.getDiaChi());
            gioHang.setNgayTao(LocalDate.now());
            gioHang.setNgayThanhToan(LocalDate.now());
            gioHang.setTinhTrang(1); // Đánh dấu hóa đơn chưa được thanh toán
            // Lưu thông tin hóa đơn vào cơ sở dữ liệu
            gioHangRepository.save(gioHang);

            return "redirect:/shopping-cart/views";
        } catch (Exception ex) {
            // Nếu có lỗi xảy ra, rollback transaction
            throw new RuntimeException(ex);
        }
    }

    @PostMapping("thanh-toan")
    public String updateTrangThaiHD(
            @RequestParam("hoaDonId") UUID hoaDonId

    ) {
        // Lấy danh sách các mục giỏ hàng chi tiết
        List<GioHangCT> gioHangCTs = gioHangCTService.getAllItems();
        for (GioHangCT gioHangCT : gioHangCTs) {
            // Lấy chi tiết sản phẩm từ giỏ hàng chi tiết
            ChiTietSP chiTietSP = gioHangCT.getIdChiTietSP();
            if (chiTietSP != null) {
                // Lấy số lượng trong giỏ hàng chi tiết
                int soLuongGioHangCT = gioHangCT.getSoLuong();

                // Cập nhật lại số lượng trong chi tiết sản phẩm
                int soLuongMoi = chiTietSP.getSoLuong() - soLuongGioHangCT;
                chiTietSP.setSoLuong(soLuongMoi);
                chiTietSPRepository.save(chiTietSP);
            }
        }
        // Lấy thông tin hóa đơn từ cơ sở dữ liệu
        HoaDon hoaDon = hoaDonService.findById(hoaDonId);
        // Kiểm tra xem hóa đơn có tồn tại không
        if (hoaDon == null) {
            return "redirect:/shopping-cart/views";
        }
        // Cập nhật trạng thái của hóa đơn thành "paid"
        hoaDon.setTrangThai(1);
        BigDecimal amount =  gioHangCTService.getAmount();
        hoaDon.setTongTien(amount);
        hoaDonService.add(hoaDon);
        ////////////////////////////////////////////////////////////////////////


        // Xóa giỏ hàng sau khi thanh toán thành công
        gioHangCTService.clear();
        return "redirect:/shopping-cart/views";
    }

    @GetMapping("remove/{id}")
    public String deleteHoaDon(Model model, @PathVariable("id") UUID id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).orElse(null);
        if (hoaDon != null) {

            hoaDonCTRepository.deleteAll();
            // Delete the HoaDon
            hoaDonRepository.delete(hoaDon);
        }
        return "redirect:/pay/views";
    }


}