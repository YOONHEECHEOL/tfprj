package com.yedam.tfprj.admin.league.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmLeagueController {

    @RequestMapping("/adm/league")
    public String league() {
        return "admin/league/league";
    }

    @RequestMapping("/adm/leagueCreate")
    public String leagueCreate() {
        return "admin/league/league_create";
    }

}
