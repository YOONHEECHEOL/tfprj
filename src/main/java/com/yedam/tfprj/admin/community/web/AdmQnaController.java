package com.yedam.tfprj.admin.community.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.admin.community.service.qna.AdmQnaService;
import com.yedam.tfprj.admin.community.service.qna.AdmQnaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdmQnaController {

    @Autowired
    AdmQnaService service;

    @RequestMapping("/adm/qna")
    public String AdmQnaList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model, AdmQnaVO vo){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<AdmQnaVO> pageInfo = new PageInfo<AdmQnaVO>(service.AdmQnaList(vo));
        model.addAttribute("pageInfo", pageInfo);
        return "admin/community/qna/qna";
    }

    @RequestMapping("/adm/qnaDetail")
    public String qnaDetail(Model model, AdmQnaVO vo){
        service.AdmQnaViewCount(vo.getQNo());
        vo.setQNo(vo.getQNo());
        model.addAttribute("qna",service.AdmQnaSelect(vo)); //디테일 출력
        model.addAttribute("reply", service.AdmReplyList(vo)); // 코맨트 리스트
        return "admin/community/qna/qna_detail";
    }

    @RequestMapping("/adm/qnaAnswerInsert")
    public String qnaAnswerInsert(Model model, AdmQnaVO vo){
        service.AdmQnaAnswerInsert(vo); // 코멘트 인서트

        return "redirect:/adm/qnaDetail?qNo="+vo.getQNo();
    }

    @RequestMapping(value = "/adm/qnaDelete", method = RequestMethod.GET)
    public String qnaDelete(AdmQnaVO vo){
        service.AdmQnaDelete(vo);
        vo.setQNo(vo.getQNo());
        return "redirect:/adm/qna";
    }

    @RequestMapping(value = "/adm/qnaUpdate", method = RequestMethod.POST)
    public String qnaUpdate(Model model, AdmQnaVO vo){
        model.addAttribute("qna", service.AdmQnaSelect(vo));

        return "admin/community/qna/qna_update";
    }

    @RequestMapping("/adm/qnaUpdateForm")
    public String AdmQnaUpdate(Model model, AdmQnaVO vo){
        service.AdmQnaUpdate(vo);
        return "redirect:/adm/qna";
    }


    @RequestMapping("/adm/qnaWrite")
    public String AdmQnaWrite(Model model, AdmQnaVO vo){
        model.addAttribute("qna", vo);
        return "/admin/community/qna/qna_write";
    }


    @RequestMapping("/adm/qnaInsert")
    public String AmdQnaInsert(Model model, AdmQnaVO vo){
        service.AdmQnaInsert(vo);
        return "redirect:/adm/qna";
    }
    
    @RequestMapping("adm/qnaAnswerDelete")
    public String AdmQnaDelete(Model model, AdmQnaVO vo){
        service.AdmQnaAnswerDelete(vo);

        return "redirect:/adm/qna";
    }


}
