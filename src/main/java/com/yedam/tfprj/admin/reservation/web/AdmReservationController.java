package com.yedam.tfprj.admin.reservation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmReservationController {
    @RequestMapping("/adm/reservation/reservation")
    public String  reservation(){return "admin/reservation/reservation";}

    @RequestMapping("/adm/reservation/reservation_day")
    public String resDay(){return "admin/reservation/reservation_day";}

    @RequestMapping("/adm/reservation/reservation_day_detail")
    public String resDayDetail(){return "admin/reservation/reservation_day_detail";}
}
