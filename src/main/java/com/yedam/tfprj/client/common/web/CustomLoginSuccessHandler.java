package com.yedam.tfprj.client.common.web;

import com.yedam.tfprj.client.member.mapper.MemberMapper;
import com.yedam.tfprj.client.member.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    MemberMapper memberMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession httpSession = request.getSession();
        MemberVO vo = (MemberVO)authentication.getPrincipal();
        vo=  memberMapper.selectMember(vo);
        httpSession.setAttribute("member", vo);
        httpSession.setAttribute("memberId", vo.getMemberId());
        httpSession.setAttribute("log", "y");
        httpSession.setAttribute("message", vo.getMemberId() + "님 로그인되었습니다.");
        response.sendRedirect("/cli/home");
    }
}
