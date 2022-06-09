package com.yedam.tfprj.client.member.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.tfprj.admin.reservation.service.MemberGameVO;
import com.yedam.tfprj.client.member.service.MemberService;
import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.message.service.MessageVO;
import com.yedam.tfprj.client.message.service.MsgService;
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
import java.io.IOException;
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
    MsgService msgServiceImpl;


    // 내정보 조회
    @RequestMapping("/cli/myInfo")
    public String cliMyInfo(MemberVO vo, Model model, HttpServletRequest request) {
        model.addAttribute("member", memberServiceImpl.findOne(request, vo));
        return "client/member/my_info";
    }

    // 내 정보 수정폼 호출
    @RequestMapping("/cli/myInfoUpdateForm")
    public String cliMyInfoUpdateForm(MemberVO vo, Model model, HttpServletRequest request) {
        model.addAttribute("member", memberServiceImpl.findOne(request, vo));
        return "client/member/my_info_update_form";
    }

    // 내 정보 수정처리
    @RequestMapping("/cli/myInfoUpdate")
    public String cliMyInfoUpdate(MemberVO vo) {
        memberServiceImpl.updateMember(vo);
        return "redirect:/cli/myInfoUpdateForm";
    }

    // 내 기록 조회
    @RequestMapping("/cli/myScore")
    public String cliMyScore(Model model, MemberVO vo, HttpServletRequest request) {
        model.addAttribute("score", memberServiceImpl.selectGame(vo, request));
        return "client/member/my_score";
    }

    // 내 기록 구글차트 데이터 생성
    @RequestMapping("/cli/myScoreJson")
    @ResponseBody
    public List<MemberGameVO> cliMyScore(MemberVO vo, HttpServletRequest request) {
        return memberServiceImpl.selectGame(vo, request);
    }

    //내 메세지 조회
    @RequestMapping("/cli/myMessage")
    public String cliMyMessage(MessageVO messageVO, HttpServletRequest request, Model model) {
        msgServiceImpl.isChkUpdate(messageVO, request);
        model.addAttribute("msg", msgServiceImpl.getMessage(request));
        return "client/member/my_message";
    }

    // 초대 메세지 수락시 팀가입처리
    @RequestMapping("/cli/intoTeam")
    @ResponseBody
    public void cliIntoTeam(MessageVO messageVO, MemberVO vo, HttpServletRequest request) {
        msgServiceImpl.invResUpdate(messageVO, request);
        memberServiceImpl.updateMember2(vo);
    }

    // 초대 메세지 거절시 처리
    @RequestMapping("cli/notIntoTeam")
    @ResponseBody
    public void cliNotIntoTeam(MessageVO messageVO, HttpServletRequest request) {

        System.out.println(">>>messageVO = " + messageVO);

        msgServiceImpl.invResUpdate(messageVO, request);
    }

    // 내 예약 조회
    @RequestMapping("/cli/myReservation")
    public String cliMyReservation(Reservation rsv, Model model, HttpServletRequest request) {
        model.addAttribute("rsList", cliReservationServiceImpl.findMemberReservation(rsv, request));
        return "client/member/my_reservation";
    }

    // 내 예약 상세조회
    @RequestMapping("/cli/myReservationDetail")
    public String cliMyReservationDetail() {
        return "client/member/my_reservation_detail";
    }

    //내 트로피
    @RequestMapping("/cli/myTrophy")
    public String cliMyTrophy() {
        return "client/member/my_trophy";
    }

    //내 팀 정보 조회
    @RequestMapping("/cli/myTeam")
    public String cliMyTeam(MemberVO vo, Model model, HttpServletRequest request) {
        vo = memberServiceImpl.findOne(request, vo);
        model.addAttribute("team", teamServiceImpl.selectTeam(vo.getTeamId()));
        return "client/member/my_team";
    }

    //팀 생성폼 호출
    @RequestMapping("/cli/myTeamCreateForm")
    public String cliMyTeamCreateForm() {

        return "client/member/my_team_create_form";
    }

    //팀 생성 처리
    @RequestMapping(value = "/cli/myTeamCreate", method = RequestMethod.POST)
    public String cliMyTeamCreate(TeamVO vo, MemberVO mvo, HttpServletRequest request) {
        teamServiceImpl.createTeam(vo);
        TeamVO tvo = teamServiceImpl.findTeam(vo, request);
        mvo.setTeamId(tvo.getTeamId());
        memberServiceImpl.updateMember2(mvo);
        return "redirect:/cli/myTeam";
    }

    //팀원 초대 시 memberId 검색 기능
    @RequestMapping("/cli/searchMember")
    @ResponseBody
    public List<MemberVO> cliSearchMember(MemberVO vo) {
        return memberServiceImpl.searchMember(vo);
    }

    @RequestMapping("/cli/releaseTeam")
    public String cliReleaseTeam(MemberVO vo) {
        memberServiceImpl.releaseTeam(vo);
        return "redirect:/cli/teamInfoLeader";
    }
}
