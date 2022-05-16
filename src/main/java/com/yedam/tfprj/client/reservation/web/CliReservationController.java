package com.yedam.tfprj.client.reservation.web;

import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import com.yedam.tfprj.client.reservation.service.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CliReservationController {
    @Autowired
    ReservationMapper reservationMapper;
    @RequestMapping("/cli/reservation/room")
    public String reservation(){
        return "client/reservation/room";
    }

    @RequestMapping("/cli/reservation/info")
    public String resInfo(){return "client/reservation/info";}

    @RequestMapping("/reservationList")
    public String findReservationList(Model model){
        model.addAttribute("rList",reservationMapper.findReservation());
        return "client/reservation/reservationList";
    }
}
