package com.yedam.tfprj.client.reservation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CliReservationController {
    @RequestMapping("/cli/reservation/room")
    public String reservation(){return "client/reservation/room";}

    @RequestMapping("/cli/reservation/info")
    public String resInfo(){return "client/reservation/info";}
}
