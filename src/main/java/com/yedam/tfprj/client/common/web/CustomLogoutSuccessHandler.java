package com.yedam.tfprj.client.common.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.yaml.snakeyaml.util.UriEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("사용자로그아웃 후 ===========================" + request.getHeader("Referer"));
        if(request.getHeader("Referer").startsWith("/cli")){
            response.sendRedirect("/cli/home?message="+ UriEncoder.encode("로그아웃 되었습니다."));
        }else{
            response.sendRedirect("/adm/loginview");
        }

    }
}
