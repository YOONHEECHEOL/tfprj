package com.yedam.tfprj.client.community.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yedam.tfprj.client.community.service.fm.CliFmService;
import com.yedam.tfprj.client.community.service.fm.CliFmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CliFmController {
    @Autowired
    CliFmService service;

    @RequestMapping("/cli/fm")
    public String CliFmList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model, CliFmVO vo) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CliFmVO> pageInfo = new PageInfo<CliFmVO>(service.CliFmList(vo));
        model.addAttribute("pageInfo", pageInfo);
        return "client/community/fm/fm";
    }

    @RequestMapping("/cli/fmDetail")
    public String fmDetail(Model model, CliFmVO vo) {
        vo.setFNo(vo.getFNo());
        model.addAttribute("fm", service.CliFmSelect(vo)); //디테일 출력
        model.addAttribute("reply", service.CliReplyList(vo)); // 코맨트 리스트
        return "client/community/fm/fm_detail";
    }

    @RequestMapping("/cli/fmAnswerInsert")
    public String fmAnswerInsert(Model model, CliFmVO vo) {
        service.CliFmAnswerInsert(vo); // 코멘트 인서트

        return "redirect:/cli/fmDetail?fNo=" + vo.getFNo();
    }

    @RequestMapping(value = "/cli/fmDelete", method = RequestMethod.GET)
    public String fmDelete(CliFmVO vo) {
        service.CliFmDelete(vo);
        vo.setFNo(vo.getFNo());
        return "redirect:/cli/fm";
    }

    @RequestMapping(value = "/cli/fmUpdate", method = RequestMethod.POST)
    public String fmUpdate(Model model, CliFmVO vo) {
        model.addAttribute("fm", service.CliFmSelect(vo));

        return "client/community/fm/fm_update";
    }

    @RequestMapping("/cli/fmUpdateForm")
    public String CliFmUpdate(Model model, CliFmVO vo) {
        service.CliFmUpdate(vo);
        return "redirect:/cli/fm";
    }


    @RequestMapping("/cli/fmWrite")
    public String CliFmWrite(Model model, CliFmVO vo) {
        model.addAttribute("fm", vo);
        return "/client/community/fm/fmWrite";
    }

    @RequestMapping("/cli/fmInsert")
    public String CliQnaInsert(Model model, CliFmVO vo) {
        service.CliFmInsert(vo);
        return "redirect:/cli/fm";
    }

    //수정 필요
    @RequestMapping("cli/fmAnswerDelete")
    public String AdmFmDelete(Model model, CliFmVO vo) {
        vo.setCNo(vo.getCNo());
        service.CliFmAnswerDelete(vo);


        return "redirect:/adm/fm";
    }


}
