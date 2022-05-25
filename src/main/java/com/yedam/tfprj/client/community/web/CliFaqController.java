package com.yedam.tfprj.client.community.web;

import com.yedam.tfprj.client.community.service.faq.CliFaqService;
import com.yedam.tfprj.client.community.service.faq.CliFaqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CliFaqController {
    @Autowired
    CliFaqService service;

    @RequestMapping("/cli/faq")
    public String CliFaqList(Model model, CliFaqVO vo){
        model.addAttribute("faq", service.CliFaqList(vo));
        return "client/community/faq/faq";
    }
}
