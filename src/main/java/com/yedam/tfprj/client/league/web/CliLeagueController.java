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

    // 미사용
    @RequestMapping("/cli/leagueApplyDone")
    public String leagueApplyDone() {
        return "client/league/league_apply_done";
    }

    // 미사용
    @RequestMapping("/cli/leaguePay")
    public String leaguePay(Model model, String leagueId, HttpServletRequest request) {

        int lId = Integer.parseInt(leagueId);
        String memberId = request.getSession().getAttribute("memberId").toString();

        // 리그 정보 league
        model.addAttribute("l", leagueServiceImpl.getLeagueDetail(lId, memberId));

        // 내가 지원한 정보 league_apply
        model.addAttribute("ml", leagueServiceImpl.getLeagueApplyMember(lId, memberId));


        return "client/league/league_pay";
    }

    // 미사용
    @RequestMapping("/cli/leaguePayDone")
    public String leaguePayDone(String leagueId, HttpServletRequest request) {

        leagueServiceImpl.payLeague(leagueId, request);

        return "client/league/league_pay_done";
    }

    // 미사용
    @RequestMapping("/cli/leaguePlan")
    public String leaguePlan() {
        return "client/league/league_plan";
    }

    @RequestMapping("/cli/myLeague")
    public String cliMyLeague(HttpServletRequest request, Model model) {

        model.addAttribute("ml", leagueServiceImpl.getMyLeague(request));

        return "client/member/my_league";
    }

    // 신청취소하기
    @RequestMapping("/cli/leagueCancel")
    public String leagueCancel(HttpServletRequest request, int leagueId) {

        // service league apply cancel 처리
        leagueServiceImpl.cancelLeagueApply(request, leagueId);

        return "redirect:/cli/myLeague";
    }

}
