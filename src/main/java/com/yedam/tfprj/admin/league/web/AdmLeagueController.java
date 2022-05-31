package com.yedam.tfprj.admin.league.web;

import com.yedam.tfprj.admin.league.service.AdmLeagueServiceVO;
import com.yedam.tfprj.admin.league.service.LeagueService;
import com.yedam.tfprj.client.league.service.LeagueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class AdmLeagueController {

    @Autowired
    LeagueService admLeagueService;

    @RequestMapping("/adm/league")
    public String league(Model model) {
        model.addAttribute("l", admLeagueService.getLeagueList());
        return "admin/league/league";
    }

    // insert league
    @RequestMapping("/adm/insertLeague")
    public String insertLeague(LeagueVO leagueVO) {
        admLeagueService.insertLeague(leagueVO);

        return "redirect:/adm/league";
    }

    @RequestMapping("/adm/leagueDetail")
    public String leagueDetail(Model model, int lno) {

        // 리그 정보와 리그 참가 신청한 팀 정보를 받아옴
        model.addAttribute("l", admLeagueService.getLeagueDetail(lno));

        // 리그 대진표 정보 가져오기
        model.addAttribute("statusTeam", admLeagueService.getLeagueStatusTable(lno).getLeagueStatusTeamList());

        return "/admin/league/league_detail";
    }

    @RequestMapping("/adm/trophyTest")
    public String trophyTest() {
        return "admin/league/trophyTest";
    }


    // league apply table 에서 데이터 뽑기
    @RequestMapping("/adm/getLeagueApply")
    @ResponseBody
    public AdmLeagueServiceVO getLeagueApply(int leagueId) {

        return admLeagueService.getLeagueApply(leagueId);
    }

    // league 신청한 team list 받기
    @RequestMapping(value = "/adm/getLeagueApplyTeam", method = RequestMethod.POST)
    @ResponseBody
    public AdmLeagueServiceVO getLeagueApplyTeam(@RequestBody Map<String, String> param) {

        return admLeagueService.getLeagueApplyTeam(Integer.parseInt(param.get("teamId")), Integer.parseInt(param.get("leagueId")));
    }

    // league apply status 변경
    @RequestMapping(value = "/adm/setLeagueApplyTeamStatus", method = RequestMethod.POST)
    @ResponseBody
    public void setLeagueApplyTeamStatus(@RequestBody Map<String, String> param) {

        System.out.println("param = " + param);

        admLeagueService.setLeagueApplyTeamStatus(Integer.parseInt(param.get("teamId")), Integer.parseInt(param.get("leagueId")));
    }

    // league_datail page 에서 대진표 그리기
    @RequestMapping(value = "/adm/getLeagueStatusTableTeam", method = RequestMethod.POST)
    @ResponseBody
    public AdmLeagueServiceVO getLeagueStatusTableTeam( @RequestBody List<Map<String, String>> param) {

        // 대진표 생성을 위해 league_status table 에 값 입력
        admLeagueService.insertLeagueStatus(param);

        //

        return null;
    }

}
