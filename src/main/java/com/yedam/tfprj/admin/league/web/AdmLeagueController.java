package com.yedam.tfprj.admin.league.web;

import com.yedam.tfprj.admin.league.service.AdmLeagueServiceVO;
import com.yedam.tfprj.admin.league.service.LeagueService;
import com.yedam.tfprj.client.league.service.LeagueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("l", admLeagueService.getLeagueDetail(lno));

        return "/admin/league/league_detail";
    }

    @RequestMapping("/adm/trophyTest")
  public String trophyTest() { return "admin/league/trophyTest"; }


    // league apply table 에서 데이터 뽑기
    @RequestMapping("/adm/getLeagueApply")
    @ResponseBody
    public AdmLeagueServiceVO getLeagueApply() {

        return null;
    }


}
