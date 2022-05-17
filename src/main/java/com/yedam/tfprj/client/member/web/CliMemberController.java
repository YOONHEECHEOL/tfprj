package com.yedam.tfprj.client.member.web;

import com.yedam.tfprj.client.member.mapper.MemberMapper;
import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import com.yedam.tfprj.client.reservation.service.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CliMemberController {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    ReservationMapper reservationMapper;


    @RequestMapping("/cli/myInfo")
    public String cliMyInfo(MemberVO vo, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        vo.setMemberId((String)(session.getAttribute("memberId")));
        model.addAttribute("member", memberMapper.findOne(vo));
        return "client/member/my_info";
    }
    @RequestMapping("/cli/myInfoUpdateForm")
    public String cliMyInfoUpdateForm(MemberVO vo, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        vo.setMemberId((String)(session.getAttribute("memberId")));
        model.addAttribute("member", memberMapper.findOne(vo));
        return "client/member/my_info_update_form";
    }
    @RequestMapping("/cli/myInfoUpdate")
    public String cliMyInfoUpdate(MemberVO vo,  Model model, HttpServletRequest request){
        vo.setPassword(request.getParameter("password"));
        vo.setTel(request.getParameter("tel"));
        return "client/member/my_info_update_form";
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

    @RequestMapping("/cli/myReservation/")
    public String cliMyReservation(Reservation rsv , Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        rsv.setMemberId((String)(session.getAttribute("memberId")));
        model.addAttribute("rsList", reservationMapper.findMemberReservation(rsv));
        return "client/member/my_reservation";
    }

    @RequestMapping("cli/myReservationDetail")
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
