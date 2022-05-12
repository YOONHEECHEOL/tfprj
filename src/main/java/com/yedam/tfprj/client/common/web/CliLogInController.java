package com.yedam.tfprj.client.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CliLogInController {
    @RequestMapping("login")
    public String login(Model model) {
        return "client/common/login";
    }

}
