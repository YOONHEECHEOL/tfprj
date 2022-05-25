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
        //System.out.println(service.AdmFaqList(vo));
        model.addAttribute("faq", service.AdmFaqList(vo));
        return "admin/community/faq/faq";
    }

    @RequestMapping("/adm/faqWrite")
    public String AdmFaqWrite(Model model, AdmFaqVO vo){
        model.addAttribute("title", service.AdmFaqTitleList(vo));
        model.addAttribute("faq", vo);
        return "/admin/community/faq/faq_write";
    }

    @RequestMapping("/adm/faqInsert")
    public String AdmFaqInsert(Model model, AdmFaqVO vo){
        service.AdmFaqInsert(vo);
        return "redirect:/adm/faq";
    }

    @RequestMapping("/adm/faqTitleInsert")
    public String AdmFaqTitleInsert(Model model, AdmFaqVO vo){
        service.AdmFaqTitleInsert(vo);
        return "redirect:/adm/faq";
    }

}
