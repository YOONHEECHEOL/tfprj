package com.yedam.tfprj.admin.league.web;

import com.yedam.tfprj.admin.league.service.LeagueService;
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

    @RequestMapping("/adm/leagueCreate")
    public String leagueCreate() {
        return "admin/league/league_create";
    }

}
