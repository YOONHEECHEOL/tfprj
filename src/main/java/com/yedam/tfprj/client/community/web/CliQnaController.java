package com.yedam.tfprj.client.community.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.client.community.service.qna.CliQnaService;
import com.yedam.tfprj.client.community.service.qna.CliQnaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CliQnaController {

    @Autowired
    CliQnaService service;

    @RequestMapping("/cli/qna")
    public String CliQnaList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model, CliQnaVO vo){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CliQnaVO> pageInfo = new PageInfo<CliQnaVO>(service.CliQnaList(vo));
        model.addAttribute("pageInfo", pageInfo);
        return "client/community/qna/qna";
    }

    @RequestMapping("/cli/qnaDetail")
    public String qnaDetail(Model model, CliQnaVO vo){
        vo.setQNo(vo.getQNo());
        model.addAttribute("qna",service.CliQnaSelect(vo)); //디테일 출력
        model.addAttribute("reply", service.CliReplyList(vo)); // 코맨트 리스트
        return "client/community/qna/qna_detail";
    }

    @RequestMapping("/cli/qnaAnswerInsert")
    public String CliAnswerInsert(Model model, CliQnaVO vo){
        service.CliQnaAnswerInsert(vo); // 코멘트 인서트

        return "redirect:/cli/qnaDetail?qNo="+vo.getQNo();
    }

    @RequestMapping(value = "/cli/qnaDelete", method = RequestMethod.GET)
    public String qnaDelete(CliQnaVO vo){
        service.CliQnaDelete(vo);
        vo.setQNo(vo.getQNo());
        return "redirect:/cli/qna";
    }

    @RequestMapping(value = "/cli/qnaUpdate", method = RequestMethod.POST)
    public String qnaUpdate(Model model, CliQnaVO vo){
        model.addAttribute("qna", service.CliQnaSelect(vo));

        return "client/community/qna/qna_update";
    }

    @RequestMapping("/cli/qnaUpdateForm")
    public String CliQnaUpdate(Model model, CliQnaVO vo){
        service.CliQnaUpdate(vo);
        return "redirect:/cli/qna";
    }


    @RequestMapping("/cli/qnaWrite")
    public String CliQnaWrite(Model model, CliQnaVO vo){
        model.addAttribute("qna", vo);
        return "/client/community/qna/qnaWrite";
    }


    @RequestMapping("/cli/qnaInsert")
    public String CliQnaInsert(Model model, CliQnaVO vo){
        service.CliQnaInsert(vo);
        return "redirect:/cli/qna";
    }

    @RequestMapping("cli/qnaAnswerDelete")
    public String CliQnaDelete(Model model, CliQnaVO vo){
        service.CliQnaAnswerDelete(vo);

        return "redirect:/cli/qna";
    }
}
