package com.yedam.tfprj.client.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String toHome() {
        return "client/common/home";
    }

}
