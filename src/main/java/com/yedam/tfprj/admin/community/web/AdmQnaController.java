package com.yedam.tfprj.admin.community.web;


import com.yedam.tfprj.admin.community.service.qna.AdmQnaService;
import com.yedam.tfprj.admin.community.service.qna.AdmQnaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdmQnaController {

    @Autowired
    AdmQnaService admQnaService;

    @RequestMapping("/adm/qna")
    public String AdmQnaList(Model model, AdmQnaVO vo){

        model.addAttribute("admQna", admQnaService.AdmQnaList(vo));
        return "admin/community/qna/qna";
    }

    @RequestMapping("/adm/qnaDetail")
    public String qnaDetail(Model model, AdmQnaVO vo){
        vo.setQNo(vo.getQNo());
        model.addAttribute("qna",admQnaService.AdmQnaSelect(vo));
        return "admin/community/qna/qna_detail";
    }

    @RequestMapping(value = "/adm/qnaDelete", method = RequestMethod.GET)
    public String qnaDelete(AdmQnaVO vo){
        admQnaService.AdmQnaDelete(vo);
        vo.setQNo(vo.getQNo());
        return "redirect:/adm/qna";
    }

    @RequestMapping(value = "/adm/qnaUpdate", method = RequestMethod.POST)
    public String qnaUpdate(Model model, AdmQnaVO vo){
        model.addAttribute("qna", admQnaService.AdmQnaSelect(vo));

        return "admin/community/qna/qna_update";
    }

    @RequestMapping("/adm/qnaUpdateForm")
    public String AdmQnaUpdate(Model model, AdmQnaVO vo){
        admQnaService.AdmQnaUpdate(vo);
        return "redirect:/adm/qna";
    }

//    @RequestMapping("/adm/noticeWrite")
//    public String AdmQnaWrite(Model model, AdmQnaVO vo){
//        model.addAttribute("Qna", vo);
//        return "/admin/community/qna/qnaWrite";
//    }

    @RequestMapping("/adm/qnaInsert")
    public String AdmQnaInsert(Model model, AdmQnaVO vo){

        return "redirect/adm/qna";
    }

}
