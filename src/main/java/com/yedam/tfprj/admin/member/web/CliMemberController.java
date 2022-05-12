package com.yedam.tfprj.admin.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CliMemberController {

    @RequestMapping("/cli/myInfo")
    public String cliMyInfo(){
        return "client/member/my_info";
    }
    @RequestMapping("/cli/myLeague")
    public String cliMyLeague(){
        return "client/member/my_league";
    }
    @RequestMapping("/cli/myMessage")
    public String cliMyMessage(){
        return "client/member/my_message";
    }
    @RequestMapping("/cli/myReservation")
    public String cliMyReservation(){
        return "client/member/my_reservation";
    }
    @RequestMapping("/cli/myReservationDetail")
    public String cliMyReservationDetail(){
        return "client/member/my_reservation_detail";
    }
    @RequestMapping("/cli/myScore")
    public String cliMyScore(){
        return "client/member/my_score";
    }
    @RequestMapping("/cli/myTeam")
    public String cliMyTeam(){
        return "client/member/my_team";
    }
    @RequestMapping("/cli/myTrophy")
    public String cliMyTrophy(){
        return "client/member/my_trophy";
    }
}
