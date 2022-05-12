package com.yedam.tfprj.client.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmMemberController {

    @RequestMapping("/adm/memberList")
    public String admMemberList(){
        return "admin/member/member_list";
    }

    @RequestMapping("/admTeamList")
    public String admTeamList(){
        return "admin/member/team_list";
    }
}
