package com.yedam.tfprj.client.league.web;

import com.yedam.tfprj.client.league.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CliLeagueController {

    @Autowired
    LeagueService leagueServiceImpl;

    @RequestMapping("/cli/league")
    public String league(Model model, HttpServletRequest request) {
        model.addAttribute("currentLeagueList", leagueServiceImpl.getLeagueList(request).getCurrentList());
        model.addAttribute("passedLeagueList", leagueServiceImpl.getLeagueList(request).getPassedList());
        return "client/league/league";
    }

    @RequestMapping("/cli/leagueDetail")
    public String leagueDetail(@RequestParam int lno, Model model, HttpServletRequest request) {

        model.addAttribute("l", leagueServiceImpl.getLeagueDetail(lno, request.getSession().getAttribute("memberId").toString()));

        return "client/league/league_detail";
    }

    @RequestMapping(value = "/cli/leagueApply", method = RequestMethod.POST)
    public String leagueApply(int lno, Model model, HttpServletRequest request, String formVal) {

        model.addAttribute("selectedMember", leagueServiceImpl.getLeagueParticipatedMember(formVal));
        model.addAttribute("l", leagueServiceImpl.getLeagueDetail(lno, request.getSession().getAttribute("memberId").toString()));
        
        // insert 처리
        leagueServiceImpl.insertLeagueApply(leagueServiceImpl.getLeagueDetail(lno, request.getSession().getAttribute("memberId").toString()) ,leagueServiceImpl.getLeagueParticipatedMember(formVal));

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

    @RequestMapping("/cli/myLeague")
    public String cliMyLeague(HttpServletRequest request, Model model) {

        model.addAttribute("ml", leagueServiceImpl.getMyLeague(request));

        return "client/member/my_league";
    }

}
