package com.yedam.tfprj.client.member.web;

import com.yedam.tfprj.client.member.mapper.MemberMapper;
import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import com.yedam.tfprj.client.reservation.service.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmMemberController {
    @Autowired
    MemberMapper memberMapper;
    ReservationMapper reservationMapper;
    Reservation rsv;

    @RequestMapping("/cli/myInfo")
    public String cliMyInfo(){
        return "client/member/my_info";
    }

    @RequestMapping("/cli/myScore")
    public String cliMyScore(){
        return "client/member/my_score";
    }

    @RequestMapping("/cli/myLeague")
    public String cliMyLeague(){
        return "client/member/my_league";
    }

    @RequestMapping("/cli/myMessage")
    public String cliMyMessage(){
        return "client/member/my_message";
    }

    @RequestMapping("/cli/myReservation/{memberId}")
    public String cliMyReservation(@PathVariable String memberId, Model model){
        rsv.setMemberId("TEST");
        model.addAttribute("rsList", reservationMapper.findMemberReservation(rsv));
        return "client/member/my_reservation";
    }

    @RequestMapping("cli/myReserVationDetail")
    public String cliMyReservationDetail(){
        return "client/member/my_reservation_detail";
    }

    @RequestMapping("cli/myTrophy")
    public String cliMyTrophy(){
        return "client/member/my_trophy";
    }

    @RequestMapping("/cli/myTeam")
    public String cliMyTeam(){
        return "client/member/my_team";
    }
}
