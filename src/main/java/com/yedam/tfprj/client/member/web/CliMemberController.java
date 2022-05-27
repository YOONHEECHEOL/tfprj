package com.yedam.tfprj.client.member.web;

import com.yedam.tfprj.client.member.service.MemberService;
import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.message.mapper.MsgMapper;
import com.yedam.tfprj.client.message.service.MessageVO;
import com.yedam.tfprj.client.reservation.service.CliReservationService;
import com.yedam.tfprj.client.reservation.service.Reservation;
import com.yedam.tfprj.client.team.service.TeamService;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CliMemberController {
    @Autowired
    MemberService memberServiceImpl;
    @Autowired
    CliReservationService cliReservationServiceImpl;
    @Autowired
    TeamService teamServiceImpl;

    @Autowired
    MsgMapper msgMapper;

    @RequestMapping("/cli/myInfo")
    public String cliMyInfo(MemberVO vo, Model model, HttpServletRequest request) {
        model.addAttribute("member", memberServiceImpl.findOne(request,vo));
        return "client/member/my_info";
    }

    @RequestMapping("/cli/myInfoUpdateForm")
    public String cliMyInfoUpdateForm(MemberVO vo, Model model, HttpServletRequest request) {
        model.addAttribute("member", memberServiceImpl.findOne(request,vo));
        return "client/member/my_info_update_form";
    }

    @RequestMapping("/cli/myInfoUpdate")
    public String cliMyInfoUpdate(MemberVO vo) {
        memberServiceImpl.updateMember(vo);
        return "redirect:/cli/myInfoUpdateForm";
    }

    @RequestMapping("/cli/myScore")
    public String cliMyScore(Model model, MemberVO vo, HttpServletRequest request) {
        model.addAttribute("score", memberServiceImpl.selectGame(vo, request));
        return "client/member/my_score";
    }

//    @RequestMapping("/cli/myLeague")
//    public String cliMyLeague() {
//        return "client/member/my_league";
//    }

    @RequestMapping("/cli/myMessage")
    public String cliMyMessage(HttpServletRequest request, Model model) {

        List<MessageVO> list = msgMapper.getMessage(request.getSession().getAttribute("memberId").toString());

        model.addAttribute("msg", list);
        System.out.println(list);
        return "client/member/my_message";
    }

    @RequestMapping("/cli/intoTeam")
    @ResponseBody
    public void cliIntoTeam(MemberVO vo){
        memberServiceImpl.updateMember2(vo);
    }

    @RequestMapping("/cli/myReservation")
    public String cliMyReservation(Reservation rsv, Model model, HttpServletRequest request) {
        model.addAttribute("rsList", cliReservationServiceImpl.findMemberReservation(rsv,request));
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
        vo = memberServiceImpl.findOne(request,vo);
        model.addAttribute("team", teamServiceImpl.selectTeam(vo.getTeamId()));
        return "client/member/my_team";
    }

    @RequestMapping("/cli/myTeamCreateForm")
    public String cliMyTeamCreateForm() {

        return "client/member/my_team_create_form";
    }

    @RequestMapping(value = "/cli/myTeamCreate", method = RequestMethod.POST)
    public String cliMyTeamCreate(TeamVO vo, MemberVO mvo,HttpServletRequest request ) {
        teamServiceImpl.createTeam(vo);
        TeamVO tvo = teamServiceImpl.findTeam(vo,request);
        mvo.setTeamId(tvo.getTeamId());
        memberServiceImpl.updateMember2(mvo);
        return "redirect:/cli/myTeam";
    }

    @RequestMapping("/cli/searchMember")
    @ResponseBody
    public List<MemberVO> cliSearchMember(MemberVO vo) {
        return memberServiceImpl.searchMember(vo);
    }
}
