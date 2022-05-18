package com.yedam.tfprj.client.common.web;


import com.yedam.tfprj.client.member.service.MemberService;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CliLogInController {

    @Autowired
    MemberService memberService;


    @RequestMapping("/cli/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response, MemberVO vo) {
        // 로그인 처리 과정

        HttpSession session = request.getSession();

        vo = memberService.selectMember(vo);
        String viewPage;

        if (vo != null) {
            //여기서 세션 처리하고
            session.setAttribute("memberId", vo.getMemberId());
            session.setAttribute("member", vo);
            viewPage = "client/common/memberLoginSuccess";
        } else {
            viewPage = "client/common/memberLoginFail";
        }
        return viewPage;
    }

    @RequestMapping("/cli/loginview")
    public String loginview(Model model) {
        return "client/common/login";
    }


}