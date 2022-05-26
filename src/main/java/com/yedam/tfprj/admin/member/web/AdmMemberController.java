package com.yedam.tfprj.admin.member.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.client.member.service.MemberService;
import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.team.service.TeamService;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class AdmMemberController {

    @Autowired
    MemberService memberServiceImpl;
    @Autowired
    TeamService teamServiceImpl;
    @RequestMapping("/adm/memberList")
    public String admMemberList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<MemberVO> pageInfo = new PageInfo<MemberVO>(memberServiceImpl.findAll());
        model.addAttribute("pageInfo", pageInfo);
        return "admin/member/member_list";
    }
    @RequestMapping("/adm/gradeUpdate")
    public String admGradeUpdate(MemberVO vo) {
        memberServiceImpl.gradeUpdate(vo);
        return "redirect:/adm/memberList";
    }
    @RequestMapping("/adm/blackList")
    public String admBlackList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<MemberVO> blackInfo = new PageInfo<MemberVO>(memberServiceImpl.findBlack());
        model.addAttribute("blackInfo", blackInfo);
        return "admin/member/black_list";
    }

    @RequestMapping("/adm/blackUpdate")
    public String admBlackUpdate(MemberVO vo){
        memberServiceImpl.blackUpdate(vo);
        return "redirect:/adm/blackList";
    }

    @RequestMapping("/adm/teamList")
    public String admTeamList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TeamVO> teamInfo = new PageInfo<TeamVO>(teamServiceImpl.teamAll());
        model.addAttribute("teamInfo", teamInfo);
        return "admin/member/team_list";
    }

    @RequestMapping("/adm/teamInfo")
    @ResponseBody
    public List<MemberVO> admTeamInfo(MemberVO vo){
        return memberServiceImpl.teamMember(vo);
    }


}


