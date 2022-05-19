package com.yedam.tfprj.client.common.web;


import com.yedam.tfprj.client.member.service.MemberService;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CliLogInController {

    @Autowired
    MemberService memberServiceImpl;


    @RequestMapping("/cli/login")
    public String login(HttpServletRequest request, MemberVO vo) {

        String viewPage;

        // 로그인 처리 과정
        HttpSession session = request.getSession();

        vo = memberServiceImpl.selectMember(request, vo);
        /*model.addAttribute("member", vo);*/

        if (vo != null) {
            viewPage = "client/common/memberLoginSuccess";
        } else {
            viewPage = "client/common/memberLoginFail";
        }
        return viewPage;
    }

    @GetMapping("/cli/idCheck")
    @ResponseBody
    public String idCheck(HttpServletRequest request, String memberId) {

        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId(memberId);

        memberVO = memberServiceImpl.selectMember(request, memberVO);
        if(memberVO != null) {
            return "y";
        } else
            return "n";
    }

    // login page 이동
    @RequestMapping("/cli/loginview")
    public String loginview(Model model) {
        return "client/common/login";
    }


    // 회원가입
    @GetMapping("/cli/signUp")
    public String SignUp(Model model , MemberVO vo){
        return "client/common/signup";
    }

    // 회원가입 처리
    @PostMapping("/cli/insertMember")
    public String insert(MemberVO vo){

       memberServiceImpl.insertMember(vo);
        return "redirect:/cli/loginview";
    }

}