package com.yedam.tfprj.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/adm/index")
    public String admIndex() {
        return "admin/page/home";
    }

    @RequestMapping("/cli/index")
    public String cliIndex() {
        return "client/page/home";
    }

}
