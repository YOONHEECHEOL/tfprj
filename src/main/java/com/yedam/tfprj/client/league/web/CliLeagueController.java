package com.yedam.tfprj.client.league.web;

import com.yedam.tfprj.client.league.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CliLeagueController {

    @Autowired
    LeagueService leagueServiceImpl2;

    @RequestMapping("/cli/league")
    public String league() {
        return "client/league/league";
    }

    @RequestMapping("/cli/leagueApply")
    public String leagueApply() {
        return "client/league/league_apply";
    }

    @RequestMapping("/cli/leagueApplyDone")
    public String leagueApplyDone() {
        return "client/league/league_apply_done";
    }

    @RequestMapping("/cli/leagueDetail")
    public String leagueDetail() {
        return "client/league/league_detail";
    }

    @RequestMapping("/cli/leaguePay")
    public String leaguePay() {
        return "client/league/league_pay";
    }

    @RequestMapping("/cli/leaguePayDone")
    public String leaguePayDone() {
        return "client/league/league_pay_done";
    }

    @RequestMapping("/cli/leaguePlan")
    public String leaguePlan() {
        return "client/league/league_plan";
    }

}
