package com.yedam.tfprj.client.common.web;

import com.yedam.tfprj.client.common.service.CodeVO;
import com.yedam.tfprj.client.common.service.ConvertCommonCodeService;
import com.yedam.tfprj.client.common.service.HomeService;
import com.yedam.tfprj.client.community.service.notice.CliNoticeVO;
import com.yedam.tfprj.client.league.service.LeagueVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

  @Autowired
  HomeService homeServiceImpl;

  @Autowired
  ConvertCommonCodeService convertCommonCodeServiceImpl;

  @RequestMapping("/")
  public String toHome() {
    return "redirect:/cli/home";
  }

  @RequestMapping("/cli/home")
  public String toClientHome(HttpServletRequest request) {
    // login 임시 체크
    HttpSession session = request.getSession();

    if (session.getAttribute("log") == null) {
      session.setAttribute("log", "null");
    }
    return "client/common/home";
  }

  @RequestMapping(value = "/convertCommonCode", method = RequestMethod.GET)
  @ResponseBody
  public CodeVO convertCommonCode(@RequestParam(value = "code") String code) {

    return convertCommonCodeServiceImpl.convertCode(code);
  }

  @RequestMapping("/cli/chkResNow")
  @ResponseBody
  public List<Map<String, String>> chkResNow() {

    return homeServiceImpl.chkResNow();
  }

  @RequestMapping("/cli/noticeListHome")
  @ResponseBody
  public List<CliNoticeVO> noticeListHome() {
    return homeServiceImpl.getHomeNoticeList();
  }

  @RequestMapping("/cli/leagueListHome")
  @ResponseBody
  public List<LeagueVO> leagueListHome() {
    return homeServiceImpl.getHomeLeagueList();
  }

}
