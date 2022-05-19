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

    // login
    @RequestMapping("/cli/login")
    public String login(HttpServletRequest request, MemberVO vo) {

        memberServiceImpl.selectMember(request, vo);

        return "redirect:/cli/home";
    }

    // logout
    @RequestMapping("/cli/logout")
    public String logout(HttpServletRequest request, MemberVO vo) {

        // session invalidate() 처리 및 message 생성
        String returnVal = memberServiceImpl.logoutMember(request, vo);
        memberServiceImpl.logoutMessage(request, returnVal);

        return "redirect:/cli/home";
    }

    // id 중복체크
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

    @GetMapping("/cli/resetMessage")
    @ResponseBody
    public String resetMessage(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("message");

        return "session message 삭제";
    }

}