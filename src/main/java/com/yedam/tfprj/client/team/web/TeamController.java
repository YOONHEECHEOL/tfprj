package com.yedam.tfprj.client.team.web;

import com.yedam.tfprj.client.member.service.MemberVO;
import com.yedam.tfprj.client.team.service.TeamService;
import com.yedam.tfprj.client.team.service.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeamController {

    @Autowired
    TeamService teamServiceImpl;

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

    @GetMapping("/cli/getTeam")
    @ResponseBody
    public TeamVO getTeam(@RequestParam int teamId) {
        return teamServiceImpl.selectTeam(teamId);
    }

    @RequestMapping("/cli/selectTeamMembers")
    @ResponseBody
    public List<MemberVO> selectTeamMembers(@RequestParam int teamId) {
        return  teamServiceImpl.selectTeamMembers(teamId);
    }
}
