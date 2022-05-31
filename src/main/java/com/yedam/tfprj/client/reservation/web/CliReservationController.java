package com.yedam.tfprj.client.reservation.web;

import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import com.yedam.tfprj.client.reservation.service.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CliReservationController {
    @Autowired
    ReservationMapper reservationMapper;
    @RequestMapping("/cli/reservation/room")
    public String reservation(){
        return "client/reservation/room";
    }

    @RequestMapping(value = "/cli/reservation/info", method = RequestMethod.POST)
    public String resInfo(Reservation reservation, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("memberId") != null){
            reservation.setMemberId((String)session.getAttribute("memberId"));
        }else{
            reservation.setMemberId("비회원");
        }
        reservationMapper.insertReservation(reservation);

        model.addAttribute("reservation", reservation);
        return "client/reservation/info";}

    @RequestMapping("/cli/reservationList")
    public String findReservationList(Model model){
        model.addAttribute("rList",reservationMapper.findReservation());
        return "client/reservation/reservationList";
    }

    @GetMapping("/cli/reservation/reservationCheck")
    @ResponseBody
    public List<Reservation> reservationCheckList(@RequestParam String date, @RequestParam String room){

        return reservationMapper.reservationCheck(date, room);
    }

    @GetMapping("/cli/reservation/teamList")
    @ResponseBody
    public List<String> teamList(){

        return reservationMapper.teamList();
    }




}
