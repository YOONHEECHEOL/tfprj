package com.yedam.tfprj.admin.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmCommonController {

    @RequestMapping("/adm/index")
    public String admIndex() {
        return "admin/common/home";
    }

    @RequestMapping("/adm/login")
    public String admLogin(){
        return "admin/common/login";}
}
