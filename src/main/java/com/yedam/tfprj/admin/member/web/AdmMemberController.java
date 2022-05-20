package com.yedam.tfprj.admin.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmMemberController {

    @RequestMapping("/adm/memberList")
    public String admMemberList(){
        return "admin/member/member_list";
    }

    @RequestMapping("/adm/teamList")
    public String admTeamList(){
        return "admin/member/team_list";
    }

}
