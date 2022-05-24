package com.yedam.tfprj.admin.reservation.web;

import com.yedam.tfprj.admin.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdmReservationRestController {
    @Autowired
    ReservationService reservationServiceImpl;

    @GetMapping("/adm/reservation/reservation_list")
    public String CalendarJson() {

        return reservationServiceImpl.jsonResList();
    }

    @PostMapping("/adm/reservation/update_payment_cd")
    public int updatePaymentCd(@RequestParam String resId){
        reservationServiceImpl.updatePaymentCd(resId);
        return 1;
    }
}
