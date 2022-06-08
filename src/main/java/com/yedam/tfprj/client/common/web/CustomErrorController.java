package com.yedam.tfprj.client.common.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class CustomErrorController implements ErrorController {

    private String VIEW_PATH = "/errors/";

    @ExceptionHandler(Throwable.class)
    @RequestMapping("/error")
    public String errorPage(HttpServletRequest request, Model model) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        String errorCode = status.toString();
//
//        model.addAttribute("errorMsg", "asdf");

        if(status != null) {
            int statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.FORBIDDEN.value()){
                return VIEW_PATH + "403";
            }
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return VIEW_PATH + "404";
            }
            if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                return VIEW_PATH + "500";
            }
        }

        return "error";
    }



}

