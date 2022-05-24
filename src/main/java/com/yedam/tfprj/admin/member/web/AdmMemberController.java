package com.yedam.tfprj.admin.member.web;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.client.member.service.MemberService;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdmMemberController {

    @Autowired
    MemberService memberServiceImpl;

    @RequestMapping("/adm/memberList")
    public String admMemberList(@RequestParam(defaultValue = "1") int pageNum,
                                @RequestParam(defaultValue = "10") int pageSize, Model model) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<MemberVO> pageInfo = new PageInfo<MemberVO>(memberServiceImpl.findAll());
        model.addAttribute("pageInfo", pageInfo);
        PageInfo<MemberVO> blackInfo = new PageInfo<MemberVO>(memberServiceImpl.findBlack());
        model.addAttribute("blackInfo", blackInfo);
        return "admin/member/member_list";
    }

    @RequestMapping("/adm/gradeUpdate")
    public String admGradeUpdate(MemberVO vo) {
        memberServiceImpl.gradeUpdate(vo);
        return "redirect:/adm/list";
    }

    @RequestMapping("/adm/teamList")
    public String admTeamList() {
        return "admin/member/team_list";
    }


}


