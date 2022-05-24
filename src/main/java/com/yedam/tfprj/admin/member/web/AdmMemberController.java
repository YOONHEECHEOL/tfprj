package com.yedam.tfprj.admin.member.web;



import com.yedam.tfprj.client.member.service.MemberService;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AdmMemberController {

    @Autowired
    MemberService memberServiceImpl;

    @RequestMapping("/adm/memberList")
    public String admMemberList(Model model) {
        model.addAttribute("list", memberServiceImpl.selectAll());
        return "admin/member/member_list";
    }

    @RequestMapping("/adm/gradeUpdate")
    public String admGradeUpdate(MemberVO vo) {
        memberServiceImpl.gradeUpdate(vo);
        return "redirect:/adm/memberList";
    }

    @RequestMapping("/adm/teamList")
    public String admTeamList() {
        return "admin/member/team_list";
    }


}


