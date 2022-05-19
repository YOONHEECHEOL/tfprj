package com.yedam.tfprj.admin.community.web;


import com.yedam.tfprj.admin.community.service.qna.AdmQnaService;
import com.yedam.tfprj.admin.community.service.qna.AdmQnaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmQnaController {

    @Autowired
    AdmQnaService service;

    @RequestMapping("/adm/qna")
    public String AdmQnaList(Model model, AdmQnaVO vo){

        model.addAttribute("admQna", service.AdmQnaList(vo));
        return "admin/community/qna/qna";
    }

}
