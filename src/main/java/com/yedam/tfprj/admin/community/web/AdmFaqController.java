package com.yedam.tfprj.admin.community.web;

import com.yedam.tfprj.admin.community.service.faq.AdmFaqService;
import com.yedam.tfprj.admin.community.service.faq.AdmFaqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmFaqController {

    @Autowired
    AdmFaqService service;

    @RequestMapping("/adm/faq")
    public String AdmFmList(Model model, AdmFaqVO vo){

        model.addAttribute("faq", service.AdmFaqList(vo));
        return "admin/community/faq/faq";
    }

    @RequestMapping("/adm/faqWrite")
    public String AdmFaqWrite(Model model, AdmFaqVO vo){

        return "/admin/community/faq/faq_write";
    }

}
