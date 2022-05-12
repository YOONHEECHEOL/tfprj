package com.yedam.tfprj.client.team.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamController {

    @RequestMapping("/cli/teamCreate")
    public String cliTeamCreate(){
        return "client/team/team_create";
    }
    @RequestMapping("/cli/teamInfoLeader")
    public String cliTeamInfoLeader(){
        return "client/team/team_info_leader";
    }
    @RequestMapping("/cli/teamInfoMember")
    public String cliTeamInfoMember(){
        return "client/team/team_info_member";
    }
}
