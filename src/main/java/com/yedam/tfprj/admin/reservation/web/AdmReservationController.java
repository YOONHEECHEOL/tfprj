package com.yedam.tfprj.admin.reservation.web;

import com.yedam.tfprj.admin.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdmReservationController {
    @Autowired
    ReservationService reservationServiceImpl;
    @RequestMapping("/adm/reservation/reservation")
    public String  reservation(){return "admin/reservation/reservation";}

    @RequestMapping("/adm/reservation/reservation_day")
    public String resDay(@RequestParam String startStr, Model model){
        System.out.println(startStr);
        model.addAttribute("dayResList",reservationServiceImpl.dayResList(startStr));

        return "admin/reservation/reservation_day";
    }

    @RequestMapping("/adm/reservation/reservation_day_detail")
    public String resDayDetail(){return "admin/reservation/reservation_day_detail";}
}
