package com.yedam.tfprj.client.league.web;

import com.yedam.tfprj.client.league.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CliLeagueController {

    @Autowired
    LeagueService leagueServiceImpl;

    @RequestMapping("/cli/league")
    public String league(Model model) {
        model.addAttribute("currentLeagueList", leagueServiceImpl.getLeagueList().getCurrentList());
        model.addAttribute("passedLeagueList", leagueServiceImpl.getLeagueList().getPassedList());
        return "client/league/league";
    }

    @RequestMapping("/cli/leagueDetail")
    public String leagueDetail(@RequestParam int lno, Model model) {

        model.addAttribute("l", leagueServiceImpl.getLeagueDetail(lno));

        return "client/league/league_detail";
    }

    @RequestMapping("/cli/leagueApply")
    public String leagueApply() {
        return "client/league/league_apply";
    }

    @RequestMapping("/cli/leagueApplyDone")
    public String leagueApplyDone() {
        return "client/league/league_apply_done";
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
