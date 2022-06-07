package com.yedam.tfprj.admin.common.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.yaml.snakeyaml.util.UriEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdmCustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("관리자로그아웃 후 ===========================" + request.getRequestURI().contains("/cli"));
        if(request.getRequestURI().contains("/adm")){
            response.sendRedirect("/adm/loginview");
        }else{
            response.sendRedirect("/cli/loginview");
        }

    }
}
