package com.yedam.tfprj.admin.community.web;

import com.yedam.tfprj.admin.community.service.fm.AdmFmService;
import com.yedam.tfprj.admin.community.service.fm.AdmFmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdmFmController {
    @Autowired
    AdmFmService service;

    @RequestMapping("/adm/fm")
    public String AdmFmList(Model model, AdmFmVO vo){

        model.addAttribute("admFm", service.AdmFmList(vo));
        return "admin/community/fm/fm";
    }

    @RequestMapping("/adm/fmDetail")
    public String fmDetail(Model model, AdmFmVO vo){
        vo.setFNo(vo.getFNo());
        model.addAttribute("fm",service.AdmFmSelect(vo)); //디테일 출력
        model.addAttribute("reply", service.AdmReplyList(vo)); // 코맨트 리스트
        return "admin/community/fm/fm_detail";
    }

    @RequestMapping("/adm/fmAnswerInsert")
    public String fmAnswerInsert(Model model, AdmFmVO vo){
        service.AdmFmAnswerInsert(vo); // 코멘트 인서트

        return "redirect:/adm/fmDetail?fNo="+vo.getFNo();
    }

    @RequestMapping(value = "/adm/fmDelete", method = RequestMethod.GET)
    public String fmDelete(AdmFmVO vo){
        service.AdmFmDelete(vo);
        vo.setFNo(vo.getFNo());
        return "redirect:/adm/fm";
    }

    @RequestMapping(value = "/adm/fmUpdate", method = RequestMethod.POST)
    public String fmUpdate(Model model, AdmFmVO vo){
        model.addAttribute("fm", service.AdmFmSelect(vo));

        return "admin/community/fm/fm_update";
    }

    @RequestMapping("/adm/fmUpdateForm")
    public String AdmFmUpdate(Model model, AdmFmVO vo){
        service.AdmFmUpdate(vo);
        return "redirect:/adm/fm";
    }


    @RequestMapping("/adm/fmWrite")
    public String AdmFmWrite(Model model, AdmFmVO vo){
        model.addAttribute("fm", vo);
        return "/admin/community/fm/fmWrite";
    }

    @RequestMapping("/adm/fmInsert")
    public String AmdQnaInsert(Model model, AdmFmVO vo){
        service.AdmFmInsert(vo);
        return "redirect:/adm/fm";
    }

    //수정 필요
    @RequestMapping("adm/fmAnswerDelete")
    public String AdmFmDelete(Model model, AdmFmVO vo){
        vo.setCNo(vo.getCNo());
        service.AdmFmAnswerDelete(vo);


        return "redirect:/adm/fm";
    }
}