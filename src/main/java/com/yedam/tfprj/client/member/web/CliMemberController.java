package com.yedam.tfprj.client.member.web;

import com.yedam.tfprj.client.member.mapper.MemberMapper;
import com.yedam.tfprj.client.member.service.GameVO;
import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.reservation.mapper.ReservationMapper;
import com.yedam.tfprj.client.reservation.service.Reservation;
import com.yedam.tfprj.client.team.mapper.TeamMapper;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;

@Controller
public class CliMemberController {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    TeamMapper teamMapper;
    @RequestMapping("/cli/myInfo")
    public String cliMyInfo(MemberVO vo, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) (session.getAttribute("memberId")));
        model.addAttribute("member", memberMapper.selectMember(vo));
        return "client/member/my_info";
    }

    @RequestMapping("/cli/myInfoUpdateForm")
    public String cliMyInfoUpdateForm(MemberVO vo, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) (session.getAttribute("memberId")));
        model.addAttribute("member", memberMapper.selectMember(vo));
        return "client/member/my_info_update_form";
    }

    @RequestMapping("/cli/myInfoUpdate")
    public String cliMyInfoUpdate(MemberVO vo) {
        memberMapper.updateMember(vo);
        return "redirect:/cli/myInfoUpdateForm";
    }

    @RequestMapping("/cli/myScore")
    public String cliMyScore(Model model, MemberVO vo ,GameVO gvo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setMemberId((String)session.getAttribute("memberId"));
        model.addAttribute("score", memberMapper.selectGame(vo));

        return "client/member/my_score";
    }

    @RequestMapping("/cli/myLeague")
    public String cliMyLeague() {
        return "client/member/my_league";
    }

    @RequestMapping("/cli/myMessage")
    public String cliMyMessage() {
        return "client/member/my_message";
    }

    @RequestMapping("/cli/myReservation/")
    public String cliMyReservation(Reservation rsv, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        rsv.setMemberId((String) (session.getAttribute("memberId")));
        model.addAttribute("rsList", reservationMapper.findMemberReservation(rsv));
        return "client/member/my_reservation";
    }

    @RequestMapping("/cli/myReservationDetail")
    public String cliMyReservationDetail() {
        return "client/member/my_reservation_detail";
    }

    @RequestMapping("/cli/myTrophy")
    public String cliMyTrophy() {
        return "client/member/my_trophy";
    }

    @RequestMapping("/cli/myTeam")
    public String cliMyTeam(MemberVO vo, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        vo.setMemberId((String) (session.getAttribute("memberId")));
        vo = memberMapper.selectMember(vo);
        model.addAttribute("team",teamMapper.selectTeam(vo.getTeamId()));
        return "client/member/my_team";
    }
    @RequestMapping("/cli/myTeamCreateForm")
    public String cliMyTeamCreateForm(){

        return "client/member/my_team_create_form";
    }

    @RequestMapping(value = "/cli/myTeamCreate", method = RequestMethod.POST)
    public String cliMyTeamCreate(TeamVO vo, MemberVO mvo){

        teamMapper.createTeam(vo);
        TeamVO tvo = teamMapper.findTeam(vo);

        System.out.println(tvo.getTeamId());
        mvo.setTeamId(tvo.getTeamId());
        System.out.println(mvo.getTeamId());
        memberMapper.updateMember2(mvo);
        return "redirect:/cli/myTeam";
    }


}
