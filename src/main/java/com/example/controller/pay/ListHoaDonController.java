package com.example.controller.pay;

import com.example.entity.*;
import com.example.repository.*;
import com.example.service.HoaDonService;
import com.example.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/hoa-don/")
public class ListHoaDonController {

    @Autowired
    private HoaDonCTRepository hoaDonCTRepository;
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
        return "pay/list-hoa-don";
    }


    @GetMapping("remove/{id}")
    public String deleteHoaDon(Model model, @PathVariable("id") UUID id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).orElse(null);
        if (hoaDon != null) {

            hoaDonCTRepository.deleteAll();
            // Delete the HoaDon
            hoaDonRepository.delete(hoaDon);
        }
        return "redirect:/hoa-don/views";
    }


}