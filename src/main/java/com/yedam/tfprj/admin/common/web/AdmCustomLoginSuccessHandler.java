package com.yedam.tfprj.admin.common.web;

import com.yedam.tfprj.admin.worker.mapper.WorkerMapper;
import com.yedam.tfprj.admin.worker.service.WorkerVO;
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

public class AdmCustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    WorkerMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession httpSession = request.getSession();
        WorkerVO vo = (WorkerVO) authentication.getPrincipal();
        httpSession.setAttribute("worker", vo);
        httpSession.setAttribute("workerId", vo.getWorkerId());
        httpSession.setAttribute("log", "y");
        httpSession.setAttribute("message", vo.getWorkerId() + "님 로그인되었습니다.");
        httpSession.setAttribute("positionCd", vo.getPositionCd());
        response.sendRedirect("/adm/index");
    }
}
