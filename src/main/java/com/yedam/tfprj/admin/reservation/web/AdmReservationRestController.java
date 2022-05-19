package com.yedam.tfprj.admin.reservation.web;

import com.yedam.tfprj.admin.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdmReservationRestController {
    @Autowired
    ReservationService reservationServiceImpl;

    @GetMapping("/adm/reservation/reservation_list")
    public String CalendarJson() {

        return reservationServiceImpl.jsonResList();
    }
}
