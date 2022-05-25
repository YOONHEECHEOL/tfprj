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
        model.addAttribute("date",startStr);

        return "admin/reservation/reservation_day";
    }

    @RequestMapping("/adm/reservation/reservation_day_detail")
    public String resDayDetail(@RequestParam String resId, Model model){
        System.out.println("인포: " + reservationServiceImpl.gameInfo(resId));
        System.out.println("리스트: " + reservationServiceImpl.gameInfoList(resId));
       model.addAttribute("gameInfoList", reservationServiceImpl.gameInfoList(resId));
       model.addAttribute("gameInfo", reservationServiceImpl.gameInfo(resId));
       model.addAttribute("resInfo", reservationServiceImpl.resInfo(resId));
        return "admin/reservation/reservation_day_detail";}
}
