package com.yedam.tfprj.admin.league.web;

import com.yedam.tfprj.admin.league.service.LeagueService;
import com.yedam.tfprj.client.league.service.LeagueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

        System.out.println("========================leagueVO = " + leagueVO);
        admLeagueService.insertLeague(leagueVO);

        return "redirect:/adm/league";
    }

    @RequestMapping("/adm/leagueCreate")
    public String leagueCreate() {
        return "admin/league/league_create";
    }

    @RequestMapping("/adm/trophyTest")
  public String trophyTest() { return "admin/league/trophyTest"; }

}
